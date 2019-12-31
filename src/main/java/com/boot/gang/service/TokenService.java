package com.boot.gang.service;

import com.boot.gang.entity.User;

public interface TokenService {
    public String getToken(User user);
}
