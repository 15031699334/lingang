package com.boot.gang.service.Impl;

import com.boot.gang.entity.*;
import com.boot.gang.mapper.*;
import com.boot.gang.service.CommonService;
import com.boot.gang.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    @Override
    public Object findObjectById(String id, String entity) {
        if (entity.equals("User")){
            return userMapper.selectByPrimaryKey(id);
        }
        if (entity.equals("Address"))
            return addressMapper.selectByPrimaryKey(id);
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
    public List getList(String entity, HttpServletRequest request) {
        if (entity.equals("Address")){      // 收货地址
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                return addressMapper.getList(" and c_create_user = " + userId + " order by c_if_default desc");
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList();
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
                return new ArrayList();
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
                return new ArrayList();
            }
        }
        return null;
    }

    @Override
    @Transactional
    public void delete(String id, String entity) throws Exception{
        if (entity.equals("Address")){
            int count = addressMapper.deleteByPrimaryKey(id);
            if (count != 1){
                throw new Exception("delete count need 1 but get " + count);
            }
        }
    }


}
