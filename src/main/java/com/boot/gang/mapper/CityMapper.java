package com.boot.gang.mapper;

import com.boot.gang.entity.City;
import com.boot.gang.entity.Province;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CityMapper {
    int deleteByPrimaryKey(String cId);

    int insert(City record);

    int insertSelective(City record);

    City selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(City record);

    int updateByPrimaryKey(City record);

    /**
     * @Description 条件筛选获取所有的城市详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_city where 1 = 1 ${swhere}")
    List<City> getList(@Param("swhere") String swhere);
}