package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description 购物车
 * @Author dongxiangwei
 * @Date 18:39 2020/1/9
 **/
public class ShopTrolley {
    private String stId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date stCreatettime;

    private String stNowPriceDescription;

    private String stProductId;

    private String stProductName;

    private String stProductspec;

    private String stProducttexture;

    private String stRealname;

    private String stShopId;

    private Integer stState;

    private String stStoreaddress;

    private String stTonnum;

    private String stUserid;

    private Double stNowPrice;

    private Double stOriginalPrice;

    private Double stPrice;

    private String stShopName;

    public ShopTrolley(String stId, Date stCreatettime, String stNowPriceDescription, String stProductId, String stProductName, String stProductspec, String stProducttexture, String stRealname, String stShopId, Integer stState, String stStoreaddress, String stTonnum, String stUserid, Double stNowPrice, Double stOriginalPrice, Double stPrice, String stShopName) {
        this.stId = stId;
        this.stCreatettime = stCreatettime;
        this.stNowPriceDescription = stNowPriceDescription;
        this.stProductId = stProductId;
        this.stProductName = stProductName;
        this.stProductspec = stProductspec;
        this.stProducttexture = stProducttexture;
        this.stRealname = stRealname;
        this.stShopId = stShopId;
        this.stState = stState;
        this.stStoreaddress = stStoreaddress;
        this.stTonnum = stTonnum;
        this.stUserid = stUserid;
        this.stNowPrice = stNowPrice;
        this.stOriginalPrice = stOriginalPrice;
        this.stPrice = stPrice;
        this.stShopName = stShopName;
    }

    public ShopTrolley(String stProductId, String stUserid) {
        this.stProductId = stProductId;
        this.stUserid = stUserid;
    }

    public ShopTrolley() {
        super();
    }

    public String getStId() {
        return stId;
    }

    public void setStId(String stId) {
        this.stId = stId == null ? null : stId.trim();
    }

    public Date getStCreatettime() {
        return stCreatettime;
    }

    public void setStCreatettime(Date stCreatettime) {
        this.stCreatettime = stCreatettime;
    }

    public String getStNowPriceDescription() {
        return stNowPriceDescription;
    }

    public void setStNowPriceDescription(String stNowPriceDescription) {
        this.stNowPriceDescription = stNowPriceDescription == null ? null : stNowPriceDescription.trim();
    }

    public String getStProductId() {
        return stProductId;
    }

    public void setStProductId(String stProductId) {
        this.stProductId = stProductId == null ? null : stProductId.trim();
    }

    public String getStProductName() {
        return stProductName;
    }

    public void setStProductName(String stProductName) {
        this.stProductName = stProductName == null ? null : stProductName.trim();
    }

    public String getStProductspec() {
        return stProductspec;
    }

    public void setStProductspec(String stProductspec) {
        this.stProductspec = stProductspec == null ? null : stProductspec.trim();
    }

    public String getStProducttexture() {
        return stProducttexture;
    }

    public void setStProducttexture(String stProducttexture) {
        this.stProducttexture = stProducttexture == null ? null : stProducttexture.trim();
    }

    public String getStRealname() {
        return stRealname;
    }

    public void setStRealname(String stRealname) {
        this.stRealname = stRealname == null ? null : stRealname.trim();
    }

    public String getStShopId() {
        return stShopId;
    }

    public void setStShopId(String stShopId) {
        this.stShopId = stShopId == null ? null : stShopId.trim();
    }

    public Integer getStState() {
        return stState;
    }

    public void setStState(Integer stState) {
        this.stState = stState;
    }

    public String getStStoreaddress() {
        return stStoreaddress;
    }

    public void setStStoreaddress(String stStoreaddress) {
        this.stStoreaddress = stStoreaddress == null ? null : stStoreaddress.trim();
    }

    public String getStTonnum() {
        return stTonnum;
    }

    public void setStTonnum(String stTonnum) {
        this.stTonnum = stTonnum == null ? null : stTonnum.trim();
    }

    public String getStUserid() {
        return stUserid;
    }

    public void setStUserid(String stUserid) {
        this.stUserid = stUserid == null ? null : stUserid.trim();
    }

    public Double getStNowPrice() {
        return stNowPrice;
    }

    public void setStNowPrice(Double stNowPrice) {
        this.stNowPrice = stNowPrice;
    }

    public Double getStOriginalPrice() {
        return stOriginalPrice;
    }

    public void setStOriginalPrice(Double stOriginalPrice) {
        this.stOriginalPrice = stOriginalPrice;
    }

    public Double getStPrice() {
        return stPrice;
    }

    public void setStPrice(Double stPrice) {
        this.stPrice = stPrice;
    }

    public String getStShopName() {
        return stShopName;
    }

    public void setStShopName(String stShopName) {
        this.stShopName = stShopName;
    }
}