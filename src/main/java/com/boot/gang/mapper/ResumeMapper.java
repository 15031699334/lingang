package com.boot.gang.mapper;

import com.boot.gang.entity.Resume;

public interface ResumeMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Resume record);

    int insertSelective(Resume record);

    Resume selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Resume record);

    int updateByPrimaryKey(Resume record);
}