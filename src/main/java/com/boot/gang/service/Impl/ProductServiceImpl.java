package com.boot.gang.service.Impl;

import com.boot.gang.entity.Config;
import com.boot.gang.entity.Product;
import com.boot.gang.entity.ProductRelationNode;
import com.boot.gang.entity.ProductVo;
import com.boot.gang.mapper.ConfigMapper;
import com.boot.gang.mapper.ProductMapper;
import com.boot.gang.mapper.ProductRelationNodeMapper;
import com.boot.gang.service.ProductService;
import com.boot.gang.util.DoubleUtil;
import com.boot.gang.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
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
    private ProductMapper productMapper;
    @Autowired
    private ProductRelationNodeMapper productRelationNodeMapper;
    @Autowired
    private ConfigMapper configMapper;
    @Override
    public List getList(HttpServletRequest request, String pageIndex, String pageSize) throws Exception{
        String provinceId = request.getParameter("pId");     // 地区id
        String shopName = request.getParameter("shopName");         // 商户
        String shopColumnTypeId = request.getParameter("sCTId"); //品名id
        String cangku = request.getParameter("ck");             // 仓库
        String guige = request.getParameter("gg");             // 规格
        String caizhi = request.getParameter("cz");             // 材质
        String thickness = request.getParameter("thickness");          // 厚度
        String width = request.getParameter("width");          // 宽度
        String extent = request.getParameter("extent");         // 长度
        StringBuffer sb = new StringBuffer();
        sb.append(" and c_stock_num > 0  and c_hide = 's'");
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
            sb.append(" and c_zkbl = '" + cangku + "'");
        }
        if (!StringUtil.isNullOrEmpty(guige) && !StringUtil.isNullOrEmpty(caizhi)){     // 材质规格判断
            String [] specs = guige.split(",");
            String [] textTrues = caizhi.split(",");
            sb.append(" and (");
            for (int i = 0;i<specs.length; i++){
                for (int j = 0;j<textTrues.length;j++){
                    if (i == specs.length-1 && j ==  textTrues.length -1){  // 最后一个
                        sb.append("c_price_list like '%" + specs[i] +  "+" + textTrues[j] +"%'");
                    }else{
                        sb.append("c_price_list like '%" + specs[i] +  "+" + textTrues[j] +"%' or ");
                    }
                }
            }
            sb.append(") ");
        }else if(!StringUtil.isNullOrEmpty(guige)){
            String [] specs = guige.split(",");
            sb.append(" and (");

            for (int i = 0;i<specs.length; i++){
                if (i == specs.length-1){   // 是最后一个
                    sb.append("c_price_list like '%" + specs[i] + "%'");
                }else {
                    sb.append("c_price_list like '%" + specs[i] + "%' or ");
                }

            }
            sb.append(") ");
        }else if (!StringUtil.isNullOrEmpty(caizhi)){
            String [] textTrues = caizhi.split(",");
            sb.append(" and (");

            for (int j = 0;j<textTrues.length;j++){
                if (j ==  textTrues.length -1){  // 最后一个
                    sb.append("c_price_list like '%" + textTrues[j] +"%' ");
                }else{
                    sb.append("c_price_list like '%" + textTrues[j] +"%' or ");
                }
            }
            sb.append(") ");
        }
        if (!StringUtil.isNullOrEmpty(thickness)){  // 厚度
            String [] tns = thickness.split(",");   //  0,0 / 0,1.200 / 0.800,0 / 0.800,1.200
            String tn_prefix = tns[0];  // 起始值
            String wn_suffix = tns[1];  // 最大值
            if (tn_prefix.equals("0") && !wn_suffix.equals("0"))    // 没有限制最大值
                sb.append(" and c_gold <= " + wn_suffix);
            if (!tn_prefix.equals("0") && wn_suffix.equals("0"))      // 没有限制最小值
                sb.append(" and c_gold >= " + tn_prefix);
            if (!tn_prefix.equals("0") && !wn_suffix.equals("0"))     // 限制了最大值和最小值
                sb.append(" and c_gold >= " + tn_prefix + " and c_gold <= " + wn_suffix);
        }
        if (!StringUtil.isNullOrEmpty(width)){  // 宽度
            String [] widths = width.split(",");   //  0,0 / 0,1200 / 800,0 / 800,1200
            String width_prefix = widths[0];  // 起始值
            String width_suffix = widths[1];  // 最大值
            if (width_prefix.equals("0") && !width_suffix.equals("0"))    // 没有限制最大值
                sb.append(" and c_two_gold <= " + width_suffix);
            if (!width_prefix.equals("0") && width_suffix.equals("0"))      // 没有限制最小值
                sb.append(" and c_two_gold >= " + width_prefix);
            if (!width_prefix.equals("0") && !width_suffix.equals("0"))     // 限制了最大值和最小值
                sb.append(" and c_two_gold >= " + width_prefix + " and c_two_gold <= " + width_suffix);
        }

        if (!StringUtil.isNullOrEmpty(extent)){ // 长度
            if (!extent.equals("C")){   // 为C时所有的都出
                String [] extents = extent.split(",");   //  0,0 / 0,1200 / 800,0 / 800,1200
                String extent_prefix = extents[0];  // 起始值
                String extent_suffix = extents[1];  // 最大值
                if (extent_prefix.equals("0") && !extent_suffix.equals("0"))    // 没有限制最大值
                    sb.append(" and c_three_gold <= " + extent_suffix);
                if (!extent_prefix.equals("0") && extent_suffix.equals("0"))      // 没有限制最小值
                    sb.append(" and c_three_gold >= " + extent_prefix);
                if (!extent_prefix.equals("0") && !extent_suffix.equals("0"))     // 限制了最大值和最小值
                    sb.append(" and c_three_gold >= " + extent_prefix + " and c_three_gold <= " + extent_suffix);
            }
        }
        sb.append(" order by c_shop_sort asc, c_product_code asc,c_price_list asc");
        if (!StringUtil.isNullOrEmpty(pageIndex) && !StringUtil.isNullOrEmpty(pageSize)) {
            sb.append(" limit " + Integer.parseInt(pageIndex) * Integer.parseInt(pageSize) + ", " + pageSize);
        }

