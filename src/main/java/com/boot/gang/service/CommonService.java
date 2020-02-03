package com.boot.gang.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

public interface CommonService {

    Object findObjectById(String id, String entity);

    void save(Object object, String entity) throws Exception;

    void update(Object object, String entity) throws Exception;

    List getList(String entity, HttpServletRequest request, String pageIndex, String pageSize);

    void delete(String id, String entity) throws Exception;
    /**
     * @Description     保存图片路径的方法
     * @param object    要保存的对象
     * @param logoType
     * @return void
     * @Author dongxiangwei
     * @Date 18:03 2020/1/19
     **/
   /* void saveLogo(Object object, String logoType) throws Exception;*/
}
