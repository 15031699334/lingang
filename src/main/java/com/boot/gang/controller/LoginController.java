package com.boot.gang.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.gang.entity.User;
import com.boot.gang.service.*;
import com.boot.gang.util.*;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;

/**
 * @ClassName: lingang
 * @description: 登录/注册
 * @author: dongxiangwei
 * @create: 2020-01-02 16:40
 **/
@Controller
@RequestMapping("/linU")
public class LoginController {
    private Logger logger = LoggerFactory.getLogger(LoginController.class);
    @Autowired
    private LoginService loginService;
    @Autowired
    private CommonService commonService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private RedisUtil redisUtil;
    @Autowired
    private MsgUtil msgUtil;
    @Autowired
    private UploadFileUtil uploadFileUtil;
    @Autowired
    private ConfigService configService;
    @Autowired
    private UserService userService;

    //        腾讯参数          *-----------------------------------*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-
    private String AppID = "101876285";
    private  String AppSecret = "383944da3405ad4fe90e72e1eac4f37a";

    //登录
    @ResponseBody
    @PostMapping("/login")
    public JSONObject login(@RequestBody JSONObject json){
        String phone = json.getString("phone");
        User user = loginService.findByPhone(phone);
        if (json.containsKey("code")){              // 手机号验证码登录
            String code = json.getString("code");
            try {
                String codeRedis = redisUtil.get(phone).toString();
                if (!code.equals(codeRedis)) {
                    return msgUtil.jsonErrorMsg("验证码错误, 请重新输入");
                }
            } catch (Exception e) {
                return msgUtil.jsonErrorMsg("此电话号未发送验证码");
            }
            String token = tokenService.getToken(user);     // 生成token
            return  msgUtil.jsonSuccessMsg("登录成功", "token", token);
        }else {             // 手机号密码登录
            if(user == null){
                return msgUtil.jsonErrorMsg("登录失败,用户不存在");
            }else {
                if (!user.getcPassword().equals(json.getString("password"))){
                    return msgUtil.jsonErrorMsg("登录失败,密码错误");
                }else {
                    String token = tokenService.getToken(user);     // 生成token

                    if (json.containsKey("openid") && !json.get("openid").equals("")) {
                        // https://api.weixin.qq.com/sns/userinfo?access_token=ACCESS_TOKEN&openid=OPENID
                        String openid = json.getString("openid");
                        String access_token = json.getString("access_token");
                        if (json.containsKey("bindType")){
                            // 首次更新头像
                            String reverseGetClient = HttpUtil.excuteGetClient("https://graph.qq.com/user/get_user_info", "?access_token=" + access_token + "&openid=" + openid + "&oauth_consumer_key=" + AppID, null);
                            JSONObject reverseJson = JSONObject.parseObject(reverseGetClient);
                            logger.info(reverseJson.toJSONString());
                            if (reverseJson.get("ret").toString().equals("0")){
                                logger.info("开始修改用户信息");

                                if (StringUtil.isNullOrEmpty(user.getcNickname())) {
                                    user.setcUsername(reverseJson.getString("nickname"));
                                }
                                if (StringUtil.isNullOrEmpty(user.getcLogo())){
                                    user.setcLogo(reverseJson.getString("figureurl_qq_1"));
                                }
                                user.setQqOpenid(openid);
                                try {
                                    commonService.update(user, "User");
                                    logger.info("结束修改用户信息");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return msgUtil.jsonErrorMsg("绑定失败");
                                }
                            }
                        } else { // 微信
                            // 首次更新头像
                            String reverseGetClient = HttpUtil.excuteGetClient("https://api.weixin.qq.com/sns/userinfo", "?access_token=" + access_token + "&openid=" + openid, null);
                            JSONObject reverseJson = JSONObject.parseObject(StringUtil.convertEncodingFormat(reverseGetClient, "iso-8859-1", "UTF-8"));
                            logger.info(reverseJson.toJSONString());
                            if (!reverseJson.containsKey("errcode")){
                                logger.info("开始修改用户信息");

                                if (StringUtil.isNullOrEmpty(user.getcNickname())) {
                                    user.setcUsername(reverseJson.getString("nickname"));
                                }
                                user.setcLogo(reverseJson.getString("headimgurl"));
                                user.setcOpenid(openid);
                                try {
                                    commonService.update(user, "User");
                                    logger.info("结束修改用户信息");
                                } catch (Exception e) {
                                    e.printStackTrace();
                                    return msgUtil.jsonErrorMsg("绑定失败");
                                }
                            }
                        }
                    }
                    return msgUtil.jsonSuccessMsg("登录成功", "token", token);
                }
            }
        }
    }
    /**
     * @Description     // 找回密码
     * @param
     * @return com.alibaba.fastjson.JSONObject
     * @Author dongxiangwei
     * @Date 19:14 2020/1/16
     **/
    @ResponseBody
    @PostMapping("findPassword")
    public JSONObject findByCode(@RequestBody JSONObject json){
        String phone = json.getString("phone");   // 发送短信验证码之前会进行验证此电话号是否已经验证过
        String code = json.getString("code");
        String password = json.getString("password");
        if (!phone.matches(StringUtil.REGEX_MOBILE))    // 手机号正则判断
            return msgUtil.jsonErrorMsg("手机号格式错误");
        // 手机号是否已存在
        User user = loginService.findByPhone(phone);
        if (user == null) {
            return msgUtil.jsonErrorMsg("此电话号未注册");
        }
        // 验证码判断
        try {
            String codeRedis = redisUtil.get(phone).toString();
            if (!code.equals(codeRedis)) {
                return msgUtil.jsonErrorMsg("验证码错误, 请重新输入");
            }
        } catch (NullPointerException e) {
            return msgUtil.jsonErrorMsg("此电话号未发送验证码");
        }

        // 密码比对及位数校验
        if (!password.matches(StringUtil.REGEX_PASSWORD)) {
            return msgUtil.jsonSuccessMsg("您输入的密码必须由6-16个英文字母和数字的字符串组成");
        }
        // 保存
        try {
            user.setcPassword(password);
            commonService.update(user, "User");
        } catch (Exception e) {
            e.printStackTrace();
            return msgUtil.jsonErrorMsg("修改失败");
        }
        return msgUtil.jsonSuccessMsg("找回成功");
    }






//    @ResponseBody
//    @ApiImplicitParams({
//            @ApiImplicitParam(
//                    name = "phone",
//                    value = "手机", required = true,
//                    dataType = "string", paramType = "query"),
//            @ApiImplicitParam(
//                    name = "password",
//                    value = "密码",
//                    required = true,
//                    dataType = "string", paramType = "query")
//    })
//    @ApiOperation(value = "登录", notes = "登录note", tags = "login")
//    @RequestMapping(value = "/login1", method = RequestMethod.POST)
//    public ResponseEntity<String> login1 (String phone, String password) {
//
//        return ResponseEntity.ok(phone+", " +password);
//    }