//        System.out.println(sb.toString());
//        List<Product> products = productMapper.getList(sb.toString());
//        for (Product product: products){
//            List<ProductRelationNode> productRelationNodes = productRelationNodeMapper.getList(" and c_product_id = '" + product.getcId() + "'");
//            product.setPrnList(productRelationNodes);
//            String [] c_price_list = product.getcPriceList().split("=");
//            String [] p_data = c_price_list[0].split("\\+");
////            System.out.println(p_data[0] + ", 材料: " + p_data[1]);
////                product.setcP0(p_data[0]);  // 规格
////                product.setcP1(p_data[1]);  // 材料
//            product.setcTop(p_data[0]);     // 规格
//            product.setcXsnum(p_data[1]);     // 材质
//        }
        List<ProductRelationNode> list = productRelationNodeMapper.getList(sb.toString());

        for (ProductRelationNode node: list){   // 先将材质规格赋值
            String [] c_price_list = node.getcPriceList().split("=");
            String [] p_data = c_price_list[0].split("\\+");
            node.setcTop(p_data[0]);     // 规格
            node.setcXsnum(p_data[1]);     // 材质
        }
        List<ProductVo> productVos = new ArrayList<>();
        for (int i = 0;i< list.size();i++){ // 将所得参数根据  厂商名/ 品名/ 材质/ 规格 四项 分组
            List<ProductRelationNode> nodes = new ArrayList<>();
            if (i != list.size() - 1){  // 不是最后一个
                ProductRelationNode prn = list.get(i);
                ProductRelationNode prn_next = list.get(i + 1);
                nodes.add(prn);
                Integer cStockNum = prn.getcStockNum();      // 库存数量
                Double  cSexPrice = DoubleUtil.round( prn.getcSexPrice() * prn.getcStockNum(), 4);    // 吨数
                while (comparePRN(prn, prn_next)){      // 判定是否相同 参数变更
                    if (i + 2 != list.size()){
                        i += 1;
                        prn = list.get(i);
                        prn_next = list.get(i + 1);
                        cStockNum += prn.getcStockNum();
                        cSexPrice = DoubleUtil.round(cSexPrice + prn.getcSexPrice() * prn.getcStockNum(), 4);
                        nodes.add(prn);
                    }else {
                        i += 1;
                        prn = list.get(i);
                        cStockNum += prn.getcStockNum();
                        cSexPrice = DoubleUtil.round(cSexPrice + prn.getcSexPrice() * prn.getcStockNum(), 4);
                        nodes.add(prn);
                        break;
                    }
                }
                // ProductVo 赋值
                ProductVo productVo = prnVoSetValue(prn, nodes, cStockNum, cSexPrice);
                productVos.add(productVo);
            }else {
                ProductRelationNode prn = list.get(i);
                nodes.add(prn);
                // ProductVo 赋值
                Double  cSexPrice = DoubleUtil.round( prn.getcSexPrice() * prn.getcStockNum(), 4);    // 吨数
                ProductVo productVo = prnVoSetValue(prn, nodes, prn.getcStockNum(), cSexPrice);
                productVos.add(productVo);
            }
        }
        return productVos;
    }

    /**
     * @Description     比较两个商品的数据     厂商名/ 品名/ 材质/ 规格 四项是否相同
     * @param prn       商品对象1
     * @param prn_next  对象2
     * @return boolean  true = 相同
     * @Author dongxiangwei
     * @Date 15:59 2020/2/12
     **/
    private boolean comparePRN(ProductRelationNode prn, ProductRelationNode prn_next){
        // 比较的四项    厂商名/ 品名/ 材质/ 规格 四项相同则录入
        if (prn.getcShopName().equals(prn_next.getcShopName()) && prn.getcName().equals(prn_next.getcName()) && prn.getcXsnum().equals(prn_next.getcXsnum()) && prn.getcTop().equals(prn_next.getcTop())){
            return true;
        }else {
            return false;
        }
    }

    private ProductVo prnVoSetValue(ProductRelationNode prn, List<ProductRelationNode> nodes, Integer cStockNum, Double cSexPrice){
        ProductVo productVo = new ProductVo();
        productVo.setcLogo(prn.getcLogo() == null? "" : prn.getcLogo());
        productVo.setcShopName(prn.getcShopName());
        productVo.setcName(prn.getcName());
        productVo.setcXsnum(prn.getcXsnum());
        productVo.setcTop(prn.getcTop());
        productVo.setcZkbl(prn.getcZkbl());
        productVo.setcStockNum(cStockNum);
        productVo.setcSexPrice(cSexPrice);
        productVo.setcNowPrice(prn.getcNowPrice());
        productVo.setcSummary(prn.getcSummary());
        productVo.setPrnList(nodes);
        return productVo;
    }

}
