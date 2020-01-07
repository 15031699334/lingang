package com.boot.gang.service.Impl;

import com.boot.gang.entity.Address;
import com.boot.gang.entity.Order;
import com.boot.gang.entity.User;
import com.boot.gang.mapper.AddressMapper;
import com.boot.gang.mapper.OrderDetailMapper;
import com.boot.gang.mapper.OrderMapper;
import com.boot.gang.mapper.UserMapper;
import com.boot.gang.service.CommonService;
import com.boot.gang.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

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
    @Override
    public Object findObjectById(String id, String entity) {
        if (entity.equals("User")){
            return userMapper.selectByPrimaryKey(id);
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
        if (entity.equals("Address")){
            String userId;
            try {
                userId = tokenService.getIdByToken(request);
                return addressMapper.getList(" and c_create_user = " + userId);
            } catch (Exception e) {
                e.printStackTrace();
                return new ArrayList();
            }
        }
        if(entity.equals("Order")){
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
