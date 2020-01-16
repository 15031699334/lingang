package com.boot.gang.mapper;

import com.boot.gang.entity.Feedback;

public interface FeedbackMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);
}