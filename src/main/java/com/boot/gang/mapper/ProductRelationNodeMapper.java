package com.boot.gang.mapper;

import com.boot.gang.entity.ProductRelationNode;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProductRelationNodeMapper {
    int deleteByPrimaryKey(String cId);

    int insert(ProductRelationNode record);

    int insertSelective(ProductRelationNode record);

    ProductRelationNode selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(ProductRelationNode record);

    int updateByPrimaryKeyWithBLOBs(ProductRelationNode record);

    int updateByPrimaryKey(ProductRelationNode record);

    /**
     * @Description 条件筛选获取所有的订单详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_product_relation_node where 1 = 1 ${swhere}")
    List<ProductRelationNode> getList(@Param("swhere") String swhere);
}