package com.boot.gang.mapper;

import com.boot.gang.entity.Sign;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SignMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Sign record);

    int insertSelective(Sign record);

    Sign selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Sign record);

    int updateByPrimaryKey(Sign record);

    @Select("select * from t_sign where user_id = #{userId} order by id desc")
    List<Sign> selectByUserId(@Param("userId") String userId);
}