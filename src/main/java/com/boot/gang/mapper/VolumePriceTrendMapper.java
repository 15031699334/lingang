package com.boot.gang.mapper;

import com.boot.gang.entity.VolumePriceTrend;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VolumePriceTrendMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(VolumePriceTrend record);

    int insertSelective(VolumePriceTrend record);

    VolumePriceTrend selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(VolumePriceTrend record);

    int updateByPrimaryKey(VolumePriceTrend record);

    /**
     * @Description 条件筛选获取所有的卷价趋势信息
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_volume_price_trend where 1 = 1 ${swhere}")
    List<VolumePriceTrend> getList(@Param("swhere") String swhere);

    @Select("select vpt_type_name from t_volume_price_trend where vpt_type_num = #{vptTypeNum} group by vpt_type_name")
    List<String> getVptTypeName(@Param("vptTypeNum") String vptTypeNum);


}