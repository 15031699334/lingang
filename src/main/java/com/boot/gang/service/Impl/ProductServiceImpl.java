package com.boot.gang.service.Impl;

import com.boot.gang.entity.Product;
import com.boot.gang.mapper.ProductMapper;
import com.boot.gang.service.ProductService;
import com.boot.gang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @ClassName: lingang
 * @description:
 * @author: dongxiangwei
 * @create: 2020-01-09 13:47
 **/
@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    ProductMapper productMapper;
    @Override
    public List getList(HttpServletRequest request, String pageIndex, String pageSize) {
        String provinceId = request.getParameter("pId");     // 地区id
        String shopName = request.getParameter("shopName");         // 商户
        String shopColumnTypeId = request.getParameter("sCTId"); //品名
        String cangku = request.getParameter("ck");             // 仓库
        String guige = request.getParameter("gg");             // 规格
        String caizhi = request.getParameter("cz");             // 材质
        StringBuffer sb = new StringBuffer();
        if (!StringUtil.isNullOrEmpty(provinceId)){
            sb.append(" and c_province_id = '" + provinceId + "'");
        }
        if (!StringUtil.isNullOrEmpty(shopName)){
            sb.append(" and c_shop_name = '" + shopName + "'");
        }
        if (!StringUtil.isNullOrEmpty(shopColumnTypeId)){
            sb.append(" and c_shop_column_type_id = '" + shopColumnTypeId + "'");
        }
        if (!StringUtil.isNullOrEmpty(cangku)){
//            sb.append(" and c_city_id = '" + cityId + "'");
        }
        if (!StringUtil.isNullOrEmpty(guige)){
//            sb.append(" and c_city_id = '" + cityId + "'");
        }
        if (!StringUtil.isNullOrEmpty(caizhi)){
//            sb.append(" and c_city_id = '" + cityId + "'");
        }
        if (!StringUtil.isNullOrEmpty(pageIndex) && !StringUtil.isNullOrEmpty(pageSize)) {
            sb.append(" and limit " + pageIndex + ", " + pageSize);
        }
//        System.out.println(sb.toString());
        List<Product> list = productMapper.getList(sb.toString());
        for (Product product:list){
            String [] c_price_list = product.getcPriceList().split("=");
            String [] p_data = c_price_list[0].split("\\+");
//            System.out.println(p_data[0] + ", 材料: " + p_data[1]);
                product.setcP0(p_data[0]);  // 规格
                product.setcP1(p_data[1]);  // 材料
        }
        return list;
    }
}