    /**
     * @Description 发送验证码
     * @param phone 电话号
     * @return json
     * @Author dongxiangwei
     * @Date 17:48 2020/1/3
     **/
    @PostMapping("/sendCode")
    @ResponseBody
    public JSONObject sendAuthCode(@RequestParam("phone") String phone) {
        System.out.println(phone);
        if (!phone.matches(StringUtil.REGEX_MOBILE))    // 手机号正则判断
            return msgUtil.jsonErrorMsg("手机号格式错误");
        // 手机号是否已存在
//        User user = loginService.findByPhone(phone);
//        if (user != null) {
//            return msgUtil.jsonErrorMsg("此电话号已注册");
//        }
        // 第三方发送短信
        String code = SendSms.randomCode();
        try {
            SendSms.sendYanZheng(phone, code);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // redis保存验证码
        redisUtil.set(phone, code);
        System.out.println(redisUtil.get(phone));
        return msgUtil.jsonSuccessMsg("发送成功", new HashMap());
    }


    /**
     * @param json 手机号/验证码/密码
     * @return java.lang.Object
     * @Description 注册
     * @Author dongxiangwei
     * @Date 16:10 2020/1/3
     **/
    @PostMapping("/register")
    @ResponseBody
    public JSONObject register(@RequestBody JSONObject json) {
        String phone = json.getString("phone");   // 发送短信验证码之前会进行验证此电话号是否已经验证过
        String code = json.getString("code");
        String password = json.getString("password");
        String createUser = "";
        if (json.containsKey("createUser"))
            createUser = json.getString("createUser");   // 责任经理名称
        if (!phone.matches(StringUtil.REGEX_MOBILE))    // 手机号正则判断
            return msgUtil.jsonErrorMsg("手机号格式错误");
        // 手机号是否已存在
        User user = loginService.findByPhone(phone);
        if (user != null) {
            return msgUtil.jsonErrorMsg("此电话号已注册");
        }
        // 验证码判断
        try {
            String codeRedis = redisUtil.get(phone).toString();
            if (!code.equals(codeRedis)) {
                return msgUtil.jsonErrorMsg("验证码错误, 请重新输入");
            }
        } catch (NullPointerException e) {
            return msgUtil.jsonErrorMsg("此电话号未发送验证码");
        }

        // 密码比对及位数校验
        if (!password.matches(StringUtil.REGEX_PASSWORD)) {
            return msgUtil.jsonSuccessMsg("您输入的密码必须由6-16个英文字母和数字的字符串组成");
        }
        // 保存
        try {
            commonService.save(new User(System.nanoTime() + "", phone, password, createUser, new Date()), "User");
            String send_phone = configService.selectByPrimaryKey("order_notice_phone").getcComment();
            String [] phones = send_phone.split(",");
            for (int i = 0; i < phones.length;i ++ ){
                SendSms.sendNewNotice(phones[i], "新用户注册");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return msgUtil.jsonErrorMsg("注册失败");
        }
        return msgUtil.jsonSuccessMsg("注册成功", new HashMap());
    }

    /**
     * @Description     ajax 上传图片
     * @param pic        license=执照  head=头像
     * @param file      文件流
     * @param session
     * @param request
     * @return com.alibaba.fastjson.JSONObject
     * @Author dongxiangwei
     * @Date 11:03 2020/1/8
     **/
    @ResponseBody
    @RequestMapping("upload{pic}")
    public JSONObject image(@PathVariable String pic,@RequestParam(value = "file", required = false) MultipartFile file, HttpSession session, HttpServletRequest request){
        try {
            String path_joint = "";
            if (pic.equals("license"))
                path_joint.concat(PathUtil.PATH_UPLOAD_LICENSE);
            if (pic.equals("head"))
                path_joint.concat(PathUtil.PATH_UPLOAD_HEAD_LOGO);
             uploadFileUtil.uploadImage(file, path_joint,session, request);
        } catch (Exception e) {
            e.printStackTrace();
            return msgUtil.jsonErrorMsg(e.getMessage());
        }
        return msgUtil.jsonSuccessMsg("上传成功");
    }

    /**
     * @Description
     * @param code_login    微信code
     * @return com.alibaba.fastjson.JSONObject
     * @Author dongxiangwei
     * @Date 16:37 2020/5/15
     **/
    @ResponseBody
    @RequestMapping(value = "weChatData", method = RequestMethod.POST)
    public JSONObject weChatLogin(@RequestParam(value = "code") String code_login){
        String AppID = "wx050cb64b3919b041";
        String AppSecret = "015beb779d2af5f89eae2947fc2735ff";
//        String httpUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AppID + "&secret=" + AppSecret + "&code=" + code_login + "&grant_type=authorization_code";
        String reversePostClient = HttpUtil.excuteGetClient("https://api.weixin.qq.com/sns/oauth2/access_token", "?appid=" + AppID + "&secret=" + AppSecret + "&code=" + code_login + "&grant_type=authorization_code", null);
        JSONObject reverseJson = JSONObject.parseObject(StringUtil.convertEncodingFormat(reversePostClient, "iso-8859-1", "UTF-8"));
        String errmsg = "登录错误";
        if (reverseJson == null) {
            return msgUtil.jsonErrorMsg(errmsg);
        }/*else {
            System.out.println(reverseJson.toJSONString());
        }*/
        // {"access_token":"ACCESS_TOKEN",  "expires_in":7200, "refresh_token":"REFRESH_TOKEN", "openid":"OPENID", "scope":"SCOPE"}
        if (reverseJson.containsKey("errcode")) {

            if (reverseJson.get("errcode").equals("40030")){
                errmsg = "二维码失效, 请重新扫码登录";
            }
            return msgUtil.jsonErrorMsg(errmsg);
        }
        String openid = reverseJson.get("openid").toString();
        String access_token = reverseJson.get("access_token").toString();
        Map<String, String> map = new HashMap<>();
        map.put("openid", openid);
        map.put("access_token", access_token);
        User user = userService.getUserByOpenId(openid);
        if (user != null) {
            String token = tokenService.getToken(user);
            map.put("token", token);
        }

        return msgUtil.jsonSuccessMsg("获取成功", map);
    }

    /**
     * @Description
     * @param code_login    微信code
     * @return com.alibaba.fastjson.JSONObject
     * @Author dongxiangwei
     * @Date 16:37 2020/5/15
     **/
    @ResponseBody
    @RequestMapping(value = "qqData", method = RequestMethod.POST)
    public JSONObject qqLogin(@RequestParam(value = "code") String code_login, @RequestParam("reUrl") String reUrl){


//        String httpUrl = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=" + AppID + "&secret=" + AppSecret + "&code=" + code_login + "&grant_type=authorization_code";
        String reverseGetClient = HttpUtil.excuteGetClient("https://graph.qq.com/oauth2.0/token", "?client_id=" + AppID + "&client_secret=" + AppSecret + "&code=" + code_login + "&redirect_uri=" + reUrl + "&grant_type=authorization_code", null);
        JSONObject reverseJson = JSONObject.parseObject(JsonUtil.getJsonStrByQueryUrl(reverseGetClient));

        String errmsg = "登录错误";
        if (reverseJson == null && reverseJson.containsKey("access_token")) {
            return msgUtil.jsonErrorMsg("access_token 获取错误");
        }/*else {
            System.out.println("access_token json:  " + reverseJson.toJSONString());
        }*/
        // {"access_token":"ACCESS_TOKEN",  "expires_in":7200, "refresh_token":"REFRESH_TOKEN", "openid":"OPENID", "scope":"SCOPE"}
        if (reverseJson.containsKey("errcode")) {
            if (reverseJson.get("errcode").equals("40030")){
                errmsg = "二维码失效, 请重新扫码登录";
            }
            return msgUtil.jsonErrorMsg(errmsg);
        }
        String access_token = reverseJson.get("access_token").toString();

        //
        String reverseGetClient2 = HttpUtil.excuteGetClient("https://graph.qq.com/oauth2.0/me", "?access_token=" + access_token, null);
        reverseGetClient2 = reverseGetClient2.replace("callback( " , "").replace(" );", "");
        JSONObject reverseJson2 = JSONObject.parseObject(StringUtil.convertEncodingFormat(reverseGetClient2, "iso-8859-1", "UTF-8"));
        if (reverseJson == null) {
            return msgUtil.jsonErrorMsg("openid 获取错误");
        }/*else {
            System.out.println("openId json:  " + reverseJson2.toJSONString());
        }*/

        String openid = reverseJson2.get("openid").toString();
        Map<String, String> map = new HashMap<>();
        map.put("openid", openid);
        map.put("access_token", access_token);
        User user = userService.getUserByQQOpenId(openid);
        if (user != null) {
            String token = tokenService.getToken(user);
            map.put("token", token);
        }

        return msgUtil.jsonSuccessMsg("获取成功", map);
    }



    /**
     * @param
     * @return java.lang.String
     * @Description token 验证
     * @Author dongxiangwei
     * @Date 15:26 2020/1/3
     **/
//    @UserLoginToken
//    @GetMapping("/getMessage")
//    @ResponseBody
//    public String getMessage() {
//        return "你已通过验证";
//    }

}
