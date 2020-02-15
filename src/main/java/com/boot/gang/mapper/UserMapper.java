package com.boot.gang.mapper;

import com.boot.gang.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(String cId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    /**
     * @Description 条件获取所有用户
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List<com.boot.gang.entity.Address>
     * @Author dongxiangwei
     * @Date 14:33 2020/1/7
     **/
    @Select("select * from t_user where 1 = 1 ${swhere}")
    List<User> getList(@Param("swhere") String swhere);

    @Select("select c_id, c_phone, c_password from t_user where c_phone = #{cPhone}")
    User findByPhone(@Param(value = "cPhone") String cPhone);

}