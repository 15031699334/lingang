package com.boot.gang.mapper;

import com.boot.gang.entity.Order;
import com.boot.gang.entity.OrderDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(String dId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(String dId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
    /**
     * @Description 条件筛选获取所有的订单
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:37
     **/
    @Select("select * from t_order_detail where 1 = 1 ${swhere}")
    List<OrderDetail> getList(@Param("swhere") String swhere);
}