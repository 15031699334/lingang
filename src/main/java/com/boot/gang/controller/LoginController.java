package com.boot.gang.controller;

import com.alibaba.fastjson.JSONObject;
import com.boot.gang.entity.User;
import com.boot.gang.service.LoginService;
import com.boot.gang.service.TokenService;
import com.boot.gang.util.RedisUtil;
import com.boot.gang.util.token.UserLoginToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @ClassName: lingang
 * @description: 登录/注册
 * @author: dongxiangwei
 * @create: 2020-01-02 16:40
 **/
@Controller
@RequestMapping("/linU")
public class LoginController {

    @Autowired
    LoginService loginService;
    @Autowired
    TokenService tokenService;
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    @Autowired
    RedisUtil redisUtil;
    //登录
    @ResponseBody
    @PostMapping("/login")
    public Object login(@RequestBody JSONObject json){
        JSONObject jsonObject = new JSONObject();
        User user = loginService.findByUsername(json.getString("username"));
        if(user == null){
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!user.getPassword().equals(json.getString("password"))){
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(user);
                jsonObject.put("token", token);
                jsonObject.put("user", user);
                return jsonObject;
            }
        }
    }
    @UserLoginToken
    @GetMapping("/getMessage")
    @ResponseBody
    public String getMessage(){
        return "你已通过验证";
    }

    /**
     * redis 测试
     */
    @GetMapping("/test1")
    @ResponseBody
    public void test1(){
        // 保存字符串
        // 普通
        stringRedisTemplate.opsForValue().set("aaa", "111");
        System.out.println(stringRedisTemplate.opsForValue().get("aaa"));
        // 封装好之后的
        redisUtil.set("bbb", "value");
        System.out.println(redisUtil.hasKey("bbb"));
        System.out.println(redisUtil.get("aaa"));

    }


}
