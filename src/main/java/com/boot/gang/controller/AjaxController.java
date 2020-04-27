package com.boot.gang.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.gang.entity.*;
import com.boot.gang.service.*;
import com.boot.gang.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.*;

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
    private CommonService commonService;
    @Autowired
    private MsgUtil msgUtil;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private ProductService productService;
    @Autowired
    private ShopTrolleyService shopTrolleyService;
    @Autowired
    private SignService signService;
    @Autowired
    private ConfigService configService;

    @Value("${gongzhangPath}")
    private String gongzhangPath;

    @Value("${uploadPath}")
    private String path;

    /**
     * @param entity 实体类名称
     * @param id     对象的id
     * @return java.lang.Object
     * @Description 通过id 获取相应对象信息
     * @Author dongxiangwei
     * @Date 11:43 2020/1/4
     **/
//    @UserLoginToken
    @ApiImplicitParams({@ApiImplicitParam(name = "entity", value = "相应对象 yh=用户(查询此参数时 id == '')", required = true, dataType = "string", paramType = "path"), @ApiImplicitParam(name = "id", value = "对象id", required = false, dataType = "string", paramType = "query"),})
    @ApiOperation(value = "通过id获取一条记录", notes = "entity=yh,用户")
    @RequestMapping(value = "/get{entity}", method = RequestMethod.GET)
    public JSONObject getOneById(@PathVariable String entity, @RequestParam(required = false) String id, HttpServletRequest request) {

        String userId;
        if (entity.equals("yh")) {   // 用户
            try {
                userId = tokenService.getIdByToken(request);
            } catch (Exception e) {
                return msgUtil.jsonToLoginMsg();
            }
            User user = (User) commonService.findObjectById(userId, "User");
            user.setcPassword("");
           /* List<CouponsType> list = commonService.getList("CouponsType", request,"0","100");
            if(list.size()<1){
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 3);
                jsonObject.put("msg", "获取成功");
                jsonObject.put("user", user);
                return jsonObject;
            }else {*/
                return msgUtil.jsonSuccessMsg("获取成功", "user", user);
            //}
        }
        if (entity.equals("dz")) {   //地址
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
        if (entity.equals("hb")) {   // 红包
            CouponsType coupons = (CouponsType) commonService.findObjectById(id, "hb");
            if (coupons == null) {
                JSONObject jsonObject = new JSONObject();
                jsonObject.put("code", 3);
                jsonObject.put("msg", "");
                return jsonObject;
            } else {
                return msgUtil.jsonSuccessMsg("获取成功", "data", coupons);
            }

        }
        if (entity.equals("cz")) {   //  材质 config表 里面的数据
            String chl = request.getParameter("chl");
            return msgUtil.jsonSuccessMsg("获取成功", "data", commonService.findObjectById(chl, "cz"));
        }
        if (entity.equals("gg")) {   // 通过品类id 获取prn表中的规格
            return msgUtil.jsonSuccessMsg("获取成功", "data", commonService.getList("PRN_spec", request, null, null));
        }
        if (entity.equals("gwc")) {     // 购物车  需要验证是否登录
            try {
                tokenService.getIdByToken(request);
            } catch (Exception e) {
                return msgUtil.jsonToLoginMsg();
            }
            return msgUtil.jsonSuccessMsg("获取成功", "data", commonService.findObjectById(id, "gwc"));
        }
        if (entity.equals("jhcg"))        // 计划采购
            return msgUtil.jsonSuccessMsg("获取成功", "data", commonService.findObjectById(id, "PlanShopping"));

        if (entity.equals("news")) {     // 获取新闻 今日快讯 活动
            Article article = (Article) commonService.findObjectById(id, "news");
            return msgUtil.jsonSuccessMsg("获取成功", "data", article);
        }
        if (entity.equals("jjqs")) {   // 获取卷价趋势    // 0=螺纹 1=冷轧 2=热轧
//            return msgUtil.jsonSuccessMsg("获取成功", "data", commonService.findObjectById("volume_price_list", "Config"));
            request.setAttribute("vpt_type", "0");
            List<VolumePriceTrend> lwlist = commonService.getList("VolumePriceTrend", request, null, null);
            request.setAttribute("vpt_type", "1");
            List<VolumePriceTrend> lzlist = commonService.getList("VolumePriceTrend", request, null, null);
            request.setAttribute("vpt_type", "2");
            List<VolumePriceTrend> rzlist = commonService.getList("VolumePriceTrend", request, null, null);
            Map<String, List> map = new HashMap<>();
            List<String> hg_date = new ArrayList<>();
            List<Double> hg_lw = new ArrayList<>();
            List<Double> hg_lz = new ArrayList<>();
            List<Double> hg_rz = new ArrayList<>();
            // 数据赋值
            for (int i = 6; i > -1; i --) {
//                String day = DateUtil.getDateFormat(DateUtil.addDay(new Date(), -i), "MM-dd");
                String day = DateUtil.getDateFormat(lwlist.get(i).getVptTime(), "MM-dd");
                hg_date.add(day);
                for (VolumePriceTrend volumePriceTrend: lwlist){
                    if (DateUtil.getDateFormat(volumePriceTrend.getVptTime(), "MM-dd").equals(day)){
                        hg_lw.add(volumePriceTrend.getVptPrice());
                    }
                }
                if (hg_lw.size() < 7 - i){
                    hg_lw.add(lwlist.get(i).getVptPrice());
                }
                for (VolumePriceTrend volumePriceTrend: lzlist){    // 冷轧
                    if (DateUtil.getDateFormat(volumePriceTrend.getVptTime(), "MM-dd").equals(day)){
                        hg_lz.add(volumePriceTrend.getVptPrice());
                    }
                }
                if (hg_lz.size() < 7 - i){
                    hg_lz.add(lzlist.get(i).getVptPrice());
                }
                for (VolumePriceTrend volumePriceTrend: rzlist){    // 热轧
                    if (DateUtil.getDateFormat(volumePriceTrend.getVptTime(), "MM-dd").equals(day)){
                        hg_rz.add(volumePriceTrend.getVptPrice());
                    }
                }
                if (hg_rz.size() < 7 - i){
                    hg_rz.add(rzlist.get(i).getVptPrice());
                }
            }
            map.put("hg_date", hg_date);
            map.put("hg_lw", hg_lw);
            map.put("hg_lz", hg_lz);
            map.put("hg_rz", hg_rz);
            return msgUtil.jsonSuccessMsg("获取成功", "data", map);
        }
        if (entity.equals("spkc")) {  // 根据购物车id查询商品库存
            return msgUtil.jsonSuccessMsg("获取成功", "data", commonService.findObjectById(id, "spkc"));
        }

        return msgUtil.jsonErrorMsg("路径错误");
    }

    /**
     * @param entity  表名
     * @param request 条件参数
     * @return java.lang.Object
     * @Description 获取list数据
     * @Author dongxiangwei
     * @Date 16:48 2020/1/4
     **/
    @GetMapping("/list{entity}")
    public JSONObject getList(@PathVariable String entity, @RequestParam(required = false) String pageIndex, @RequestParam(required = false) String pageSize, HttpServletRequest request) {
        Map map = new HashMap<>();
        if (entity.equals("dz")) {        // 收货地址
            List<Address> list = commonService.getList("Address", request, pageIndex, pageSize);
            if (list == null) {
                list = new ArrayList<>();
            }
            map.put("address", list);
        }
        if (entity.equals("dd")) {        // 订单
            List<Order> list = commonService.getList("Order", request, pageIndex, pageSize);
            if (list == null) {
                list = new ArrayList<>();
            }
            map.put("order", list);
        }
        if (entity.equals("fk")) {        // 付款记录
            List<OrderRecord> list = commonService.getList(entity, request, pageIndex, pageSize);
            if (list == null) {
                list = new ArrayList<>();
            }
            map.put("record", list);
        }
        if (entity.equals("dh"))         // 导航
            map.put("data", commonService.getList("ShopColumn", request, pageIndex, pageSize));
        if (entity.equals("dh2"))         // 二级导航
            map.put("data", commonService.getList("ShopColumnType", request, pageIndex, pageSize));
        if (entity.equals("pm"))           // 商品筛选  品名
            map.put("data", commonService.getList("pm", request, pageIndex, pageSize));
        // 卷价
        if (entity.equals("jj"))         // 卷价
            map.put("data", commonService.getList("VolumePrice", request, pageIndex, pageSize));
        if (entity.equals("sf"))         // 省份
            map.put("data", commonService.getList("Province", request, pageIndex, pageSize));
        if (entity.equals("jjsf"))         // 卷价省份
            map.put("data", commonService.getList("jjsf", request, pageIndex, pageSize));
        if (entity.equals("cjdt"))         // 成交动态
            map.put("data", commonService.getList("cjdt", request, pageIndex, pageSize));
        if (entity.equals("zxcj"))         // 最新成交
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
        if (entity.equals("sp")) {    // 商品
            String time_open = configService.selectByPrimaryKey("time_open").getcComment();
            String time_close = configService.selectByPrimaryKey("time_close").getcComment();
//            Calendar cal = Calendar.getInstance();
//            int hour = cal.get(Calendar.HOUR);      // 小时
//            if (hour >= Integer.parseInt(time_open) && hour < Integer.parseInt(time_close)) {    // 开市

            // Thu Jan 01 09:30:00 CST 1970   将三个时间 统一到1970.1.1
            Date timeNow = null;
            try {
                timeNow = DateUtil.changeToTime(new Date());
            } catch (ParseException e) {
                e.printStackTrace();
            }
            Date timeOpen =DateUtil.getDate(time_open.replace("：",":"), "HH:mm");
            Date timeClose =DateUtil.getDate(time_close.replace("：",":"), "HH:mm");
            System.out.println("现在的时间: " + timeNow + " 开始时间: " + timeOpen + " , 闭市时间: " + timeClose);
            System.out.println(timeNow.before(timeClose));
            System.out.println(timeNow.after(timeOpen));
            if (timeNow.after(timeOpen) && timeNow.before(timeClose)) {    // 开市
                map.put("marketType", "1");
            } else {
                map.put("marketType", "0");
            }

            try {
                map.put("data", productService.getList(request, pageIndex, pageSize));
            } catch (Exception e) {
                map.put("data", new ArrayList<>());
                e.printStackTrace();
            }
        }
        if (entity.equals("pt")) {       // 参与拼团页面
            map.put("data", commonService.getList("pt", request, pageIndex, pageSize));
        }
        if (entity.equals("mypt")) {     // 我的拼团
            map.put("data", commonService.getList("mypt", request, pageIndex, pageSize));
        }
        if (entity.equals("jhcg"))      // 计划采购订单列表
            map.put("data", commonService.getList("jhcg", request, pageIndex, pageSize));
        if (entity.equals("news"))      // 新闻
            map.put("data", commonService.getList("news", request, pageIndex, pageSize));
        if (entity.equals("hd"))      // 活动
            map.put("data", commonService.getList("active", request, pageIndex, pageSize));
        if (entity.equals("kx")) {       //
            List<Map> list = commonService.getList("kx", request, pageIndex, pageSize);
            map.put("data", list);
//            map.put("data", commonService.getList("kx", request, pageIndex, pageSize));
        }
        if (entity.equals("dt"))        // 临钢动态
            map.put("data", commonService.getList("dt", request, pageIndex, pageSize));
        if (entity.equals("bar"))       // 兑换酒 订单 钢豆订单
            map.put("data", commonService.getList("bar", request, pageIndex, pageSize));
        if (entity.equals("fb"))       // 反馈记录
            map.put("data", commonService.getList("fb", request, pageIndex, pageSize));
        if (map.isEmpty()) {
            return msgUtil.jsonErrorMsg("路径错误");
        }


        return msgUtil.jsonSuccessMsg("获取成功", map);
    }

    /**
     * @param entity 实体类名称
     * @param json   对象的属性
     * @return java.lang.Object
     * @Description 添加
     * @Author dongxiangwei
     * @Date 10:48 2020/1/6
     **/
    @RequestMapping(value = "/add{entity}", method = RequestMethod.POST)
    public JSONObject addByEntity(@PathVariable String entity, @RequestBody JSONObject json, HttpServletRequest request) {

        String userId;
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            return msgUtil.jsonToLoginMsg();
        }
        if (entity.equals("dz")) {       // 收货地址
            try {
                Address address = JSONObject.toJavaObject(json, Address.class);
                address.setcCreateUser(userId);
                address.setcId(System.nanoTime() + "");
                address.setcCreateTime(new Date());
                commonService.save(address, "Address");
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("添加失败");
            }
        }
        if (entity.equals("jf")) {   // 钢豆数量变更
            try {
                Integer type = 0;
                IntegralDetail integralDetail = JSONObject.toJavaObject(json, IntegralDetail.class);
//                System.out.println(integralDetail.toString());
                // 赋值
                integralDetail.setiUserid(userId);
                User user = (User) commonService.findObjectById(userId, "User");
                integralDetail.setiRealname(user.getcRealname());
                integralDetail.setiId(System.nanoTime() + "");
                integralDetail.setiCreatetime(new Date());
                Double num = 0.0;
                if (json.containsKey("mlNum")) {     // 含有此参数是 一定是抽奖操作
                    // 随机获取的酒的ml数
                    String bar_min = configService.selectByPrimaryKey("bar_min").getcComment(); // 酒限制 最小值
                    String bar_max = configService.selectByPrimaryKey("bar_max").getcComment(); // 酒限制 最大值
                    num = DoubleUtil.round(Integer.parseInt(bar_min) + Math.random() * (Integer.parseInt(bar_max) - Integer.parseInt(bar_min)), 0);
                    // 原本有的酒的ml数
                    Double barNumBefore = 0.0;
                    if (integralDetail.getiIntegraltype() == 2) {   // 2= 茅台ml数 3=五粮液
                        barNumBefore = user.getcUb();
                    }else if (integralDetail.getiIntegraltype() == 3){
                        barNumBefore = user.getcGold();
                    }else {
                        return msgUtil.jsonErrorMsg("参数传入错误");
                    }
                    System.out.println("最小值: " + bar_min + ", 最大值: " + bar_max + ", 抽到的酒ml数: " + num + ", 原本的ml数: " + barNumBefore);
                    IntegralDetail detail = new IntegralDetail();
                    detail.setiId("cj" + System.nanoTime() + "");
                    detail.setiUserid(userId);
                    detail.setiRealname(user.getcRealname());
                    detail.setiChangeintegral(num);
                    detail.setiChangetype(1);
                    detail.setiNowintegral(DoubleUtil.round(barNumBefore + num, 2));    // 现在的ml数
                    detail.setiCreatetime(new Date());
                    detail.setiIntegraltype(integralDetail.getiIntegraltype());
                    detail.setiReason(integralDetail.getiReason() + DoubleUtil.round(num / 1000, 3) + "毫升");
//                    System.out.println(detail);
                    commonService.save(detail, "IntegralDetail");         //保存酒明细
                }
                if (integralDetail.getiIntegraltype() == 3 || integralDetail.getiIntegraltype() == 2) {
                    integralDetail.setiIntegraltype(1);
                    if (num != 0.0)
                        integralDetail.setiReason(integralDetail.getiReason() + DoubleUtil.round(num / 1000, 3) + "毫升");
                }
                commonService.save(integralDetail, "IntegralDetail");     // 保存钢豆明细
                return msgUtil.jsonSuccessMsg("抽奖成功", "num", num);
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg("添加失败");
            }
        }
        if (entity.equals("gwc")) {  // 添加购物车
            String pId = json.getString("pId");     // 商品id
            if (shopTrolleyService.getCountByProductId(pId, userId) > 0) {
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
        if (entity.equals("yhq")) {      // 用户领取优惠券
            String couponId = json.getString("cId");
            String cPrice = json.getString("cPrice");
            Coupons coupons = new Coupons(couponId, userId, Double.parseDouble(cPrice));
            try {
                commonService.save(coupons, "Coupons");
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg(e.getMessage());
            }
        }


        if (entity.equals("dd")) {   // 生成订单
            try {
                Order order = JSONObject.toJavaObject(json, Order.class);
                order.setcUserId(userId);
                order.setcState(0);
                order.setcId("O" + DateUtil.getDateFormat(new Date(), "yyyyMMddHHmmss"));
                order.setcOrderNo("" + DateUtil.getDateFormat(new Date(), "yyyyMMddHHmmss"));
                order.setcCreateTime(new Date());
                commonService.save(order, "Order");
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg(e.getMessage());
            }
        }

        if (entity.equals("fb")) {   // 客户反馈
            try {
                Feedback feedBack = JSONObject.toJavaObject(json, Feedback.class);
                System.out.println(userId);
                feedBack.setcUserid(userId);
                User user = (User) commonService.findObjectById(userId, "User");
                feedBack.setcRealname(user.getcRealname());
                feedBack.setcId("FB" + System.nanoTime());
                feedBack.setcCreatetime(new Date());
                feedBack.setcLastupdatetime(new Date());
                commonService.save(feedBack, "FeedBack");
            } catch (Exception e) {
                e.printStackTrace();
                return msgUtil.jsonErrorMsg(e.getMessage());
            }
        }
        if (entity.equals("jhcg")) {     // 添加计划采购
            try {
                PlanShopping planShopping = JSONObject.toJavaObject(json, PlanShopping.class);
                planShopping.setcId("PS" + System.nanoTime());
                planShopping.setcUserId(userId);
                planShopping.setcCreateTime(new Date());
                commonService.save(planShopping, "jhcg");
            } catch (Exception e) {
                return msgUtil.jsonErrorMsg("添加错误");
            }
        }
        if (entity.equals("bar")) {  // 添加酒
            try {
                OrderBar orderBar = JSONObject.toJavaObject(json, OrderBar.class);
                orderBar.setcUserId(userId);
                orderBar.setcId("OB" + System.nanoTime());
                orderBar.setcCreateTime(new Date());
                commonService.save(orderBar, "bar");
            } catch (Exception e) {
                return msgUtil.jsonErrorMsg("添加错误");
            }
        }
        if (entity.equals("ygdd")) {    // opStatus 1=询价管理   2=意向管理
            try {
                OrderPreorder orderPreorder = JSONObject.toJavaObject(json, OrderPreorder.class);
                orderPreorder.setOpUserId(userId);
                commonService.save(orderPreorder, "OP");
            }catch (Exception e) {
                return msgUtil.jsonErrorMsg(e.getMessage());
            }
        }
        return msgUtil.jsonSuccessMsg("添加成功");
    }

    /**
     * @param entity 实体类名
     * @param json   对象传入的要修改的参数
     * @return java.lang.Object
     * @Description 修改对象信息 通过对象的
     * @Author dongxiangwei
     * @Date 11:49 2020/1/4
     **/
    @RequestMapping(value = "/up{entity}", method = RequestMethod.POST)
    public JSONObject updateByEntity(@PathVariable String entity, @RequestBody JSONObject json, HttpServletRequest request) {
        try {
            if (entity.equals("yh")) {      // 用户
                String userId;
                try {
                    userId = tokenService.getIdByToken(request);
                } catch (Exception e) {
                    return msgUtil.jsonToLoginMsg();
                }
                if (json.containsKey("cPassword")) {   // 修改密码
                    if (!json.getString("cPassword").equals(json.getString("passwordAgain")))
                        return msgUtil.jsonErrorMsg("两次输入的密码不一致");
                }
                User user = JSONObject.toJavaObject(json, User.class);
                user.setcId(userId);
                if (json.containsKey("cShopName")) {   // 只要提交会员认证请求 cIfShop参数就会转换为 审核中 状态
                    user.setcIfShop(1);
                }
                user.setcLastUpdateTime(new Date());
                try {
                    commonService.update(user, "User");
                } catch (Exception e) {
                    return msgUtil.jsonErrorMsg(e.getMessage());
                }
            }
            if (entity.equals("dz")) {           // 收货地址
                String userId = tokenService.getIdByToken(request);
                Address address = JSONObject.toJavaObject(json, Address.class);
                address.setcCreateUser(userId);
                address.setcLastUpdateTime(new Date());
                commonService.update(address, "Address");
            }
            if (entity.equals("ddtj")) {     // 订单提交  提交后 后台可展示
                String order_id = json.getString("cId");
                Order order = (Order) commonService.findObjectById(order_id, "Order");
                order.setcHide("2");
                order.setcState(1);
                order.setcLastUpdateTime(new Date());
                try {
                    commonService.update(order, "Order");
                } catch (Exception e) {
                    return msgUtil.jsonErrorMsg(e.getMessage());
                }
                return msgUtil.jsonSuccessMsg("提交成功");
            }
            if (entity.equals("ODProductNum")) {    // 订单商品数量
                OrderDetail orderDetail = new OrderDetail();
                orderDetail.setdId(json.getString("odId"));  // 订单详情id
                orderDetail.setdProductnum(json.getString("pNum")); // 商品数量
                try {
                    commonService.update(orderDetail, "OrderDetail");
                } catch (Exception e) {
                    return msgUtil.jsonErrorMsg(e.getMessage());
                }
            }
            if (entity.equals("jhcg")) {     // 修改计划采购
                PlanShopping planShopping = JSONObject.toJavaObject(json, PlanShopping.class);
                commonService.update(planShopping, "PlanShopping");
                return msgUtil.jsonSuccessMsg("提交成功");
            }
            if (entity.equals("ddjg")) {     // 订单加工信息修改     // 优化 添加用户验证
                OrderDetail orderDetail = JSONObject.toJavaObject(json, OrderDetail.class);
                commonService.update(orderDetail, "ddjg");
            }
            if (entity.equals("ddqx")) {      // 取消订单
                try {
                    tokenService.getIdByToken(request);
                } catch (Exception e) {
                    return msgUtil.jsonToLoginMsg();
                }
                String order_id = json.getString("cId");
                commonService.delete(order_id, "Order");    // 删除订单及其详情
                return msgUtil.jsonSuccessMsg("取消成功");
            }
            if (entity.equals("pdxg")) {      // 拼单修改
                Order order = JSONObject.toJavaObject(json, Order.class);
                order.setcLastUpdateTime(new Date());
                commonService.update(order, "Order");
            }
            if (entity.equals("ddshdz")) {   //订单收货地址 修改
                Order order = JSONObject.toJavaObject(json, Order.class);
                commonService.update(order, "ddshdz");
            }
        } catch (Exception e) {
            e.printStackTrace();
            return msgUtil.jsonErrorMsg("修改失败");
        }
        return msgUtil.jsonSuccessMsg("修改成功");
    }

    /**
     * @param entity
     * @param id     对象的id
     * @return com.alibaba.fastjson.JSONObject
     * @Description // 删除方法
     * @Author dongxiangwei
     * @Date 11:11 2020/1/7
     **/
    @RequestMapping(value = "/del{entity}", method = RequestMethod.POST)
    public JSONObject deleteById(@PathVariable String entity, String id, HttpServletRequest request) {
        String userId;
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            return msgUtil.jsonToLoginMsg();
        }
        try {
            if (entity.equals("dz")) {           // 收货地址
//                System.out.println(id);
                commonService.delete(id, "Address");
            }
            if (entity.equals("gwc")) {           // 删除单个购物车商品
                commonService.delete(id, "ShopTrolley");
            }
            if (entity.equals("allgwc")) {       // 清空购物车
                int count = shopTrolleyService.delAllByUserId(userId);
                if (count == 0) {
                    msgUtil.jsonErrorMsg("购物车中没有商品");
                }
            }
            if (entity.equals("jhcg")) {     // 删除计划采购的订单
                commonService.delete(id, "PlanShopping");
            }
            if (entity.equals("ddsc"))      // 订单删除
                commonService.delete(id, "Order");
            if (entity.equals("ddsp"))      // 订单商品
                commonService.delete(id, "OrderDetail");
        } catch (Exception e) {
            return msgUtil.jsonErrorMsg(e.getMessage());
        }
        return msgUtil.jsonSuccessMsg("删除成功");
    }


    /**
     * @param request
     * @return com.alibaba.fastjson.JSONObject
     * @Description 签到
     * @Author dongxiangwei
     * @Date 12:20 2020/1/16
     **/
    @RequestMapping("sign")
    public JSONObject sign(HttpServletRequest request) {
        String userId;
        try {
            userId = tokenService.getIdByToken(request);
        } catch (Exception e) {
            return msgUtil.jsonToLoginMsg();
        }
        Sign sign = null;
        try {
            sign = signService.sign(userId);
        } catch (Exception e) {
            e.printStackTrace();
            return msgUtil.jsonErrorMsg(e.getMessage());
        }
        Map map = new HashMap();
        map.put("sign_state", "0");     // 不可继续签到
        if (DateUtil.getFormateDay(new Date()).equals(DateUtil.getFormateDay(sign.getLastSignTime()))) {
            map.put("sign", sign);
            return msgUtil.jsonSuccessMsg("签到成功", "data", map);   // 不能点击签到
        }
        return msgUtil.jsonSuccessMsg("签到成功", "data", sign);
    }

    /**
     * @param json
     * @return com.alibaba.fastjson.JSONObject
     * @Description 提交个人简历
     * @Author dongxiangwei
     * @Date 11:56 2020/1/16
     **/
    @PostMapping("subgrjl")
    public JSONObject addResume(@RequestBody JSONObject json) {

        try {
            Resume resume = JSONObject.toJavaObject(json, Resume.class);
            resume.setcId("R" + System.nanoTime());
            resume.setcCreateTime(new Date());
            resume.setcLastUpdateTime(new Date());
            commonService.save(resume, "grjl");
        } catch (Exception e) {
            return msgUtil.jsonErrorMsg("添加错误");
        }
        return msgUtil.jsonSuccessMsg("添加成功");
    }

    @ResponseBody
    @RequestMapping("upload{type}.html")
    public String uploadFile(@PathVariable String type, @RequestParam(value = "file", required = false) MultipartFile file, HttpSession session, HttpServletRequest request, HttpServletResponse response) {
        String domain = "lingangsteel.com"; //设置domain，用于跨域
        String setDomain = "<script>document.domain = '" + domain + "';</script>";
        if (file != null) {
            String fileName = file.getOriginalFilename();
            String suffix = fileName.substring(fileName.indexOf("."));
            String newfileName = "";
            if (fileName != null && !"".equals(fileName)) {
//                String path = session.getServletContext().getRealPath("/");
//                String path = "D:\\myapp\\lingang\\upload\\";
                String fpath = "";
                switch (type) {
                    case "head":    // 头像
                        newfileName = "H" + System.nanoTime() + ".png";
                        fpath += PathUtil.PATH_UPLOAD_HEAD_LOGO;
                        break;
                    case "jl":      // 简历
                        newfileName = "L" + System.nanoTime() + ".png";
                        fpath += PathUtil.PATH_UPLOAD_LICENSE;
                        break;
                    case "lt":      // 聊天
                        newfileName = "CH" + System.nanoTime() + suffix;
                        fpath += PathUtil.PATH_UPLOAD_CHAT;
                        break;
                    default:
                        newfileName = "img" + System.nanoTime() + ".png";
                        fpath += "/upload/images";
                }
                File targetFile = new File(path + fpath, newfileName);
                if (!targetFile.exists()) {
                    targetFile.mkdirs();
                }
                // 保存
                try {
                    file.transferTo(targetFile);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                String s = msgUtil.jsonSuccessMsg(fpath + "/" + newfileName).toString().replaceAll("\"", "\\\"");
                return setDomain + s;
            }
        }
        return setDomain + msgUtil.jsonErrorMsg("上传失败").toString();
    }

    /**
     * @param
     * @return
     * @Description 每隔30分钟检查一次, 是否有订单需要自动取消
     * @Author dongxiangwei
     * @Date 22:58 2020/2/1
     **/
    @RequestMapping(value = "/checkOrder", method = RequestMethod.POST)
    public JSONObject checkOrder() {
        try {
            commonService.checkOrder();
        } catch (Exception e) {
            return msgUtil.jsonErrorMsg("清理出现异常");
        }
        return msgUtil.jsonSuccessMsg("筛查成功");
    }

    /**
     * @Description 查看 pdf
     * @param response
     * @param orderId  订单id
     * @param request
     * @return void
     * @Author dongxiangwei
     * @Date 23:35 2020/1/17
     **/
    @GetMapping("lookPdf")
    public void lookPdfWithGZ(HttpServletResponse response, String orderId, HttpServletRequest request) {
        try {
            exportPdf(response, orderId, request, "0");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /**
     * @Description 打印 pdf  有公章
     * @param response
     * @param orderId  订单id
     * @param request
     * @return void
     * @Author dongxiangwei
     * @Date 23:35 2020/1/17
     **/
    @GetMapping("exportPdf")
    public void exportPdfWithGZ(HttpServletResponse response, String orderId, HttpServletRequest request) {
        try {
            exportPdf(response, orderId, request, "1");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
//    /**
//     * @Description 打印 pdf  无
//     * @param response
//     * @param orderId     订单id
//     * @param request
//     * @return void
//     * @Author dongxiangwei
//     * @Date 23:35 2020/1/17
//     **/
//    @GetMapping("exportPdfNoGZ")
//    public void exportPdfNoGZ(HttpServletResponse response, String orderId, HttpServletRequest request){
//        try {
//            exportPdf(response, orderId, request, false);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }


    /**
     * 打印   pdf
     *
     * @param response
     * @param orderId  订单id
     * @param request
     * @throws IOException
     */
    public void exportPdf(HttpServletResponse response, String orderId, HttpServletRequest request, String type) throws IOException {

        Order order = (Order) commonService.findObjectById(orderId, "Order");
        ServletOutputStream outputStream = response.getOutputStream();
        //response.setHeader("Content-Disposition", "attachment;filename=" + new String("订单合同".getBytes(), "iso8859-1") + ".pdf");
        response.setHeader("Content-Disposition", "attachment;filename=" + new String("订单合同: ".getBytes(), "iso8859-1") + order.getcOrderNo() + ".pdf");
        request.setAttribute("orderNo", order.getcOrderNo());
        List<OrderDetail> details = commonService.getList("OrderDetail", request, null, null);
        User user = (User) commonService.findObjectById(order.getcUserId(), "User");
        Map<String, String> map1 = new HashMap<>();
        map1.put("name", user.getcRealname() == null ? " " : user.getcRealname());
        map1.put("address", order.getcProvinceId() + order.getcCityId() + (order.getcDistrictId() == null ? "" : order.getcDistrictId()) + order.getcAddressid());
        map1.put("phone", user.getcPhone() == null ? " " : user.getcPhone());
        map1.put("fax", "");    // 传真
        map1.put("openBank", user.getcNowCityName() == null ? " " : user.getcNowCityName());   // 开户行
        map1.put("bankCode", user.getcVipCardno() == null ? " " : user.getcVipCardno());   //  账号
        map1.put("signature", "");  // 委托人签字
//        System.out.println(" 需求方信息 " + map1);
        Map map = new HashMap();
        map.put("name", order.getcRealname());
        map.put("orderNo", order.getcOrderNo());
        map.put("address", "临沂市经济开发区沂蒙云谷B座6层");
        map.put("createTime", DateUtil.getFormate(order.getcCreateTime()));
        map.put("pickUpAddress", "临沂临钢库");
        map.put("pickUpType", details.get(0).getdExtract());
        map.put("freightType", "汽运");
        map.put("freightFeePayType", details.get(0).getdExtract().equals("代运") ? "代收代付" : "需方自付");
        map.put("freightAddress", order.getcProvinceId() + order.getcCityId() + (order.getcDistrictId() == null ? "" : order.getcDistrictId()) + order.getcAddressid());
        map.put("cutType", details.get(0).getdProcessway() + "：" + details.get(0).getdProcessrequirement());
        List<List<String>> lists = new ArrayList<>();
        List<String> biaotou = new ArrayList<>();
        biaotou.add("序号");
        biaotou.add("钢厂");
        biaotou.add("品名");
        biaotou.add("材质");
        biaotou.add("规格");
        biaotou.add("重量");
        biaotou.add("加工信息");
        biaotou.add("单价(元)");
        biaotou.add("备注");
        lists.add(biaotou);
        Double allTon = 0.0;
        for (int i = 0; i < details.size(); i++) {
            List<String> strings = new ArrayList<>();
            strings.add(i + 1 + "");
            OrderDetail orderDetail = details.get(i);
            strings.add(orderDetail.getdShopname());
            strings.add(orderDetail.getdShopcolumntype());
            strings.add(orderDetail.getdProducttexture());
            strings.add(orderDetail.getdProductspec());
            if(orderDetail.getdProductSex().equals("1")) {
                Double tonNum = DoubleUtil.round(Double.parseDouble(orderDetail.getdTonnum())*Double.parseDouble(orderDetail.getdProductnum()), 4);
                allTon = DoubleUtil.round(allTon + tonNum, 4);
                strings.add(tonNum +"吨");
            }else{
                if(order.getcCategory()==1){
                    strings.add( orderDetail.getdTonnum() +"吨" );
                    allTon = DoubleUtil.round(allTon + Double.parseDouble(orderDetail.getdTonnum()), 4);
                }else{
                    strings.add(order.getcGzFl() +"吨" );
                    allTon = DoubleUtil.round(allTon + order.getcGzFl(),4);
                }

            }
            String process = "";
            if (orderDetail.getdProcessway().equals("") && orderDetail.getdProcessrequirement().equals("")) {
                process += "无";
            } else if (orderDetail.getdProcessway().equals("") && !orderDetail.getdProcessrequirement().equals("")) {
                process += orderDetail.getdProcessrequirement();
            } else if (!orderDetail.getdProcessway().equals("") && orderDetail.getdProcessrequirement().equals("")) {
                process += orderDetail.getdProcessway();
            } else {
                process += orderDetail.getdProcessway() + "：" + orderDetail.getdProcessrequirement();
            }
            strings.add(process);
            strings.add(orderDetail.getdPrnPrice() + "");
            ProductRelationNode node = (ProductRelationNode) commonService.findObjectById(orderDetail.getdProductid(), "PRN");
            strings.add(node.getcSummary());
            lists.add(strings);
        }
        System.out.println("pdf 订单总重量: " + allTon);
        lists.add(new ArrayList(Arrays.asList("总重量: " + allTon + "吨")));
        lists.add(new ArrayList(Arrays.asList("小写(人民币): " + order.getcPrice().toString() + "元")));
        lists.add(new ArrayList<>(Arrays.asList("大写(人民币): " + MoneyUtils.NumToRMBStr(order.getcPrice().doubleValue()))));
//        System.out.println(Arrays.toString(lists.toArray()));
        map.put("productDetail", lists);
        map.put("secondInfo", map1);
//        System.out.println("主页信息: " + map);
        if (type.equals("1")) {
            PdfUtil.exportPdf(map, details.size(), gongzhangPath, outputStream, order.getcSctype() == 0);
        }else {
            PdfUtil.exportPdf1(map, details.size(), gongzhangPath, outputStream, order.getcSctype() == 0);
        }
        //PdfUtil.exportPdf(map, "e:\\test\\gongzhang.png", outputStream);
        outputStream.flush();
        outputStream.close();
    }
}
