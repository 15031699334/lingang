package com.boot.gang.mapper;

import com.boot.gang.entity.MessageAdminUnread;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MessageAdminUnreadMapper {
    int deleteByPrimaryKey(Integer auId);

    int insert(MessageAdminUnread record);

    int insertSelective(MessageAdminUnread record);

    MessageAdminUnread selectByPrimaryKey(Integer auId);

    int updateByPrimaryKeySelective(MessageAdminUnread record);

    int updateByPrimaryKey(MessageAdminUnread record);

    /**
     * @Description 条件筛选获取所有的客服不读用户记录
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List<com.boot.gang.entity.MessageAdminUnread>
     * @Author dongxiangwei
     * @Date 2020年8月10日18:20:40
     **/
    @Select("select * from t_message_admin_unread where 1 = 1 ${swhere}")
    List<MessageAdminUnread> getList(@Param("swhere") String swhere);
}