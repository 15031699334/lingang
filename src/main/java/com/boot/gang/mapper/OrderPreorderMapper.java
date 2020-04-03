package com.boot.gang.mapper;

import com.boot.gang.entity.OrderPreorder;

public interface OrderPreorderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OrderPreorder record);

    int insertSelective(OrderPreorder record);

    OrderPreorder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OrderPreorder record);

    int updateByPrimaryKey(OrderPreorder record);
}