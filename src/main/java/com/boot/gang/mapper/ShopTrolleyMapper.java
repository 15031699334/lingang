package com.boot.gang.mapper;

import com.boot.gang.entity.OrderDetail;
import com.boot.gang.entity.ShopTrolley;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ShopTrolleyMapper {
    int deleteByPrimaryKey(String stId);

    int insert(ShopTrolley record);

    int insertSelective(ShopTrolley record);

    ShopTrolley selectByPrimaryKey(String stId);

    int updateByPrimaryKeySelective(ShopTrolley record);

    int updateByPrimaryKey(ShopTrolley record);

    /**
     * @Description 条件筛选获取所有的订单
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:37
     **/
    @Select("select * from t_shop_trolley where 1 = 1 ${swhere}")
    List<ShopTrolley> getList(@Param("swhere") String swhere);
    /**
     * @Description 通过商品id获取购物车中此商品的条数
     * @param pId       商品id
     * @param userId
     * @return int      条数
     * @Author dongxiangwei
     * @Date 19:31 2020/1/9
     **/
    @Select("select count(*) from t_shop_trolley where st_product_id = #{pId} and st_userId = #{userId}")
    int getCountByProductId(@Param("pId") String pId,@Param("userId") String userId);

    @Delete(" delete from t_shop_trolley where st_userId = #{uId}")
    int delAllByUserId(@Param("uId") String uId);
}