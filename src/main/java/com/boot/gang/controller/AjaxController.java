package com.boot.gang.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.gang.entity.*;
import com.boot.gang.service.CommonService;
import com.boot.gang.service.ProductService;
import com.boot.gang.service.ShopTrolleyService;
import com.boot.gang.service.TokenService;
import com.boot.gang.util.MsgUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    @Autowired
    ProductService productService;
    @Autowired
    ShopTrolleyService shopTrolleyService;
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
        if (entity.equals("yh")){   // 用户
            try {
                userId = tokenService.getIdByToken(request);
            } catch (Exception e) {
                return msgUtil.jsonToLoginMsg();
            }
            User user = (User) commonService.findObjectById(userId, "User");
            user.setcPassword("");
            return msgUtil.jsonSuccessMsg("获取成功", "user", user);
        }
        if (entity.equals("dz")){
            try {
                tokenService.getIdByToken(request);
            } catch (Exception e) {
                return msgUtil.jsonToLoginMsg();
            }
            return msgUtil.jsonSuccessMsg("获取成功", "address", commonService.findObjectById(id, "Address"));
        }
        if (entity.equals("gd")) {    // 钢豆中心
            try {
                userId = tokenService.getIdByToken(request);
            } catch (Exception e) {
                return msgUtil.jsonToLoginMsg();
            }
            return msgUtil.jsonSuccessMsg("获取成功", "data", commonService.findObjectById(userId, "gd"));
        }
        if (entity.equals("hb"))
            return msgUtil.jsonSuccessMsg("获取成功", "data", commonService.findObjectById(id, "hb"));

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
    public JSONObject getList(@PathVariable String entity, @RequestParam(required = false) String pageIndex,@RequestParam(required = false) String pageSize, HttpServletRequest request) {
        Map map = new HashMap<>();
        if (entity.equals("dz")) {        // 收货地址
            List<Address> list = commonService.getList("Address", request, pageIndex, pageSize);
            if (list == null) {
                return msgUtil.jsonToLoginMsg();
            }
            map.put("address", list);
        }
        if (entity.equals("dd")) {        // 订单
            List<Order> list = commonService.getList("Order", request, pageIndex, pageSize);
            if (list == null) {
                return msgUtil.jsonToLoginMsg();
            }
            map.put("order", list);
        }
        if (entity.equals("fk")){        // 付款记录
            List<OrderRecord> list = commonService.getList(entity, request, pageIndex, pageSize);
            if (list == null) {
                return msgUtil.jsonToLoginMsg();
            }
            map.put("record", list);
        }
        if(entity.equals("dh"))         // 导航
            map.put("data", commonService.getList("ShopColumn", request, pageIndex, pageSize));
        if(entity.equals("dh2"))         // 二级导航
            map.put("data", commonService.getList("ShopColumnType", request, pageIndex, pageSize));
        if (entity.equals("pm"))           // 商品筛选  品名
            map.put("data", commonService.getList("pm", request, pageIndex, pageSize));
        // 卷价
        if(entity.equals("jj"))         // 卷价
            map.put("data", commonService.getList("VolumePrice", request, pageIndex, pageSize));
        if(entity.equals("sf"))         // 省份
            map.put("data", commonService.getList("Province", request, pageIndex, pageSize));
        if(entity.equals("jjsf"))         // 卷价省份
            map.put("data", commonService.getList("jjsf", request, pageIndex, pageSize));
        if(entity.equals("cjdt"))         // 成交动态
            map.put("data", commonService.getList("cjdt", request, pageIndex, pageSize));
        if(entity.equals("zxcj"))         // 最新成交
            map.put("data", commonService.getList("zxcj", request, pageIndex, pageSize));
        if (entity.equals("gwc")) {       // 购物车
            map.put("data", commonService.getList("gwc", request, pageIndex, pageSize));
            map.put("coupon", commonService.getList("yhq", request, pageIndex, pageSize));   // 优惠券
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
            } catch (Exception e) {
                return msgUtil.jsonToLoginMsg();
            }
            map.put("whiteNote", commonService.findObjectById(userId, "User"));  // 白条信息
            map.put("address", commonService.getList("Address", request, pageIndex, pageSize));    // 收货地址
        }

        if (entity.equals("gc"))            // 钢厂
            map.put("data", commonService.getList("gc", request, pageIndex, pageSize));
        if (entity.equals("sp"))       // 商品
            map.put("data", productService.getList(request, pageIndex, pageSize));
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

        String userId;
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            return msgUtil.jsonToLoginMsg();
        }
        if (entity.equals("dz")){       // 收货地址
            try {
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
        if (entity.equals("jf")){
            try {
                IntegralDetail integralDetail = JSONObject.toJavaObject(json, IntegralDetail.class);
//                System.out.println(integralDetail.toString());
                // 赋值
                integralDetail.setiUserid(userId);
                User user = (User) commonService.findObjectById(userId, "User");
                integralDetail.setiRealname(user.getcRealname());
                integralDetail.setiId(System.nanoTime()+"");
                integralDetail.setiCreatetime(new Date());
                commonService.save(integralDetail, "IntegralDetail");     // 保存
                if (json.containsKey("mlNum")){     // 含有此参数是 一定是抽奖操作
                    IntegralDetail detail = new IntegralDetail();
                    detail.setiId("cj" + System.nanoTime()+ "");
                    detail.setiUserid(userId);
                    detail.setiRealname(user.getcRealname());
                    detail.setiChangeintegral(json.getDouble("mlNum"));
                    detail.setiChangetype(1);
                    detail.setiNowintegral(json.getDouble("nowMlNum"));
                    detail.setiCreatetime(new Date());
                    detail.setiIntegraltype(2);
                    detail.setiReason("50积分抽奖获得");
//                    System.out.println(detail);
                    commonService.save(detail, "IntegralDetail");         //保存
                }
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("添加失败");
            }
        }
        if (entity.equals("gwc")){  // 添加购物车
            String pId = json.getString("pId");
            if (shopTrolleyService.getCountByProductId(pId) > 0){
                return msgUtil.jsonErrorMsg("当前商品购物车已存在");
            }
            try {
                ShopTrolley shopTrolley = new ShopTrolley(pId, userId);
                commonService.save(shopTrolley, "ShopTrolley");
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("添加失败");
            }
        }
        if (entity.equals("yhq")){      // 用户领取优惠券
            String couponId = json.getString("cId");
            Coupons coupons = new Coupons(couponId, userId);
            try {
                commonService.save(coupons, "Coupons");
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("添加失败");
            }
        }


        if (entity.equals("dd")){   // 生成订单
            try {
                Order order = JSONObject.toJavaObject(json, Order.class);
                order.setcCreateUser(userId);
                order.setcId("OD"+System.nanoTime());
                order.setcCreateTime(new Date());
                commonService.save(order, "Order");
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("添加失败");
            }
        }
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
                        return msgUtil.jsonToLoginMsg();
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
        String userId;
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            return msgUtil.jsonToLoginMsg();
        }
        try {
            if (entity.equals("dz")){           // 收货地址
//                System.out.println(id);
                commonService.delete(id, "Address");
            }
            if (entity.equals("gwc")){           // 删除单个购物车商品
                commonService.delete(id, "ShopTrolley");
            }
            if (entity.equals("allgwc")){
                int count = shopTrolleyService.delAllByUserId(userId);
                if (count == 0){
                    msgUtil.jsonErrorMsg("购物车中没有商品");
                }
            }
        } catch (Exception e) {
            return msgUtil.jsonErrorMsg(e.getMessage());
        }
        return msgUtil.jsonSuccessMsg("删除成功");
    }
}
