package com.boot.gang.service.Impl;

import com.boot.gang.entity.*;
import com.boot.gang.mapper.*;
import com.boot.gang.service.CommonService;
import com.boot.gang.service.TokenService;
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
        if (entity.equals("hb"))        // 获取红包
            return couponsTypeMapper.selectByPrimaryKey(id);

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
            }else {     // ml数修改
                User user = new User(integralDetail.getiUserid(), integralDetail.getiNowintegral());
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
            shopTrolley.setStProductName(product.getcName());
            shopTrolley.setStShopId(product.getcShopId());
            shopTrolley.setStShopName(product.getcShopName());
            // 规格 材质 吨数

            shopTrolley.setStCreatettime(new Date());
            shopTrolleyMapper.insertSelective(shopTrolley);
        }
        if (entity.equals("Coupons")){  // 用户领取优惠券
            Coupons coupons = (Coupons) object;
            CouponsType couponsType = couponsTypeMapper.selectByPrimaryKey(coupons.getcCouponsTypeId());
            coupons.setcBeginTime(couponsType.getcBeginTime());
            coupons.setcEndTime(couponsType.getcEndTime());
            coupons.setcName(couponsType.getcName());
            coupons.setcPrice(couponsType.getcPrice());
            coupons.setcLimitPrice(couponsType.getcLimitPrice());
            coupons.setcId("UC" +System.nanoTime());
            coupons.setcCreateTime(new Date());
            couponsMapper.insertSelective(coupons);
        }

        if (entity.equals("Order")){    // 添加订单
            Order order = (Order) object;
            System.out.println(order);
//            orderMapper.insertSelective(order);
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
                List<Order> orders =  orderMapper.getList(" and c_user_id = " + userId + " order by c_create_time desc");
                for (Order order : orders){
                    String order_no = order.getcOrderNo();
                    order.setDetailList(orderDetailMapper.getList(" and d_orderNo = " + order_no));
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
