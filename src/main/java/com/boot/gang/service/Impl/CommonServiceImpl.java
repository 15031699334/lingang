package com.boot.gang.service.Impl;

import com.boot.gang.entity.Address;
import com.boot.gang.entity.User;
import com.boot.gang.mapper.AddressMapper;
import com.boot.gang.mapper.UserMapper;
import com.boot.gang.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
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
        if (entity.equals("Address"))
            addressMapper.insertSelective((Address) object);

    }

    @Override
    public void update(Object object, String entity) throws Exception {
        if (entity.equals("User")){
            userMapper.updateByPrimaryKeySelective((User) object);
        }
    }

    @Override
    public List getList(String entity, HttpServletRequest request) {
        if (entity.equals("Address")){
            return addressMapper.getList("");
        }
        return null;
    }
}
