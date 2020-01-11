package com.boot.gang.mapper;

import com.boot.gang.entity.Config;

public interface ConfigMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);
}