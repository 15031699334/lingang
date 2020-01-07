package com.boot.gang.service;

import com.boot.gang.entity.User;

import javax.servlet.http.HttpServletRequest;

public interface TokenService {
    public String getToken(User user);

    String getIdByToken(HttpServletRequest request) throws Exception;
}
