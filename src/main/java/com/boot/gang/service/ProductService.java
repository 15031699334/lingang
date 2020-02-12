package com.boot.gang.service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: lingang
 * @description: 商品的操作
 * @author: dongxiangwei
 * @create: 2020-01-09 13:44
 **/

public interface ProductService {

    List getList(HttpServletRequest request, String pageIndex, String pageSize) throws Exception;
}
