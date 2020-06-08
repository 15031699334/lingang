package com.boot.gang.mapper;

import com.boot.gang.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKeyWithBLOBs(Admin record);

    int updateByPrimaryKey(Admin record);

    /**
     * @Description 条件筛选获取所有的后台账户的 用户名 服务号 照片
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List<com.boot.gang.entity.Address>
     * @Author dongxiangwei
     * @Date 14:33 2020/1/7
     **/
    @Select("select c_id, adminNo, adminName, adminPic, c_hide from t_admin where 1 = 1 ${swhere}")
    List<Admin> getList(@Param("swhere") String swhere);

}