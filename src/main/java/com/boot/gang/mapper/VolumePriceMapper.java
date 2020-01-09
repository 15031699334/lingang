package com.boot.gang.mapper;

import com.boot.gang.entity.VolumePrice;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface VolumePriceMapper {
    int deleteByPrimaryKey(String cId);

    int insert(VolumePrice record);

    int insertSelective(VolumePrice record);

    VolumePrice selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(VolumePrice record);

    int updateByPrimaryKey(VolumePrice record);

    /**
     * @Description 条件筛选获取所有的订单详情
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:44
     **/
    @Select("select * from t_volume_price where 1 = 1 ${swhere}")
    List<VolumePrice> getList(@Param("swhere") String swhere);
}