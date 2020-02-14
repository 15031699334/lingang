package com.boot.gang.service.Impl;

import com.alibaba.fastjson.JSONObject;
import com.boot.gang.entity.*;
import com.boot.gang.mapper.*;
import com.boot.gang.service.CommonService;
import com.boot.gang.service.ConfigService;
import com.boot.gang.service.TokenService;
import com.boot.gang.util.DateUtil;
import com.boot.gang.util.DoubleUtil;
import com.boot.gang.util.SendSms;
import com.boot.gang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @ClassName: lingang
 * @description:
 * @author: dongxiangwei
 * @create: 2020-01-03 16:51
 **/
@Service
public class CommonServiceImpl implements CommonService {

    @Autowired
    private PlanShoppingMapper planShoppingMapper;
    @Autowired
    private ArticleMapper articleMapper;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private AddressMapper addressMapper;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private OrderMapper orderMapper;
    @Autowired
    private OrderDetailMapper orderDetailMapper;
    @Autowired
    private IntegralDetailMapper integralDetailMapper;
    @Autowired
    private ShopMapper shopMapper;
    @Autowired
    private ShopColumnMapper shopColumnMapper;
    @Autowired
    private ShopColumnTypeMapper shopColumnTypeMapper;
    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private VolumePriceMapper volumePriceMapper;
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private ProvinceMapper provinceMapper;
    @Autowired
    private OrderRecordMapper orderRecordMapper;
    @Autowired
    private ShopTrolleyMapper shopTrolleyMapper;
    @Autowired
    private CouponsMapper couponsMapper;
    @Autowired
    private CouponsTypeMapper couponsTypeMapper;
    @Autowired
    private ConfigMapper configMapper;
    @Autowired
    private FeedbackMapper feedbackMapper;
    @Autowired
    private ResumeMapper resumeMapper;
    @Autowired
    private OrderBarMapper orderBarMapper;
    @Autowired
    private SignMapper signMapper;
    @Autowired
    private ProductRelationNodeMapper productRelationNodeMapper;
    @Autowired
    private ConfigService configService;
    @Override
    public Object findObjectById(String id, String entity) {
        if (entity.equals("User")){     // 用户信息
            return userMapper.selectByPrimaryKey(id);
        }
        if (entity.equals("Address"))   // 详细地址
            return addressMapper.selectByPrimaryKey(id);
        if (entity.equals("Product"))   // 商品详情
            return provinceMapper.selectByPrimaryKey(id);
        if (entity.equals("gd")){
            Map<String, Object> map = new HashMap();
            User user = userMapper.selectByPrimaryKey(id);
            Integer cGoldGz = user.getcGoldGz();
            List<IntegralDetail> integralDetails = integralDetailMapper.getList(" and i_IntegralType = 1 and i_userId = " + id + " order by i_createTime desc");
            List<Sign> signs = signMapper.selectByUserId(id);
            map.put("sign_state", "1");     // 可以继续签到
            if (signs.size() == 0){
                map.put("douDay", 0);
                map.put("cntDays", 0);
            }else {
                if (DateUtil.getFormateDay(new Date()).equals(DateUtil.getFormateDay(signs.get(0).getLastSignTime()))){ // 今天已经签到
                    map.put("sign_state", "0"); // 不可点击签到
                    map.put("douDay", signs.get(0).getDouDay());
                    map.put("cntDays", signs.get(0).getCntDays());
                }else if (DateUtil.getYesterday().equals(DateUtil.getFormateDay(signs.get(0).getLastSignTime()))){    //如果上次签到是昨天
                    map.put("douDay", signs.get(0).getDouDay());
                    map.put("cntDays", signs.get(0).getCntDays());
                }else {             // 既不是今天 也不是昨天
                    map.put("douDay", 0);
                    map.put("cntDays", 0);
                }
            }
            map.put("cGoldGz", cGoldGz);
            map.put("cUb", user.getcUb());
            map.put("cGold",user.getcGold());
            map.put("details", integralDetails);
            return map;
        }
        if (entity.equals("hb")) {        // 获取红包
            List<CouponsType> couponsTypes = couponsTypeMapper.getList(" and now() <= c_end_time and now() > c_begin_time and c_id = '" + id +"'");
            Double price = 0.0;
            Double priceSuffix = 0.0;
            if (couponsTypes.isEmpty()){
                return null;
            }else {
                CouponsType couponsType = couponsTypes.get(0);
                price = couponsType.getcPrice();    // 优惠金额最小值
                priceSuffix = couponsType.getcPriceSuffix();    // 优惠金额最大值
                if (priceSuffix != 0)   // 若果没有设置最大值 返回的金额为本身
                    couponsType.setcPrice(DoubleUtil.round(price + Math.random() * (priceSuffix - price), 0));   // 随机数 金额
//            System.out.println(couponsType.getcPrice());
                return couponsType;
            }
        }
        if (entity.equals("cz"))
            return configMapper.selectTexttrueByChl(id);
        if (entity.equals("gg"))
            return  configMapper.selectSpecByChl(id);
        if (entity.equals("gwc")){
            String [] ids = id.split(",");
            List<ShopTrolley> list = new ArrayList<>();
            for (String tsId:ids){
                list.add(shopTrolleyMapper.selectByPrimaryKey(tsId));
            }
            return list;
        }
        if (entity.equals("PlanShopping")){
            return planShoppingMapper.selectByPrimaryKey(id);
        }
        if (entity.equals("news")){
            Article article = articleMapper.selectByPrimaryKey(id);
            article.setcContent(article.getcContent().replaceAll("/attached/", "http://lg.zheok.com/attached/"));
            return  article;
        }
        if (entity.equals("Order")){
            return orderMapper.selectByPrimaryKey(id);
        }
        if (entity.equals("Config")) {
            Config config = configMapper.selectByPrimaryKey(id);
            String jsonStr = config.getcComment();
            return JSONObject.parseObject(jsonStr);
        }
        if (entity.equals("spkc")){
            ShopTrolley shopTrolley = shopTrolleyMapper.selectByPrimaryKey(id);
            String productId = shopTrolley.getStProductId();
            ProductRelationNode productRelationNode = productRelationNodeMapper.selectByPrimaryKey(productId);
            return productRelationNode.getcStockNum();
        }
        return "null";
    }

