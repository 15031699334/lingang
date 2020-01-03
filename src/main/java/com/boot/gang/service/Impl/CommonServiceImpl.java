package com.boot.gang.service.Impl;

import com.boot.gang.entity.User;
import com.boot.gang.mapper.UserMapper;
import com.boot.gang.service.CommonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public Object findObjectById(String id, String entity) {
        if (entity.equals("user")){
            return userMapper.selectByPrimaryKey(id);
        }
        return "null";
    }

    @Override
    @Transactional
    public void save(Object object, String entity) throws Exception{

        if (entity.equals("user")){
            userMapper.insertSelective((User) object);
        }

    }

    @Override
    public void update(Object object, String entity) throws Exception {
        if (entity.equals("user")){
            userMapper.updateByPrimaryKeySelective((User) object);
        }
    }
}
