package com.boot.gang.service;

import com.boot.gang.entity.User;

/**
 * 测试
 */
public interface LoginService {

    User findByUsername(String username);

    Object findObjectById(String id, String entity);
}
