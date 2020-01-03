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
    public User findByPhone(String phone) {
        return userMapper.findByPhone(phone);
    }
}
