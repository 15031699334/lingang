package com.boot.gang.mapper;

import com.boot.gang.entity.Shop;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    /**
     * @Description 条件筛选获取所有的订单详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_shop where 1 = 1 ${swhere}")
    List<Shop> getList(@Param("swhere") String swhere);
}