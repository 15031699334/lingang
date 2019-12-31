package com.boot.gang.service;

import com.boot.gang.entity.User;
import com.boot.gang.entity.Video;

/**
 * 测试
 */
public interface TestService {
    Video getVideo();

    User findByUsername(String username);

    Object findObjectById(String id, String entity);
}
