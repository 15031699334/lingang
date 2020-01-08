package com.boot.gang.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.gang.entity.User;
import com.boot.gang.service.CommonService;
import com.boot.gang.service.LoginService;
import com.boot.gang.service.TokenService;
import com.boot.gang.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.HashMap;

/**
 * @ClassName: lingang
 * @description: 登录/注册
 * @author: dongxiangwei
 * @create: 2020-01-02 16:40
 **/
@Controller
@RequestMapping("/linU")
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    CommonService commonService;
    @Autowired
    TokenService tokenService;
    @Autowired
    RedisUtil redisUtil;
    @Autowired
    MsgUtil msgUtil;
    @Autowired
    UploadFileUtil uploadFileUtil;
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
                    return msgUtil.jsonSuccessMsg("登录成功", "token", token);
                }
            }
        }

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
        User user = loginService.findByPhone(phone);
        if (user != null) {
            return msgUtil.jsonErrorMsg("此电话号已注册");
        }
        // 第三方发送短信


        // redis保存验证码
        redisUtil.set(phone, "123456");
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
            commonService.save(new User(System.nanoTime() + "", phone, password, new Date()), "User");
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
