package com.boot.gang.mapper;

import com.boot.gang.entity.Article;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ArticleMapper {
    int deleteByPrimaryKey(String cId);

    int insert(Article record);

    int insertSelective(Article record);

    Article selectByPrimaryKey(String cId);

    int updateByPrimaryKeySelective(Article record);

    int updateByPrimaryKeyWithBLOBs(Article record);

    int updateByPrimaryKey(Article record);

    /**
     * @Description 条件筛选获取所有的信息
     * @param swhere    条件 " and ...." 注意前面的空格
     * @return java.util.List
     * @Author dongxiangwei
     * @Date 2020年1月7日18:06:37
     **/
    @Select("select * from t_article where 1 = 1 ${swhere}")
    List<Article> getList(@Param("swhere") String swhere);

    /**
     * @Description  查询当前最近的10天插入的快讯的日期
     * @param
     * @return java.util.List<java.lang.String>
     * @Author dongxiangwei
     * @Date 19:28 2020/1/17
     **/
    @Select("SELECT DATE_FORMAT(c_create_time, '%Y-%m-%d' ) FROM t_article WHERE c_article_type = 'about' GROUP BY DATE_FORMAT(c_create_time, '%Y-%m-%d' ) order by c_create_time desc limit 10")
    List<String> getDateGroupByDate();

    List<Article> getAllNews();
}