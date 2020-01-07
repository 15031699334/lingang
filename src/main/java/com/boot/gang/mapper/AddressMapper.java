package com.boot.gang.mapper;

import com.boot.gang.entity.Address;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface AddressMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Address record);

    int insertSelective(Address record);

    Address selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Address record);

    int updateByPrimaryKey(Address record);
    /**
     * @Description 条件筛选获取所有的地址
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List<com.boot.gang.entity.Address>
     * @Author dongxiangwei
     * @Date 14:33 2020/1/7
     **/
    @Select("select * from t_address where 1 = 1 ${swhere}")
    List<Address> getList(@Param("swhere") String swhere);

    @Update("update t_address set c_if_default = 0 where c_create_user = #{userId}")
    int updateDefaultByUserId(@Param("userId") String userId) throws Exception;


}