    @Override
    @Transactional
    public void save(Object object, String entity) throws Exception{
        if (entity.equals("User"))
            userMapper.insertSelective((User) object);
        if (entity.equals("Address")) {
            Address address = (Address) object;
            if (address.getcIfDefault() == 1) {   // 将当前用户的所有收货地址都改为不是默认
                addressMapper.updateDefaultByUserId(address.getcCreateUser());
            }
            addressMapper.insertSelective((Address) object);
        }
        if (entity.equals("IntegralDetail")){
            IntegralDetail integralDetail = (IntegralDetail) object;
            if (integralDetail.getiIntegraltype() == 1){        //  钢豆修改
                User user = new User(integralDetail.getiUserid(), integralDetail.getiNowintegral().intValue());

                // 修改
              userMapper.updateByPrimaryKeySelective(user);
            }else if (integralDetail.getiIntegraltype() == 2){     // 茅台ml数修改
                User user = new User(integralDetail.getiUserid(), integralDetail.getiNowintegral());
                // 修改
              userMapper.updateByPrimaryKeySelective(user);
            }else { // 五粮液
                User user = new User(integralDetail.getiNowintegral(), integralDetail.getiUserid());
                // 修改
                userMapper.updateByPrimaryKeySelective(user);
            }
            integralDetailMapper.insertSelective(integralDetail);   // 添加
        }
        if (entity.equals("ShopTrolley")){  // 添加购物车
            ShopTrolley shopTrolley = (ShopTrolley) object;
            ProductRelationNode product = productRelationNodeMapper.selectByPrimaryKey(shopTrolley.getStProductId());  // 获取到商品信息
            shopTrolley.setStId("st" +System.nanoTime());
            shopTrolley.setStProductId(product.getcId());
            shopTrolley.setStPrice(product.getcNowPrice());
            shopTrolley.setStNowPrice(product.getcNowPrice());
            shopTrolley.setStShopColumnTypeId(product.getcShopColumnTypeId());
            shopTrolley.setStProductName(product.getcName());
            shopTrolley.setStShopId(product.getcShopId());
            shopTrolley.setStShopName(product.getcShopName());
            shopTrolley.setStStoreaddress(product.getcZkbl());
            // 规格 材质 吨数
            String [] c_price_list = product.getcPriceList().split("=");
            String [] p_data = c_price_list[0].split("\\+");
//            System.out.println("规格: " + p_data[0] + ", 材料: " + p_data[1]);
            shopTrolley.setStProductspec(p_data[0]);
            shopTrolley.setStProducttexture(p_data[1]);
            shopTrolley.setStTonnum(product.getcSexPrice().toString());
            shopTrolley.setStProductNum(1);
            shopTrolley.setStCreatettime(new Date());
            shopTrolleyMapper.insertSelective(shopTrolley);
        }
        if (entity.equals("Coupons")){  // 用户领取优惠券
            Coupons coupons = (Coupons) object;
            CouponsType couponsType = couponsTypeMapper.selectByPrimaryKey(coupons.getcCouponsTypeId());
            coupons.setcBeginTime(couponsType.getcBeginTime());
            coupons.setcEndTime(couponsType.getcEndTime());
            coupons.setcName(couponsType.getcName());
//            coupons.setcPrice(couponsType.getcPrice());
            coupons.setcLimitPrice(couponsType.getcLimitPrice());
            coupons.setcId("UC" +System.nanoTime());
            coupons.setcCreateTime(new Date());
            couponsMapper.insertSelective(coupons);
            // 添加完成后 修改用户 优惠券领取状态
            User user = new User();
            user.setcId(coupons.getcUserId());
            user.setcScore(1);
            userMapper.updateByPrimaryKeySelective(user);
        }

        if (entity.equals("Order")){    // 添加订单
            Order order = (Order) object;
            Double price = 0.0;
//            System.out.println(order);
            if (order.getcCategory() == 1){     // 普通订单
                List<OrderDetail>  details = order.getDetailList();
                List<String> shopTrolleyIds = new ArrayList<>();    // 删除购物车商品所用

                for (OrderDetail orderDetail: details){

                    shopTrolleyIds.add(orderDetail.getdId());
                    ShopTrolley  shopTrolley = shopTrolleyMapper.selectBySwhere(" and st_userId = '"+order.getcUserId()+"' and st_id = '" + orderDetail.getdId() + "'");
                    price += DoubleUtil.mul(shopTrolley.getStPrice(), Double.parseDouble(shopTrolley.getStTonnum()));
                    if (shopTrolley == null){
                        throw new  Exception("购物车不存在当前商品");
                    }
                    OrderDetail detail_new = new OrderDetail("OD" +System.nanoTime(), new Date(), order.getcOrderNo(), 0.0, orderDetail.getdProcessrequirement(),"", shopTrolley.getStProductId(),  "1", shopTrolley.getStProductspec(), shopTrolley.getStProducttexture(), shopTrolley.getStProductName(), shopTrolley.getStShopColumnTypeId(), shopTrolley.getStShopId(), shopTrolley.getStShopName(), shopTrolley.getStTonnum(), shopTrolley.getStPrice(), shopTrolley.getStPrice(), shopTrolley.getStStoreaddress(),orderDetail.getdExtract());
                    orderDetailMapper.insertSelective(detail_new);     // 添加订单详情商品信息
                }
                price = price - order.getcCouponPrice() - order.getcGold();
//                System.out.println("传入价格: " + order.getcPrice() + ", 算出的价格: " + price);
                if (!price.equals(order.getcPrice())){
                    throw new Exception("订单提交价格错误");
                }
                // 添加订单信息
                orderMapper.insertSelective(order); // 添加完成
                // 修改优惠券状态
                if (order.getcCouponPrice() != 0){
                    Coupons coupons = new Coupons();
                    coupons.setcId(order.getcCouponId());
                    coupons.setcIfUse(1);
                    couponsMapper.updateByPrimaryKeySelective(coupons);
                }
                if (order.getcNum() != 0){   // 判断钢豆数量
                    User user = userMapper.selectByPrimaryKey(order.getcUserId());
                    Double goldGZ = Double.parseDouble(user.getcGoldGz()- order.getcNum() + "");    // 钢豆变化的数量
                    IntegralDetail integralDetail = new IntegralDetail("GD" +System.nanoTime(), order.getcNum().doubleValue(), 0, new Date(), goldGZ, order.getcOrderNo(), user.getcRealname(), order.getcUserId(), "用户下单抵扣金额", 1);
                    integralDetailMapper.insertSelective(integralDetail);
                    user.setcGoldGz(goldGZ.intValue());
                    userMapper.updateByPrimaryKeySelective(user);
                }
                // 删除购物车信息
                for (String id : shopTrolleyIds){
                    shopTrolleyMapper.deleteByPrimaryKey(id);
                }
            }else {     // cCategory == 2  添加拼购订单
                User user = userMapper.selectByPrimaryKey(order.getcUserId());  // 获取当前用户的信息
                OrderDetail  od_in = order.getDetailList().get(0);
                String c_group_num = order.getcGroupNum();
                if (c_group_num.equals("")) {   // 拼团 母订单(主订单)
                    order.setcGroupNum(order.getcOrderNo());    //添加拼团订单号
                    ProductRelationNode product = productRelationNodeMapper.selectByPrimaryKey(order.getcTransactionId());  // 获取到商品信息
                    if (product == null){
                        throw new  Exception("商品参数错误");
                    }
                    // 规格 材质 吨数
                    String [] c_price_list = product.getcPriceList().split("=");
                    String [] p_data = c_price_list[0].split("\\+");
                      // 这里是从购物车获取参数
//                    ShopTrolley shopTrolley= shopTrolleyMapper.selectBySwhere(" and st_userId = '"+order.getcUserId()+"' and st_id = '" + order.getcTransactionId() + "'");
//                    Double sy = DoubleUtil.sub(Double.parseDouble(shopTrolley.getStTonnum()), order.getcGzFl());
//                    order.setcZjrFl(sy);
                    Double sy = DoubleUtil.sub(product.getcSexPrice(), order.getcGzFl());
                    if (sy < 0){
                        throw new Exception("吨数大于库存吨量");
                    }
                    order.setcZjrFl(sy);    // 将主订单的剩余量修改

                    OrderDetail orderDetail = new OrderDetail("OD" +System.nanoTime(), new Date(), order.getcOrderNo(), 0.0, od_in.getdProcessrequirement(), od_in.getdProcessway(), product.getcId(), "1", p_data[0], p_data[1], product.getcName(), product.getcShopColumnTypeId(), product.getcShopId(), product.getcShopName(),  product.getcSexPrice().toString(), product.getcNowPrice(), product.getcNowPrice(), product.getcZkbl(), "");
                    orderDetailMapper.insertSelective(orderDetail);     // 添加订单详情商品信息
                    // 添加订单信息
                    order.setcRealname(user.getcRealname());
                    order.setcPhone(user.getcPhone());
                    // 订单价格判定
                    price = DoubleUtil.round(DoubleUtil.mul(order.getcGzFl(), product.getcNowPrice()), 2);  // 单价乘以拼的吨数 - 钢豆优惠金额 - 优惠券优惠金额
                    order.setcPrice(price);
                    orderMapper.insertSelective(order);
//                    System.out.println("添加完成");
                }else {     // 子订单(附属订单)     // 不能加入自己发起的拼购
                    order.setcState(1);
                    Order order_group_init = orderMapper.selectByOrderNo(order.getcGroupNum());   // 拼单发起人的用户id
                    order_group_init.setcState(1);
                    if (order.getcUserId().equals(order_group_init.getcUserId())){
                        throw new Exception("不能参与自己发起的拼购");
                    }
                    ProductRelationNode product = productRelationNodeMapper.selectByPrimaryKey(order.getcTransactionId());  // 获取到商品信息
                    if (product == null){
                        throw new  Exception("商品参数错误");
                    }
                    // 库存是否足够   够 则减去1库存
                    if (product.getcStockNum() == 0){
                        throw new Exception("库存不足,无法参与此拼购订单");
                    }
                    // 规格 材质 吨数
                    String [] c_price_list = product.getcPriceList().split("=");
                    String [] p_data = c_price_list[0].split("\\+");
                    Double sy = DoubleUtil.sub(order_group_init.getcZjrFl(), order.getcGzFl());  // 查询到的剩余量 - 传入的
                    if (sy < 0){
                        throw new Exception("吨数大于商品吨数");
                    }
                    order_group_init.setcZjrFl(sy); // 将主订单的剩余量修改
                    OrderDetail orderDetail = new OrderDetail("OD" +System.nanoTime(), new Date(), order.getcOrderNo(), 0.0, od_in.getdProcessrequirement(), od_in.getdProcessway(), product.getcId(), "1", p_data[0], p_data[1], product.getcName(), product.getcShopColumnTypeId(), product.getcShopId(), product.getcShopName(), product.getcSexPrice().toString(), product.getcNowPrice(), product.getcNowPrice(), product.getcZkbl(), "");
                    orderDetailMapper.insertSelective(orderDetail);     // 添加订单详情商品信息
                    // 添加订单信息
                    order.setcGroupEndTime(order_group_init.getcGroupEndTime());
                    order.setcRealname(user.getcRealname());
                    order.setcPhone(user.getcPhone());
                    // 订单价格判定
                    price = DoubleUtil.round(DoubleUtil.mul(order.getcGzFl(), product.getcNowPrice()), 2);  // 单价乘以拼的吨数 - 钢豆优惠金额 - 优惠券优惠金额
                    order.setcPrice(price);
                    orderMapper.insertSelective(order); // 订单生成
                    product.setcStockNum(0);
                    productRelationNodeMapper.updateByPrimaryKeySelective(product); // 商品库存修改为0
                    orderMapper.updateByPrimaryKeySelective(order_group_init);      // 修改主单的剩余吨数
                    sendMsg("拼团订单");      // 发送短信
                }
            }
        }

        if (entity.equals("FeedBack")){     //用户反馈
            Feedback feedback = (Feedback) object;
            feedbackMapper.insertSelective(feedback);
        }
         if (entity.equals("jhcg")){        // 计划采购
             PlanShopping planShopping =(PlanShopping) object;
             planShoppingMapper.insertSelective(planShopping);
             sendMsg("计划采购订单");      // 发送短信
        }

        if (entity.equals("grjl")){ // 个人简历
            resumeMapper.insertSelective((Resume) object);
        }

        if (entity.equals("bar")) {   // 提交酒的订单
            OrderBar orderBar = (OrderBar) object;
            User user = userMapper.selectByPrimaryKey(orderBar.getcUserId());
            IntegralDetail integralDetail = null;
            if (orderBar.getcCategory() == 1){  // 茅台
                orderBar.setcProductName("茅台酒");
                Double ub = Double.parseDouble(user.getcUb()- 500000 + "");    //茅台酒ml数变化的数量
                integralDetail =  new IntegralDetail("MT" +System.nanoTime(), 500000.0, 0, new Date(), ub, orderBar.getcId(), user.getcRealname(), orderBar.getcUserId(), "用户兑换茅台酒", 2);
                user.setcUb(ub);
            }else if (orderBar.getcCategory() == 2){    // 五粮液
                orderBar.setcProductName("五粮液");
                Double gold = Double.parseDouble(user.getcGold()- 500000 + "");    // 五粮液ml数变化的数量
                integralDetail =  new IntegralDetail("WLY" +System.nanoTime(), 500000.0, 0, new Date(), gold, orderBar.getcId(), user.getcRealname(), orderBar.getcUserId(), "用户兑换五粮液", 3);
                user.setcGold(gold);
            }
            userMapper.updateByPrimaryKeySelective(user);   // 修改ml数变化
            integralDetailMapper.insertSelective(integralDetail);   // 添加明细变化
            orderBarMapper.insertSelective(orderBar);               // 添加酒订单
        }
    }

