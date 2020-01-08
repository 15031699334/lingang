package com.boot.gang.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.gang.entity.Address;
import com.boot.gang.entity.IntegralDetail;
import com.boot.gang.entity.User;
import com.boot.gang.service.CommonService;
import com.boot.gang.service.TokenService;
import com.boot.gang.util.MsgUtil;
import com.boot.gang.util.token.UserLoginToken;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ClassName: lingang
 * @description: ajax请求 接口
 * @author: dongxiangwei
 * @create: 2020-01-02 17:42
 **/
//@Controller
@Api(value = "AjaxController", tags = {"ajax请求"})
@RestController
@RequestMapping("/linA")
public class AjaxController {

    @Autowired
    CommonService commonService;
    @Autowired
    MsgUtil msgUtil;
    @Autowired
    TokenService tokenService;

    /**
     * @Description  通过id 获取相应对象信息
     * @param entity    实体类名称
     * @param id        对象的id
     * @return java.lang.Object
     * @Author dongxiangwei
     * @Date 11:43 2020/1/4
     **/
//    @UserLoginToken
    @ApiImplicitParams({
            @ApiImplicitParam(name = "entity", value = "相应对象 yh=用户(查询此参数时 id == '')", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "id", value = "对象id", required = false, dataType = "string", paramType = "query"),
    })
    @ApiOperation(value = "通过id获取一条记录", notes = "entity=yh,用户")
    @RequestMapping(value = "/get{entity}", method = RequestMethod.GET)
    public JSONObject getOneById(@PathVariable String entity,@RequestParam(required = false) String id, HttpServletRequest request){

        String userId;
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            e.printStackTrace();
            return msgUtil.jsonErrorMsg("token错误");
        }
        if (entity.equals("yh")){   // 用户
            User user = (User) commonService.findObjectById(userId, "User");
            user.setcPassword("");
            return msgUtil.jsonSuccessMsg("获取成功", "user", user);
        }
        if (entity.equals("dz")){
            return msgUtil.jsonSuccessMsg("获取成功", "address", commonService.findObjectById(id, "Address"));
        }
        if (entity.equals("gd"))        // 钢豆中心
            return msgUtil.jsonSuccessMsg("获取成功", "data", commonService.findObjectById(userId, "gd"));

        return msgUtil.jsonErrorMsg("路径错误");
    }

    /**
     * @Description  获取list数据
     * @param entity    表名
    * @param request    条件参数
     * @return java.lang.Object
     * @Author dongxiangwei
     * @Date 16:48 2020/1/4
     **/
    @GetMapping("/list{entity}")
    public JSONObject getList(@PathVariable String entity, HttpServletRequest request){
        Map<String, List> map = new HashMap<>();
        if (entity.equals("dz"))        // 收货地址
            map.put("address", commonService.getList("Address", request));
        if (entity.equals("dd"))        // 订单
            map.put("order", commonService.getList("Order", request));
        if (entity.equals("fk"))        // 付款记录
            map.put("record", commonService.getList(entity, request));
        if (map.isEmpty()){
            return msgUtil.jsonErrorMsg("路径错误");
        }
        return msgUtil.jsonSuccessMsg("获取成功", map);
    }
    /**
     * @Description  添加
     * @param entity    实体类名称
     * @param json    对象的属性
     * @return java.lang.Object
     * @Author dongxiangwei
     * @Date 10:48 2020/1/6
     **/
    @RequestMapping(value = "/add{entity}", method = RequestMethod.POST)
    public JSONObject addByEntity(@PathVariable String entity,@RequestBody JSONObject json, HttpServletRequest request){

        if (entity.equals("dz")){       // 收货地址
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                Address address = JSONObject.toJavaObject(json, Address.class);
                address.setcCreateUser(userId);
                address.setcId(System.nanoTime()+"");
                address.setcCreateTime(new Date());
                commonService.save(address, "Address");
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("添加失败");
            }
        }
       /* if (entity.equals("gd")){
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                IntegralDetail integralDetail = JSONObject.toJavaObject(json, IntegralDetail.class);
                address.setcCreateUser(userId);
                address.setcId(System.nanoTime()+"");
                address.setcCreateTime(new Date());
                commonService.save(address, "Address");
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("添加失败");
            }
        }*/

        return msgUtil.jsonSuccessMsg("添加成功");
    }

    /**
     * @Description  修改对象信息 通过对象的
     * @param entity    实体类名
     * @param   json  对象传入的要修改的参数
     * @return java.lang.Object
     * @Author dongxiangwei
     * @Date 11:49 2020/1/4
     **/
    @RequestMapping(value = "/up{entity}", method = RequestMethod.POST)
    public JSONObject updateByEntity(@PathVariable String entity, @RequestBody JSONObject json ,HttpServletRequest request){
            try {
                if (entity.equals("yh")) {      // 用户
                    String userId;
                    try {
                        userId = tokenService.getIdByToken(request);
                    } catch (Exception e) {
                        e.printStackTrace();
                        return msgUtil.jsonErrorMsg("token错误");
                    }
                    if (json.containsKey("cPassword")){   // 修改密码
                        if (!json.getString("cPassword").equals(json.getString("passwordAgain")))
                            return msgUtil.jsonErrorMsg("两次输入的密码不一致");
                    }
                    User user = JSONObject.toJavaObject(json, User.class);
                    user.setcId(userId);
                    if (json.containsKey("cShopName")){   // 只要提交会员认证请求 cIfShop参数就会转换为 审核中 状态
                        user.setcIfShop(1);
                    }
                    user.setcLastUpdateTime(new Date());
                    commonService.update(user, "User");
                }
                if (entity.equals("dz")){           // 收货地址
                    String userId = tokenService.getIdByToken(request);
                    Address address = JSONObject.toJavaObject(json, Address.class);
                    address.setcCreateUser(userId);
                    address.setcLastUpdateTime(new Date());
                    commonService.update(address, "Address");
                }
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("修改失败");
            }
        return msgUtil.jsonSuccessMsg("修改成功");
    }

    /**
     * @Description
     * @param entity
     * @param id        对象的id
     * @return com.alibaba.fastjson.JSONObject
     * @Author dongxiangwei
     * @Date 11:11 2020/1/7
     **/
    @RequestMapping(value = "/del{entity}", method = RequestMethod.POST)
    public JSONObject deleteById(@PathVariable String entity, String id,HttpServletRequest request){
        try {
            if (entity.equals("dz")){           // 收货地址
//                System.out.println(id);
                commonService.delete(id, "Address");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return msgUtil.jsonErrorMsg(e.getMessage());
        }
        return msgUtil.jsonSuccessMsg("删除成功");
    }
}
