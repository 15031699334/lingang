package com.boot.gang.service.Impl;

import com.boot.gang.mapper.ShopTrolleyMapper;
import com.boot.gang.service.ShopTrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @ClassName: lingang
 * @description:
 * @author: dongxiangwei
 * @create: 2020-01-09 19:30
 **/
@Service
public class ShopTrolleyServiceImpl implements ShopTrolleyService {

    @Autowired
    ShopTrolleyMapper shopTrolleyMapper;
    @Override
    public int getCountByProductId(String pId, String userId) {
        return shopTrolleyMapper.getCountByProductId(pId, userId);
    }

    @Override
    public int delAllByUserId(String uId) {
        return shopTrolleyMapper.delAllByUserId(uId);
    }
}