    @Override
    @Transactional
    public void update(Object object, String entity) throws Exception {
        if (entity.equals("User")){
            userMapper.updateByPrimaryKeySelective((User) object);
        }
        if (entity.equals("Address")){
            Address address = (Address) object;
            if (address.getcIfDefault() == 1){    // 将当前用户的所有收货地址都改为不是默认
                addressMapper.updateDefaultByUserId(address.getcCreateUser());
            }
            // 修改地址
            addressMapper.updateByPrimaryKeySelective(address);
        }
        if (entity.equals("Order")){
            Order order = (Order) object;
            if (order.getcCategory() == 1){     // 普通订单   订单列表 订单提交
                List<OrderDetail> list = orderDetailMapper.getList(" and d_orderNo = '" + order.getcOrderNo() + "'");
                for (OrderDetail orderDetail: list){
                    ProductRelationNode prn = productRelationNodeMapper.selectByPrimaryKey(orderDetail.getdProductid());
                    if (prn.getcStockNum() < Integer.parseInt(orderDetail.getdProductnum()))
                        throw new Exception("库存不足");
                    prn.setcStockNum(prn.getcStockNum() - Integer.parseInt(orderDetail.getdProductnum()));
                    prn.setcStockNum(0);
                    productRelationNodeMapper.updateByPrimaryKeySelective(prn);
                }
                orderMapper.updateByPrimaryKeySelective(order);
                sendMsg("订单提交成功");      // 发送短信
            }else {         // 拼团订单 修改内容      暂时不用
                String orderId = order.getcId();
                List<OrderDetail> list = orderDetailMapper.getList(" and d_orderNo = '" + order.getcOrderNo() + "'");
                Order order_begin = orderMapper.selectByPrimaryKey(orderId);    // 修改前的订单数据
                Double cGzFl_change = order_begin.getcGzFl() - order.getcGzFl();     // 原本的拼的吨数减去现在的
                if (order_begin.getcGroupNum().equals(order_begin.getcOrderNo())){  // 满足条件 则为 主单
                    Double cZjrFl_changed = order_begin.getcZjrFl() + cGzFl_change;     // 剩余量改变后的数值
                    if (cZjrFl_changed < 0){
                        throw new Exception("405");     // 剩余量不足
                    }
                    order_begin.setcGzFl(cZjrFl_changed);
                    orderMapper.updateByPrimaryKeySelective(order_begin);   // 修改剩余吨数

                    ProductRelationNode prn = productRelationNodeMapper.selectByPrimaryKey(list.get(0).getdProductid());
                    prn.setcStockNum(0);
                    productRelationNodeMapper.updateByPrimaryKeySelective(prn);

                }else {     // 副单
                    Order order_primary = orderMapper.selectByOrderNo(order_begin.getcGroupNum());  // 查询主单
                    Double cZjrFl_changed = order_primary.getcZjrFl() + cGzFl_change;     // 剩余量改变后的数值
                    if (cZjrFl_changed < 0){
                        throw new Exception("405");     // 剩余量不足
                    }
                    order_primary.setcGzFl(cZjrFl_changed);
                    orderMapper.updateByPrimaryKeySelective(order_primary);     // 修改主单的剩余吨数
                    orderMapper.updateByPrimaryKeySelective(order);             // 修改副单的拼购吨数

                    ProductRelationNode prn = productRelationNodeMapper.selectByPrimaryKey(list.get(0).getdProductid());
                    prn.setcStockNum(0);
                    productRelationNodeMapper.updateByPrimaryKeySelective(prn);
                }
            }
        }
        if (entity.equals("PlanShopping")){     // 修改计划采购内容
            planShoppingMapper.updateByPrimaryKeySelective((PlanShopping)object);
        }
        if (entity.equals("ddjg")){ // 订单加工信息的修改
            OrderDetail orderDetail = (OrderDetail) object;
            orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
        }

    }

