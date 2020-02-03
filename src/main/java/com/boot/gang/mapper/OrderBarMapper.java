package com.boot.gang.mapper;

import com.boot.gang.entity.OrderBar;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderBarMapper {
    int deleteByPrimaryKey(String cId);

    int insert(OrderBar record);

    int insertSelective(OrderBar record);

    OrderBar selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(OrderBar record);

    int updateByPrimaryKey(OrderBar record);
    /**
     * @Description 条件筛选获取所有的酒订单
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:37
     **/
    @Select("select * from t_order_bar where 1 = 1 ${swhere}")
    List<OrderBar> getList(@Param("swhere") String swhere);
}