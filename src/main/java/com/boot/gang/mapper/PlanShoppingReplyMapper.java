package com.boot.gang.mapper;

import com.boot.gang.entity.PlanShoppingReply;

public interface PlanShoppingReplyMapper {
    int deleteByPrimaryKey(String psrId);

    int insert(PlanShoppingReply record);

    int insertSelective(PlanShoppingReply record);

    PlanShoppingReply selectByPrimaryKey(String psrId);

    int updateByPrimaryKeySelective(PlanShoppingReply record);

    int updateByPrimaryKey(PlanShoppingReply record);
}