package com.boot.gang.service;

import com.boot.gang.entity.Sign;

public interface SignService {

    Sign sign(String userId) throws Exception;
}