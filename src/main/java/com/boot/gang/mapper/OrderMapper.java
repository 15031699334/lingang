package com.boot.gang.mapper;

import com.boot.gang.entity.Address;
import com.boot.gang.entity.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);

    /**
     * @Description 条件筛选获取所有的订单详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_order where 1 = 1 ${swhere}")
    List<Order> getList(@Param("swhere") String swhere);
}