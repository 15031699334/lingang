package com.boot.gang.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.gang.entity.Address;
import com.boot.gang.entity.User;
import com.boot.gang.service.CommonService;
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
            @ApiImplicitParam(name = "entity", value = "相应对象 yh=用户", required = true, dataType = "string", paramType = "path"),
            @ApiImplicitParam(name = "id", value = "用户id", required = true, dataType = "string", paramType = "query"),
    })
    @ApiOperation(value = "通过id获取一条记录", notes = "entity=yh,用户")
    @RequestMapping(value = "/get{entity}", method = RequestMethod.GET)
    public JSONObject getOneById(@PathVariable String entity,String id){

        if (entity.equals("yh")){   // 用户
            User user = (User) commonService.findObjectById(id, "User");
            user.setcPassword("");
            return msgUtil.jsonSuccessMsg("获取成功", "user", user);
        }
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
        if (map.isEmpty()){
            return msgUtil.jsonErrorMsg("路径错误");
        }
        return msgUtil.jsonSuccessMsg("获取成功", map);
    }
    /**
     * @Description  添加
     * @param entity    实体类名称
     * @param jsonObject    对象的属性
     * @return java.lang.Object
     * @Author dongxiangwei
     * @Date 10:48 2020/1/6
     **/
    @RequestMapping(value = "/add{entity}", method = RequestMethod.POST)
    public JSONObject addByEntity(@PathVariable String entity,@RequestBody JSONObject jsonObject){
        try {
            if (entity.equals("dz")){       // 收货地址
                Address address = JSONObject.toJavaObject(jsonObject, Address.class);
                address.setcId(System.nanoTime()+"");
                address.setcCreateTime(new Date());
                commonService.save(address, entity);
            }
        }catch (Exception e){
            e.printStackTrace();
            return msgUtil.jsonErrorMsg("添加失败");
        }

        return msgUtil.jsonSuccessMsg("添加成功");
    }

    /**
     * @Description  修改对象信息 通过对象的
     * @param entity    实体类名
     * @param jsonObject    对象传入的要修改的参数
     * @return java.lang.Object
     * @Author dongxiangwei
     * @Date 11:49 2020/1/4
     **/
    @RequestMapping(value = "/up{entity}", method = RequestMethod.POST)
    public JSONObject updateByEntity(@PathVariable String entity, @RequestBody JSONObject jsonObject){
            try {
                if (entity.equals("yh")) {      // 用户
                    if (jsonObject.containsKey("cPassword")){   // 修改密码
                        if (!jsonObject.getString("cPassword").equals(jsonObject.getString("passwordAgain")))
                            return msgUtil.jsonErrorMsg("两次输入的密码不一致");
                    }
                    User user = JSONObject.toJavaObject(jsonObject, User.class);
                    if (jsonObject.containsKey("cShopName")){   // 只要提交会员认证请求 cIfShop参数就会转换为 审核中 状态
                        user.setcIfShop(1);
                    }
                    user.setcLastUpdateTime(new Date());
                    commonService.update(user, "User");
                }
                if (entity.equals("dz")){           // 收货地址
                    Address address = JSONObject.toJavaObject(jsonObject, Address.class);
                    address.setcLastUpdateTime(new Date());
                    commonService.update(address, "Address");
                }



            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("修改失败");
            }
        return msgUtil.jsonSuccessMsg("修改成功");
    }









}
