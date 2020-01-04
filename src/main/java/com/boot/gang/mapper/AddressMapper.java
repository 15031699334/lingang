package com.boot.gang.mapper;

import com.boot.gang.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    // 获取所有
    @Select("select * from t_address where 1 = 1 and #{swhere}")
    List<Address> getList(@Param("swhere") String swhere);
}