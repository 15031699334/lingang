package com.boot.gang.mapper;

import com.boot.gang.entity.Order;
import org.apache.ibatis.annotations.Delete;
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

    @Delete("delete from t_order where 1 = 1 ${swhere}")
    void delete(@Param("swhere") String swhere);

    @Select("select " +
            " c_order_no,c_create_time, c_pay_time, c_money_pay, c_price " +
            " from t_order where 1 = 1 ${swhere}")
    List<Order> getRecord(@Param("swhere") String swhere);

    @Select("select * from t_order where c_order_no = #{orderNo,jdbcType=VARCHAR}")
    Order selectByOrderNo(@Param("orderNo") String orderNo);
}