package com.boot.gang.mapper;

import com.boot.gang.entity.Order;
import com.boot.gang.entity.OrderDetail;
import org.apache.ibatis.annotations.Delete;
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

    @Select("select d_shopColumnType, d_productTexture, d_productSpec, d_price, d_shopName, d_createTime, o.c_state d_shopId" +
            " from t_order_detail d " +
            " left join t_order o on d.d_orderNo = o.c_order_no" +
            " where 1 = 1 ${swhere}")
    List<OrderDetail> getNowList(@Param("swhere") String swhere);

    @Delete("delete from t_order_detail where d_orderNo = #{orderNo}")
    int deleteByOrderNo(@Param("orderNo") String orderNo);
}