package com.boot.gang.mapper;

import com.boot.gang.entity.OrderRecord;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface OrderRecordMapper {
    int deleteByPrimaryKey(String cId);

    int insert(OrderRecord record);

    int insertSelective(OrderRecord record);

    OrderRecord selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(OrderRecord record);

    int updateByPrimaryKey(OrderRecord record);

    /**
     * @Description 条件筛选获取所有的成交动态
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_order_record where 1 = 1 ${swhere}")
    List<OrderRecord> getList(@Param("swhere") String swhere);
}