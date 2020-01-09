package com.boot.gang.mapper;

import com.boot.gang.entity.ShopColumn;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopColumnMapper {
    int deleteByPrimaryKey(String cId);

    int insert(ShopColumn record);

    int insertSelective(ShopColumn record);

    ShopColumn selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(ShopColumn record);

    int updateByPrimaryKey(ShopColumn record);

    /**
     * @Description 条件筛选获取所有的订单详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_shop_column where 1 = 1 ${swhere}")
    List<ShopColumn> getList(@Param("swhere") String swhere);
}