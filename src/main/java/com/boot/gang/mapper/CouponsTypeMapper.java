package com.boot.gang.mapper;

import com.boot.gang.entity.Coupons;
import com.boot.gang.entity.CouponsType;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CouponsTypeMapper {
    int deleteByPrimaryKey(String cId);

    int insert(CouponsType record);

    int insertSelective(CouponsType record);

    CouponsType selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(CouponsType record);

    int updateByPrimaryKey(CouponsType record);
    /**
     * @Description 条件筛选获取用户所有的优惠券
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_coupons_type where 1 = 1 ${swhere}")
    List<CouponsType> getList(@Param("swhere") String swhere);
}