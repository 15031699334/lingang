package com.boot.gang.entity;

import java.util.List;

/**
 * @ClassName: lingangApi
 * @description: 商品的vo
 * @author: dongxiangwei
 * @create: 2020-02-12 15:23
 **/
public class ProductVo {

    private String cLogo;   // logo
    private String cShopName;   // 厂商名称
    private String cName;       // 品名
    private String cXsnum;      // 材质
    private String cTop;        // 规格
    private String cZkbl;       // 仓库名称
    private Integer cStockNum;   // 库存数量
    private Double cSexPrice;   // 吨数
    private Double cNowPrice;   // 单价
    private String cSummary;    // 备注
    private List<ProductRelationNode> prnList;

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo;
    }

    public String getcShopName() {
        return cShopName;
    }

    public void setcShopName(String cShopName) {
        this.cShopName = cShopName;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcXsnum() {
        return cXsnum;
    }

    public void setcXsnum(String cXsnum) {
        this.cXsnum = cXsnum;
    }

    public String getcTop() {
        return cTop;
    }

    public void setcTop(String cTop) {
        this.cTop = cTop;
    }

    public String getcZkbl() {
        return cZkbl;
    }

    public void setcZkbl(String cZkbl) {
        this.cZkbl = cZkbl;
    }

    public Integer getcStockNum() {
        return cStockNum;
    }

    public void setcStockNum(Integer cStockNum) {
        this.cStockNum = cStockNum;
    }

    public Double getcSexPrice() {
        return cSexPrice;
    }

    public void setcSexPrice(Double cSexPrice) {
        this.cSexPrice = cSexPrice;
    }

    public Double getcNowPrice() {
        return cNowPrice;
    }

    public void setcNowPrice(Double cNowPrice) {
        this.cNowPrice = cNowPrice;
    }

    public String getcSummary() {
        return cSummary;
    }

    public void setcSummary(String cSummary) {
        this.cSummary = cSummary;
    }

    public List<ProductRelationNode> getPrnList() {
        return prnList;
    }

    public void setPrnList(List<ProductRelationNode> prnList) {
        this.prnList = prnList;
    }
}
