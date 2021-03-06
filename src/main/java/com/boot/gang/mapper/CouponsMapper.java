package com.boot.gang.mapper;

import com.boot.gang.entity.Coupons;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CouponsMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Coupons record);

    int insertSelective(Coupons record);

    Coupons selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Coupons record);

    int updateByPrimaryKey(Coupons record);
    /**
     * @Description 条件筛选获取用户所有的优惠券
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_coupons where 1 = 1 ${swhere}")
    List<Coupons> getList(@Param("swhere") String swhere);
}