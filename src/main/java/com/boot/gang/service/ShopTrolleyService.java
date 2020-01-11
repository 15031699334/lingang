package com.boot.gang.service;

/**
 * @Description  购物车service
 * @Author dongxiangwei
 * @Date 19:29 2020/1/9
 **/
public interface ShopTrolleyService {

    int getCountByProductId(String pId, String userId);

    int delAllByUserId(String uId);
}