    @Override
    public List getList(String entity, HttpServletRequest request, String pageIndex, String pageSize) {
        if (entity.equals("Address")){      // 收货地址
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                return addressMapper.getList(" and c_create_user = " + userId + " order by c_if_default desc");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if(entity.equals("Order")){     // 订单列表
            String orderState = request.getParameter("os");     // 传入的订单状态
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
//                System.out.println(userId);
                List<Order> orders;
                if (!StringUtil.isNullOrEmpty(orderState)){
                    orders =  orderMapper.getList(" and c_user_id = " + userId + " and c_category = 1  and c_state = "+ orderState + " order by c_create_time desc");
                }else {
                    orders =  orderMapper.getList(" and c_user_id = " + userId + " and c_category = 1  order by c_create_time desc");
                }
                for (Order order : orders){
                    String order_no = order.getcOrderNo();
                    order.setDetailList(orderDetailMapper.getList(" and d_orderNo = '" + order_no + "'"));
                }
                return orders;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (entity.equals("fk")){       // 付款记录
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                List<Order> orders =  orderMapper.getRecord(" and c_state in (2,3,4,5) and c_user_id = " + userId + " order by c_create_time desc");
                for (Order order : orders){// 获取所有的订单对应的商品信息
                    String order_no = order.getcOrderNo();
                    List<OrderDetail> details= orderDetailMapper.getList(" and d_orderNo = " + order_no);
                    String paramList = "";
                    for (int i = 0; i< details.size();i ++){    // 拼接商品名
                        OrderDetail orderDetail = details.get(i);
                        if (i == 0){
                            paramList += orderDetail.getdShopcolumntype() + orderDetail.getdTonnum() + "吨";
                        }else {
                            paramList += ", " + orderDetail.getdShopcolumntype()  + orderDetail.getdTonnum() + "吨";
                        }
                    }
                    order.setcParamList(paramList);
                }
                return orders;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (entity.equals("gc"))
            return shopMapper.getList(" and c_if_open = 1 ");
        if (entity.equals("ShopColumn")){   // 导航栏
            return shopColumnMapper.getList(" order by c_sort asc");
        }
        if (entity.equals("ShopColumnType")){   // 二级导航栏 冷轧...
            String shopColumnId = request.getParameter("id");
            return shopColumnTypeMapper.getList(" and c_if_open = 1 and c_column_id = " + shopColumnId + " order by c_sort asc");
        }
        if (entity.equals("pm")) {
            String shopColumnId = request.getParameter("id");
            return shopColumnTypeMapper.getList(" and c_name != '全部' and c_column_id = " + shopColumnId + " order by c_sort asc");
        }
        if (entity.equals("Province")){   // 省份列表(商品筛选)
            return provinceMapper.getList(" and c_hide = 1 order by c_sort asc");
        }
        if (entity.equals("jjsf")){   // 首页卷价地区
            return provinceMapper.getList(" and is_volume_price = 1 order by c_sort asc");
        }
        if (entity.equals("VolumePrice")){      // 今日卷价
            String provence = request.getParameter("pName");
            return volumePriceMapper.getList(" and c_province = '" + provence + "' order by c_create_time desc");
//            return volumePriceMapper.getList(" and c_province = '" + provence + "' and to_days(c_create_time) = to_days(now()) order by c_create_time desc");
        }
        if (entity.equals("cjdt")){   // 首页成交动态(滚动)
            return orderRecordMapper.getList(" and or_state = 1 order by or_createtTime desc");
        }
        if (entity.equals("zxcj")){   // 首页最新成交
            return orderDetailMapper.getNowList(" and o.c_state != 0 order by d_createTime desc");
        }
        if (entity.equals("gwc")){      // 购物车
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                return shopTrolleyMapper.getList(" and st_userId = " + userId + " order by st_createtTime desc ");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (entity.equals("yhq")) {  // 优惠券
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                return couponsMapper.getList(" and c_if_use = 0 and now() >= c_begin_time and now()< c_end_time and c_user_id = " + userId + " order by c_create_time desc");
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (entity.equals("pt")){   // 拼团列表
            String product_id = request.getParameter("pId");
//            if (!StringUtil.isNullOrEmpty(product_id)){
//                List<Order> orders =  orderMapper.getList(" and c_category = 2 and now()< c_group_end_time and c_product_id = " + product_id + " order by c_group_num desc, c_create_time asc");
//                for (Order order : orders){
//                    String order_no = order.getcOrderNo();
//                    order.setDetailList(orderDetailMapper.getList(" and d_orderNo = '" + order_no + "'"));
//                }
//                return orders;
//            }else {
//                List<Order> orders =  orderMapper.getList(" and c_category = 2 and now()< c_group_end_time order by c_group_num desc, c_create_time asc");
//                for (Order order : orders){
//                    String order_no = order.getcOrderNo();
//                    order.setDetailList(orderDetailMapper.getList(" and d_orderNo = '" + order_no + "'"));
//                }
//                return orders;
//            }
            // 查询所有的主订单信息
            List<Order> orders =  orderMapper.getList(" and c_category = 2 and now()< c_group_end_time and c_order_no = c_group_num order by c_group_num desc, c_create_time asc");
            for (Order order : orders){     // 遍历主单
                String order_no = order.getcOrderNo();
                order.setDetailList(orderDetailMapper.getList(" and d_orderNo = '" + order_no + "'"));  // 查询订单商品信息
                order.setOrderList(orderMapper.getList(" and c_group_num = '" + order_no + "' order by c_group_num desc, c_create_time asc"));       // 将所有用户的信息传入
            }
            return orders;
        }
        if (entity.equals("mypt")){     // 我的拼团
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
//                List<Order> orders =  orderMapper.getList(" and c_category = 2 and now()< c_group_end_time and c_user_id = " + userId + " order by c_group_num desc, c_create_time asc");
//                for (Order order : orders){
//                    String order_no = order.getcOrderNo();
//                    order.setDetailList(orderDetailMapper.getList(" and d_orderNo = '" + order_no + "'"));
//                }
//                return orders;
                List<Order> orders =  orderMapper.getList(" and c_category = 2 and now()< c_group_end_time  and c_user_id = " + userId   + " order by c_group_num desc, c_create_time asc");
                for (Order order : orders){
                    String orderGroupNum = order.getcGroupNum();
                    String order_no = order.getcOrderNo();
                    if (!orderGroupNum.equals(order_no)){     // 副单 需要将主单的剩余量传入
                        Order order_primary = orderMapper.selectByOrderNo(order.getcGroupNum());   // 查询主单
                        order.setcZjrFl(order_primary.getcZjrFl());
                    }
                    order.setDetailList(orderDetailMapper.getList(" and d_orderNo = '" + order_no + "'"));
                    order.setOrderList(orderMapper.getList(" and c_group_num = '" + orderGroupNum + "' order by c_group_num desc, c_create_time asc"));       // 将所有用户的信息传入

                }
                return orders;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        if (entity.equals("jhcg")){     // 计划采购
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                List<PlanShopping> list= planShoppingMapper.getList(" and c_user_id = '" + userId + "'");
//                List<Order> orders =  orderMapper.getList(" and c_category = 1 and ISNULL(c_plan_pay_time) < 1  and c_user_id = " + userId   + " order by  c_create_time desc");
//                for (Order order : orders){
//                    String order_no = order.getcOrderNo();
//                    order.setDetailList(orderDetailMapper.getList(" and d_orderNo = '" + order_no + "'"));
//                }
                return list;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        if (entity.equals("news")){     // 新闻
            return articleMapper.getList(" and c_article_type = 'news' order by c_create_time desc");
        }
        if (entity.equals("active")){   // 活动
            return articleMapper.getList(" and c_article_type = 'active' order by c_create_time desc");
        }
        if (entity.equals("kx")){   // 快讯
            // 查询数据库中存在的创建时间 按天分组
            List<String> dates = articleMapper.getDateGroupByDate();

            List list = new ArrayList();
            for (String date: dates){
                Map map = new HashMap();
                List<Article> list1 = articleMapper.getList(" and c_article_type = 'about' and c_create_time like '%" + date +"%' order by c_create_time desc");
                map.put("date", date);
                map.put("list", list1);
                list.add(map);
            }
            return list;
        }
        if (entity.equals("dt")){   // 动态
            return articleMapper.getList(" and c_article_type = 'dynamic' order by c_create_time desc");
        }
        if (entity.equals("bar")){
            String order_state = request.getParameter("state");
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                if (StringUtil.isNullOrEmpty(order_state)){
                    return orderBarMapper.getList(" and c_user_id = '" + userId + "' order by c_create_time desc");
                }else {
                    return orderBarMapper.getList("  and c_user_id = '" + userId + "' and c_state = " + Integer.parseInt(order_state) + " order by c_create_time desc");
                }

            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        if (entity.equals("OrderDetail")){
            String orderNo = request.getAttribute("orderNo").toString();
            return orderDetailMapper.getList(" and d_orderNo = '" + orderNo + "'");
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(String id, String entity) throws Exception{
        int count = 0;
        if (entity.equals("Address")){
            count = addressMapper.deleteByPrimaryKey(id);
        }
        if (entity.equals("ShopTrolley")){
            count = shopTrolleyMapper.deleteByPrimaryKey(id);
        }
        if(entity.equals("PlanShopping")){
            count = planShoppingMapper.deleteByPrimaryKey(id);
        }
        if (entity.equals("Order")){
            Order order = orderMapper.selectByPrimaryKey(id);
            if (order.getcCategory() == 1){     // 普通订单  若有优惠券和钢豆抵扣金额则返回
                List<OrderDetail> list = orderDetailMapper.getList(" and d_orderNo = '" + order.getcOrderNo() + "'");
                for (OrderDetail orderDetail: list){
                    ProductRelationNode prn = productRelationNodeMapper.selectByPrimaryKey(orderDetail.getdProductid());
//                    prn.setcStockNum(prn.getcStockNum() + Integer.parseInt(orderDetail.getdProductnum()));
                    prn.setcStockNum(1);    // 固定赋值1    于总添加
                    productRelationNodeMapper.updateByPrimaryKeySelective(prn);
                }
                orderDetailMapper.deleteByOrderNo(order.getcOrderNo());     // 订单商品信息删除
                //若有优惠券和钢豆抵扣金额则返回
                if (order.getcCouponPrice() != 0.0){    // 有优惠金额 用了优惠券
                    Coupons coupons = new Coupons();
                    coupons.setcId(order.getcCouponId());
                    coupons.setcIfUse(0);
                    couponsMapper.updateByPrimaryKeySelective(coupons); // 修改优惠券 使用状态
                }
                if (order.getcNum() != 0){  // 用户使用的钢豆返还
                    User user = userMapper.selectByPrimaryKey(order.getcUserId());
                    user.setcGoldGz(user.getcGoldGz()+order.getcNum());
                    userMapper.updateByPrimaryKeySelective(user);   // 修改钢豆数量
//                    System.out.println(user.getcGoldGz());
                }
                count = orderMapper.deleteByPrimaryKey(id);     // 订单删除
            }else{      // 拼团订单 不用修改优惠金额和红包

                if (order.getcGroupNum().equals(order.getcOrderNo())){  // 主单   主单删除 副单随之全部删除
                    List<Order> orders = orderMapper.getList(" and c_group_num = '" + order.getcGroupNum() + "'");

                    //主单取消时,退回库存
                    if (orders.size() > 1){
                        List<OrderDetail> list = orderDetailMapper.getList(" and d_orderNo = '" + order.getcOrderNo() + "'");
                        ProductRelationNode prn = productRelationNodeMapper.selectByPrimaryKey(list.get(0).getdProductid());
                        prn.setcStockNum(1);
                        productRelationNodeMapper.updateByPrimaryKeySelective(prn);
                    }
                    for (Order order1: orders){     // 当前团购的所有订单遍历删除
                        orderDetailMapper.deleteByOrderNo(order1.getcOrderNo()); // 删除订单商品信息
                        orderMapper.deleteByPrimaryKey(order1.getcId());    // 删除当前拼团订单
                    }
                }else {     // 副单 修改主单的剩余吨数   删除此副单
                    Order order_primary = orderMapper.selectByOrderNo(order.getcGroupNum());
                    Double cZjrFl_changed = order_primary.getcZjrFl()+order.getcGzFl();     // 主单的剩余吨数 + 副单的拼单量
                    order_primary.setcZjrFl(cZjrFl_changed);
                    order_primary.setcState(0);
                    orderMapper.updateByPrimaryKeySelective(order_primary); // 修改主单剩余量  及订单状态

                    // 返还商品的 库存
                    List<OrderDetail> list = orderDetailMapper.getList(" and d_orderNo = '" + order.getcOrderNo() + "'");
                    ProductRelationNode prn = productRelationNodeMapper.selectByPrimaryKey(list.get(0).getdProductid());
                    prn.setcStockNum(1);
                    productRelationNodeMapper.updateByPrimaryKeySelective(prn); // 商品库存增加
                    orderDetailMapper.deleteByOrderNo(order.getcOrderNo()); // 删除订单商品信息
                    orderMapper.deleteByPrimaryKey(id);    // 删除当前拼团订单
                }


                count = 1;
            }
        }
        if (count != 1){
            if (count == 0){
                throw new Exception("当前数据不存在或已删除");
            }
            throw new Exception("delete count need 1 but get " + count);
        }
    }

    /*@Override
    @Transactional
    public void saveLogo(Object object, String logoType) throws Exception {
        if (logoType.equals("head")){
            update(object, "User");
        }
    }*/
    /**
     * @Description 订单信息筛查 order 订单超时删除   planshopping 计划采购超时删除
     * @param 
     * @return void
     * @Author dongxiangwei
     * @Date 16:07 2020/2/11
     **/
    @Override
    @Transactional
    public void checkOrder() throws Exception {
        Config config = configMapper.selectByPrimaryKey("time_order_limit");
        // 普通订单
        List<Order> orders =  orderMapper.getList(" and c_state < 1 and round(TIME_TO_SEC(TIMEDIFF(now(),c_create_time)) /60)> " + config.getcComment() + " and c_category = 1  order by c_create_time desc");
        //orderMapper.Delete(" and round(TIME_TO_SEC(TIMEDIFF(now(),c_create_time)) /60)>30 and c_category = 1 ");
//        System.out.println("checkOrder------orders.size()-->"+orders.size());
        for (Order order : orders){
            List<OrderDetail> list = orderDetailMapper.getList(" and d_orderNo = '" + order.getcOrderNo() + "'");
//            System.out.println("checkOrder------list.size()-->"+list.size());
//            for (OrderDetail orderDetail: list){
//                ProductRelationNode prn = productRelationNodeMapper.selectByPrimaryKey(orderDetail.getdProductid());
//                prn.setcStockNum(1);
//                productRelationNodeMapper.updateByPrimaryKeySelective(prn);
//            }
            orderDetailMapper.deleteByOrderNo(order.getcOrderNo());
            orderMapper.deleteByPrimaryKey(order.getcId());
        }

        // 计划采购订单
        List<PlanShopping> psList =  planShoppingMapper.getList("");
        for (PlanShopping planShopping: psList){
            Date planTime = DateUtil.getDate(planShopping.getcBlockId(), "yyyy-MM-dd");
//            System.out.println("计划时间: " + planTime);
            if (planTime.before(new Date()) ){   // 计划时间超时
                // 删除计划采购信息
                planShoppingMapper.deleteByPrimaryKey(planShopping.getcId());
            }
        }
    }

    private void sendMsg(String msg) throws Exception{
        String send_phone = configService.selectByPrimaryKey("order_notice_phone").getcComment();
        String [] phones = send_phone.split(",");
        for (int i = 0; i < phones.length;i ++ ){
            SendSms.sendNewNotice(phones[i], msg);
        }
    }

    public static void main(String[] args) {

//        System.out.println(new Date().getHours());
    }
}
