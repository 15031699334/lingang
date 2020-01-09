package com.boot.gang.mapper;

import com.boot.gang.entity.Product;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Product record);

    int insertSelective(Product record);

    Product selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Product record);

    int updateByPrimaryKey(Product record);

    /**
     * @Description 条件筛选获取所有的订单详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_product where 1 = 1 ${swhere}")
    List<Product> getList(@Param("swhere") String swhere);
}