package com.boot.gang.service.Impl;

import com.boot.gang.entity.*;
import com.boot.gang.mapper.*;
import com.boot.gang.service.CommonService;
import com.boot.gang.service.TokenService;
import com.boot.gang.util.DoubleUtil;
import com.boot.gang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
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
    PlanShoppingMapper planShoppingMapper;
    @Autowired
    ArticleMapper articleMapper;
    @Autowired
    UserMapper userMapper;
    @Autowired
    AddressMapper addressMapper;
    @Autowired
    TokenService tokenService;
    @Autowired
    OrderMapper orderMapper;
    @Autowired
    OrderDetailMapper orderDetailMapper;
    @Autowired
    IntegralDetailMapper integralDetailMapper;
    @Autowired
    ShopMapper shopMapper;
    @Autowired
    ShopColumnMapper shopColumnMapper;
    @Autowired
    ShopColumnTypeMapper shopColumnTypeMapper;
    @Autowired
    ProductMapper productMapper;
    @Autowired
    VolumePriceMapper volumePriceMapper;
    @Autowired
    CityMapper cityMapper;
    @Autowired
    ProvinceMapper provinceMapper;
    @Autowired
    OrderRecordMapper orderRecordMapper;
    @Autowired
    ShopTrolleyMapper shopTrolleyMapper;
    @Autowired
    CouponsMapper couponsMapper;
    @Autowired
    CouponsTypeMapper couponsTypeMapper;
    @Autowired
    ConfigMapper configMapper;
    @Autowired
    FeedbackMapper feedbackMapper;
    @Autowired
    ResumeMapper resumeMapper;
    @Override
    public Object findObjectById(String id, String entity) {
        if (entity.equals("User")){
            return userMapper.selectByPrimaryKey(id);
        }
        if (entity.equals("Address"))
            return addressMapper.selectByPrimaryKey(id);
        if (entity.equals("Product"))
            return provinceMapper.selectByPrimaryKey(id);
        if (entity.equals("gd")){
            Map<String, Object> map = new HashMap();
            User user = userMapper.selectByPrimaryKey(id);
            Integer cGoldGz = user.getcGoldGz();
            List<IntegralDetail> integralDetails = integralDetailMapper.getList(" and i_IntegralType = 1 and i_userId = " + id + " order by i_createTime desc");
            map.put("cGoldGz", cGoldGz);
            map.put("cUb", user.getcUb());
            map.put("details", integralDetails);
            return map;
        }
        if (entity.equals("hb")) {        // 获取红包
            CouponsType couponsType = couponsTypeMapper.selectByPrimaryKey(id);
            Double price = 0.0;
            Double priceSuffix = 0.0;

            price = couponsType.getcPrice();    // 优惠金额最小值
            priceSuffix = couponsType.getcPriceSuffix();    // 优惠金额最大值
            if (priceSuffix != 0)   // 若果没有设置最大值 返回的金额为本身
                couponsType.setcPrice(DoubleUtil.round(price + Math.random() * (priceSuffix - price + 1), 0));   // 随机数 金额
//            System.out.println(couponsType.getcPrice());
            return couponsType;
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
        if (entity.equals("news")){
            return  articleMapper.selectByPrimaryKey(id);
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
            Product product = productMapper.selectByPrimaryKey(shopTrolley.getStProductId());  // 获取到商品信息
            shopTrolley.setStId("st" +System.nanoTime());
            shopTrolley.setStProductId(product.getcId());
            shopTrolley.setStPrice(product.getcNowPrice());
            shopTrolley.setStNowPrice(product.getcNowPrice());
            shopTrolley.setStShopColumnTypeId(product.getcShopColumnTypeId());
            shopTrolley.setStProductName(product.getcName());
            shopTrolley.setStShopId(product.getcShopId());
            shopTrolley.setStShopName(product.getcShopName());
            // 规格 材质 吨数
            String [] c_price_list = product.getcPriceList().split("=");
            String [] p_data = c_price_list[0].split("\\+");
//            System.out.println("规格: " + p_data[0] + ", 材料: " + p_data[1]);
            shopTrolley.setStProductspec(p_data[0]);
            shopTrolley.setStProducttexture(p_data[1]);
            shopTrolley.setStTonnum(product.getcStockNum().toString());
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
//            System.out.println(order);
            if (order.getcCategory() == 1){     // 普通订单
                String [] shopTrolleyIds = order.getcTransactionId().split(",");  // 购物车id
                String sTId = "";
                for (String id : shopTrolleyIds){   // 拼接购物车id   = 'st111111, st22222'
                    sTId = sTId + "'"+id +"', ";
                }
                System.out.println(", 参数: " + sTId.substring(0,sTId.length()-2));
                List<ShopTrolley> list = shopTrolleyMapper.getList(" and st_userId = '"+order.getcUserId()+"' and st_id in (" + sTId.substring(0,sTId.length()-2) + ")");
                if (list.size() != shopTrolleyIds.length){      // 如果查询到的购物车数量和传入的购物车id数量不一致 则抛异常
                    throw new  Exception("购物车不存在当前商品");
                }
                for (ShopTrolley shopTrolley : list){           // 通过购物车数据
                    OrderDetail orderDetail = new OrderDetail("OD" +System.nanoTime(), new Date(), order.getcOrderNo(), 0.0, "", shopTrolley.getStProductId(), "1", shopTrolley.getStProductspec(), shopTrolley.getStProducttexture(), shopTrolley.getStProductName(), shopTrolley.getStShopColumnTypeId(), shopTrolley.getStShopId(), shopTrolley.getStShopName(), shopTrolley.getStTonnum(), shopTrolley.getStPrice(), shopTrolley.getStStoreaddress());
                    orderDetailMapper.insertSelective(orderDetail);     // 添加订单详情商品信息
                }
                // 添加订单信息
                orderMapper.insertSelective(order); // 添加完成
                // 修改优惠券状态
                Coupons coupons = new Coupons();
                coupons.setcId(order.getcCouponId());
                coupons.setcIfUse(1);
                couponsMapper.updateByPrimaryKeySelective(coupons);
                // 删除购物车信息
                for (String id : shopTrolleyIds){
                    shopTrolleyMapper.deleteByPrimaryKey(id);
                }
            }else {     // cCategory == 2  添加拼购订单
                User user = userMapper.selectByPrimaryKey(order.getcUserId());  // 获取当前用户的信息

                String c_group_num = order.getcGroupNum();
                if (c_group_num.equals("")) {   // 拼团 母订单(主订单)
                    order.setcGroupNum(order.getcOrderNo());    //添加拼团订单号
                    Product product = productMapper.selectByPrimaryKey(order.getcTransactionId());  // 获取到商品信息
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
                    Double sy = DoubleUtil.sub(product.getcScore(), order.getcGzFl());
                    if (sy < 0){
                        throw new Exception("吨数大于库存吨量");
                    }
                    order.setcZjrFl(sy);    // 将主订单的剩余量修改

                    OrderDetail orderDetail = new OrderDetail("OD" +System.nanoTime(), new Date(), order.getcOrderNo(), 0.0, "", product.getcId(), "1", p_data[0], p_data[1], product.getcName(), product.getcShopColumnTypeId(), product.getcShopId(), product.getcShopName(), product.getcScore().toString(), product.getcNowPrice(), product.getcZkbl());
                    orderDetailMapper.insertSelective(orderDetail);     // 添加订单详情商品信息
                    // 添加订单信息
                    order.setcRealname(user.getcRealname());
                    order.setcPhone(user.getcPhone());
                    orderMapper.insertSelective(order);
                    System.out.println("添加完成");
                }else {     // 子订单(附属订单)     // 不能加入自己发起的拼购
//                    System.out.println(order.getcGroupNum());
                    Order order_group_init = orderMapper.selectByOrderNo(order.getcGroupNum());   // 拼单发起人的用户id

                    if (order.getcUserId().equals(order_group_init.getcUserId())){
                        throw new Exception("不能参与自己发起的拼购");
                    }
                    Product product = productMapper.selectByPrimaryKey(order.getcTransactionId());  // 获取到商品信息
                    if (product == null){
                        throw new  Exception("商品参数错误");
                    }
                    // 规格 材质 吨数
                    String [] c_price_list = product.getcPriceList().split("=");
                    String [] p_data = c_price_list[0].split("\\+");
                    Double sy = DoubleUtil.sub(order_group_init.getcZjrFl(), order.getcGzFl());  // 查询到的剩余量 - 传入的
                    if (sy < 0){
                        throw new Exception("吨数大于库存吨量");
                    }
                    order_group_init.setcZjrFl(sy); // 将主订单的剩余量修改
                    OrderDetail orderDetail = new OrderDetail("OD" +System.nanoTime(), new Date(), order.getcOrderNo(), 0.0, "", product.getcId(), "1", p_data[0], p_data[1], product.getcName(), product.getcShopColumnTypeId(), product.getcShopId(), product.getcShopName(), product.getcScore().toString(), product.getcNowPrice(), product.getcZkbl());
                    orderDetailMapper.insertSelective(orderDetail);     // 添加订单详情商品信息
                    // 添加订单信息
                    order.setcGroupEndTime(order_group_init.getcGroupEndTime());
                    order.setcRealname(user.getcRealname());
                    order.setcPhone(user.getcPhone());
                    orderMapper.insertSelective(order);
                    System.out.println("添加完成");
                    orderMapper.updateByPrimaryKeySelective(order_group_init);      // 修改主单的剩余吨数
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
        }

        if (entity.equals("grjl")){ // 个人简历
            resumeMapper.insertSelective((Resume) object);
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
        if (entity.equals("ddtj")){ // 订单列表 订单提交
            // 加入此订单是否当前用户的验证
            Order order = (Order) object;
            orderMapper.updateByPrimaryKeySelective(order);
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
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                List<Order> orders =  orderMapper.getList(" and c_user_id = " + userId + " and c_category = 1 " + " order by c_create_time desc");
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
            return volumePriceMapper.getList(" and c_province = '" + provence + "' and to_days(c_create_time) = to_days(now()) order by c_create_time desc");
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
            for (Order order : orders){     // 遍历主订单
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
                    String order_no = order.getcOrderNo();
                    order.setDetailList(orderDetailMapper.getList(" and d_orderNo = '" + order_no + "'"));
                    order.setOrderList(orderMapper.getList(" and c_group_num = '" + order_no + "' order by c_group_num desc, c_create_time asc"));       // 将所有用户的信息传入

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

        if (entity.equals("news")){
            return articleMapper.getAllNews();
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
        if (count != 1){
            if (count == 0){
                throw new Exception("当前数据不存在或已删除");
            }
            throw new Exception("delete count need 1 but get " + count);
        }
    }


}
