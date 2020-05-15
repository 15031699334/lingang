package com.boot.gang.service.Impl;

import com.boot.gang.entity.User;
import com.boot.gang.mapper.UserMapper;
import com.boot.gang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName: lingang
 * @description:
 * @author: dongxiangwei
 * @create: 2020-05-15 18:16
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;
    @Override
    public User getUserByOpenId(String openid) {
        List<User> userList = userMapper.getList(" and c_openid = '" + openid + "'");
        if (userList != null && !userList.isEmpty()) {
            return userList.get(0);
        }
        return null;
    }
}
