package com.boot.gang.mapper;

import com.boot.gang.entity.OrderRecord;
import com.boot.gang.entity.PlanShopping;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PlanShoppingMapper {
    int deleteByPrimaryKey(String cId);

    int insert(PlanShopping record);

    int insertSelective(PlanShopping record);

    PlanShopping selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(PlanShopping record);

    int updateByPrimaryKey(PlanShopping record);

    /**
     * @Description 条件筛选获取所有的成交动态
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_plan_shopping where 1 = 1 ${swhere}")
    List<PlanShopping> getList(@Param("swhere") String swhere);
}