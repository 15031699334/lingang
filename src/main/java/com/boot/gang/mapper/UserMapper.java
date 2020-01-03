package com.boot.gang.mapper;

import com.boot.gang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String cId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select c_id, c_phone, c_password from t_user where c_phone = #{cPhone}")
    User findByPhone(@Param(value = "cPhone") String cPhone);

}