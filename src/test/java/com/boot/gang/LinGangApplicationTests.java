package com.boot.gang;

import com.boot.gang.entity.User;
import com.boot.gang.mapper.UserMapper;
import com.boot.gang.service.LoginService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class LinGangApplicationTests {

    @Autowired
    UserMapper userMapper;
    @Test
    void test() {
        User user = userMapper.findByPhone("111111");
        User user1 = userMapper.selectByPrimaryKey("1");
        System.out.println("用户信息: " + user + ",  用户信息" + user1);
    }

}
