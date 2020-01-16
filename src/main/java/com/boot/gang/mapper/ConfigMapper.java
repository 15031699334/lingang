package com.boot.gang.mapper;

import com.boot.gang.entity.Config;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface ConfigMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);

    @Select("select * from t_config where c_chl = #{chl} and c_value = '材质'")
    Config selectTexttrueByChl(@Param("chl") String chl);
    @Select("select * from t_config where c_chl = #{chl} and c_value = '规格'")
    Config selectSpecByChl(@Param("chl") String chl);
}