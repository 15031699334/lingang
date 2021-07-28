package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class VolumePrice {
    private String cId;

    private String cBlockId;

    private String cCityId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cCreateTime;

    private String cCreateUser;

    private String cDistrictId;

    private String cHide;

    private Integer cSort;

    private Integer cTop;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cLastUpdateTime;

    private String cLastUpdateUser;

    private String cProvinceId;

    private String cProvince;

    private String cShopColumnType;

    private String cShopColumnTypeId;

    private String cStatechange;

    private String cTodayprice;

    private String cYesterdayprice;

    public VolumePrice(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, String cHide, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, String cProvince, String cShopColumnType, String cShopColumnTypeId, String cStatechange, String cTodayprice, String cYesterdayprice) {
        this.cId = cId;
        this.cBlockId = cBlockId;
        this.cCityId = cCityId;
        this.cCreateTime = cCreateTime;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cHide = cHide;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cProvince = cProvince;
        this.cShopColumnType = cShopColumnType;
        this.cShopColumnTypeId = cShopColumnTypeId;
        this.cStatechange = cStatechange;
        this.cTodayprice = cTodayprice;
        this.cYesterdayprice = cYesterdayprice;
    }

    public VolumePrice() {
        super();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcBlockId() {
        return cBlockId;
    }

    public void setcBlockId(String cBlockId) {
        this.cBlockId = cBlockId == null ? null : cBlockId.trim();
    }

    public String getcCityId() {
        return cCityId;
    }

    public void setcCityId(String cCityId) {
        this.cCityId = cCityId == null ? null : cCityId.trim();
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public String getcCreateUser() {
        return cCreateUser;
    }

    public void setcCreateUser(String cCreateUser) {
        this.cCreateUser = cCreateUser == null ? null : cCreateUser.trim();
    }

    public String getcDistrictId() {
        return cDistrictId;
    }

    public void setcDistrictId(String cDistrictId) {
        this.cDistrictId = cDistrictId == null ? null : cDistrictId.trim();
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public Integer getcSort() {
        return cSort;
    }

    public void setcSort(Integer cSort) {
        this.cSort = cSort;
    }

    public Integer getcTop() {
        return cTop;
    }

    public void setcTop(Integer cTop) {
        this.cTop = cTop;
    }

    public Date getcLastUpdateTime() {
        return cLastUpdateTime;
    }

    public void setcLastUpdateTime(Date cLastUpdateTime) {
        this.cLastUpdateTime = cLastUpdateTime;
    }

    public String getcLastUpdateUser() {
        return cLastUpdateUser;
    }

    public void setcLastUpdateUser(String cLastUpdateUser) {
        this.cLastUpdateUser = cLastUpdateUser == null ? null : cLastUpdateUser.trim();
    }

    public String getcProvinceId() {
        return cProvinceId;
    }

    public void setcProvinceId(String cProvinceId) {
        this.cProvinceId = cProvinceId == null ? null : cProvinceId.trim();
    }

    public String getcProvince() {
        return cProvince;
    }

    public void setcProvince(String cProvince) {
        this.cProvince = cProvince == null ? null : cProvince.trim();
    }

    public String getcShopColumnType() {
        return cShopColumnType;
    }

    public void setcShopColumnType(String cShopColumnType) {
        this.cShopColumnType = cShopColumnType == null ? null : cShopColumnType.trim();
    }

    public String getcShopColumnTypeId() {
        return cShopColumnTypeId;
    }

    public void setcShopColumnTypeId(String cShopColumnTypeId) {
        this.cShopColumnTypeId = cShopColumnTypeId == null ? null : cShopColumnTypeId.trim();
    }

    public String getcStatechange() {
        return cStatechange;
    }

    public void setcStatechange(String cStatechange) {
        this.cStatechange = cStatechange == null ? null : cStatechange.trim();
    }

    public String getcTodayprice() {
        return cTodayprice;
    }

    public void setcTodayprice(String cTodayprice) {
        this.cTodayprice = cTodayprice == null ? null : cTodayprice.trim();
    }

    public String getcYesterdayprice() {
        return cYesterdayprice;
    }

    public void setcYesterdayprice(String cYesterdayprice) {
        this.cYesterdayprice = cYesterdayprice == null ? null : cYesterdayprice.trim();
    }
}