package com.boot.gang.service.Impl;

import com.boot.gang.entity.User;
import com.boot.gang.mapper.UserMapper;
import com.boot.gang.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;


    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsername(username);
    }

    @Override
    public Object findObjectById(String id, String entity) {
        if (entity.equals("user")){
            return userMapper.selectByPrimaryKey(Integer.parseInt(id));
        }
        return "null";
    }
}
