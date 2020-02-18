package com.boot.gang.mapper;

import com.boot.gang.entity.Feedback;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface FeedbackMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Feedback record);

    int insertSelective(Feedback record);

    Feedback selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Feedback record);

    int updateByPrimaryKey(Feedback record);

    /**
     * @Description 条件筛选获取所有的订单
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:37
     **/
    @Select("select * from t_feedback where 1 = 1 ${swhere}")
    List<Feedback> getList(@Param("swhere") String swhere);
}