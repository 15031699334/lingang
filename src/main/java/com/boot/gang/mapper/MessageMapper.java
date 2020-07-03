package com.boot.gang.mapper;

import com.boot.gang.entity.Message;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Message record);

    int insertSelective(Message record);

    Message selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Message record);

    int updateByPrimaryKey(Message record);

    @Select("<script>"
            + "select * from t_message where userId = #{userId} and to_days(createTime) = to_days(now())"
            + "<if test='adminNo != null '>"
            + " and adminNo = #{adminNo}"
            + "</if>"
            + "</script>")
    List<Message> getAllToday(@Param("userId") String userId, @Param("adminNo") String adminNo);

    @Select("<script>"
            + "select * from t_message where userId = #{userId}"
            + "<if test='adminNo != null '>"
            + " and adminNo = #{adminNo}"
            + "</if>"
            + " and to_days(createTime) != to_days(now()) order by createTime desc"
            + "<if test='pageNo != null and pageSize != null'>"
            + " LIMIT #{pageNo},#{pageSize}"
            + "</if>"
            + "</script>")
    List<Message> getPageAllNotToday(@Param("userId") String userId,@Param("adminNo") String adminNo, @Param("pageNo") Integer pageNo, @Param("pageSize") Integer pageSize);

    @Select("<script>"
            + "select count(id) from t_message where userId = #{userId} and to_days(createTime) != to_days(now())"
            + "<if test='adminNo != null '>"
            + " and adminNo = #{adminNo}"
            + "</if>"
            + "</script>")
    int getCountNotToday(@Param("userId") String userId, @Param("adminNo") String adminNo);
}