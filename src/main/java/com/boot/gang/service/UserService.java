package com.boot.gang.service;

import com.boot.gang.entity.User;

public interface UserService {

    /**
     * @Description     通过openid 获取用户信息
     * @param openid    openId
     * @return com.boot.gang.entity.User
     * @Author dongxiangwei
     * @Date 18:18 2020/5/15
     **/
    User getUserByOpenId(String openid);
}
