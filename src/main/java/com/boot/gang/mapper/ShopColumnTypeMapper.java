package com.boot.gang.mapper;

import com.boot.gang.entity.ShopColumnType;
import com.boot.gang.entity.VolumePrice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopColumnTypeMapper {
    int deleteByPrimaryKey(String cId);

    int insert(ShopColumnType record);

    int insertSelective(ShopColumnType record);

    ShopColumnType selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(ShopColumnType record);

    int updateByPrimaryKey(ShopColumnType record);

    /**
     * @Description 条件筛选获取所有的类别详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_shop_column_type where 1 = 1 ${swhere}")
    List<ShopColumnType> getList(@Param("swhere") String swhere);
}