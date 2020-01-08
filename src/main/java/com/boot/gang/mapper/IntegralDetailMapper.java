package com.boot.gang.mapper;

import com.boot.gang.entity.IntegralDetail;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IntegralDetailMapper {
    int deleteByPrimaryKey(String iId);

    int insert(IntegralDetail record);

    int insertSelective(IntegralDetail record);

    IntegralDetail selectByPrimaryKey(String iId);

    int updateByPrimaryKeySelective(IntegralDetail record);

    int updateByPrimaryKey(IntegralDetail record);


    /**
     * @Description 条件筛选获取所有的订单详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_integral_detail where 1 = 1 ${swhere}")
    List<IntegralDetail> getList(@Param("swhere") String swhere);

}