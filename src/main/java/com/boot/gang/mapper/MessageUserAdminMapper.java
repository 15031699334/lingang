package com.boot.gang.mapper;

import com.boot.gang.entity.MessageUserAdmin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageUserAdminMapper {
    int deleteByPrimaryKey(String umId);

    int insert(MessageUserAdmin record);

    int insertSelective(MessageUserAdmin record);

    MessageUserAdmin selectByPrimaryKey(String umId);

    int updateByPrimaryKeySelective(MessageUserAdmin record);

    int updateByPrimaryKey(MessageUserAdmin record);

    /**
     * @Description 条件筛选获取所有的用户绑定客服记录
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List<com.boot.gang.entity.Address>
     * @Author dongxiangwei
     * @Date 14:33 2020/1/7
     **/
    @Select("select * from t_message_user_admin where 1 = 1 ${swhere}")
    List<MessageUserAdmin> getList(@Param("swhere") String swhere);
}