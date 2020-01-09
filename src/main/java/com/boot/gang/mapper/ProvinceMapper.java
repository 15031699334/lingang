package com.boot.gang.mapper;

import com.boot.gang.entity.Province;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ProvinceMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);

    /**
     * @Description 条件筛选获取所有的省份详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_province where 1 = 1 ${swhere}")
    List<Province> getList(@Param("swhere") String swhere);
}