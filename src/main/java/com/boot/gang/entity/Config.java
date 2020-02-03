package com.boot.gang.entity;

import java.util.Date;

public class Config {
    private String cId;

    private Date cCreateTime;

    private Date cLastUpdateTime;

    private String cKey;

    private String cValue;

    private String cComment;

    private String cCreateUser;

    private String cLastUpdateUser;

    private String cCityId;

    private String cChl;

    private String cProvinceId;

    private String cDistrictId;

    private String cBlockId;

    private String cHide;

    private String cShopColumnId;

    private String cShopColumnName;

    public Config(String cId, Date cCreateTime, Date cLastUpdateTime, String cKey, String cValue, String cComment, String cCreateUser, String cLastUpdateUser, String cCityId, String cChl, String cProvinceId, String cDistrictId, String cBlockId, String cHide, String cShopColumnId, String cShopColumnName) {
        this.cId = cId;
        this.cCreateTime = cCreateTime;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cKey = cKey;
        this.cValue = cValue;
        this.cComment = cComment;
        this.cCreateUser = cCreateUser;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cCityId = cCityId;
        this.cChl = cChl;
        this.cProvinceId = cProvinceId;
        this.cDistrictId = cDistrictId;
        this.cBlockId = cBlockId;
        this.cHide = cHide;
        this.cShopColumnId = cShopColumnId;
        this.cShopColumnName = cShopColumnName;
    }

    public Config() {
        super();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public Date getcLastUpdateTime() {
        return cLastUpdateTime;
    }

    public void setcLastUpdateTime(Date cLastUpdateTime) {
        this.cLastUpdateTime = cLastUpdateTime;
    }

    public String getcKey() {
        return cKey;
    }

    public void setcKey(String cKey) {
        this.cKey = cKey == null ? null : cKey.trim();
    }

    public String getcValue() {
        return cValue;
    }

    public void setcValue(String cValue) {
        this.cValue = cValue == null ? null : cValue.trim();
    }

    public String getcComment() {
        return cComment;
    }

    public void setcComment(String cComment) {
        this.cComment = cComment == null ? null : cComment.trim();
    }

    public String getcCreateUser() {
        return cCreateUser;
    }

    public void setcCreateUser(String cCreateUser) {
        this.cCreateUser = cCreateUser == null ? null : cCreateUser.trim();
    }

    public String getcLastUpdateUser() {
        return cLastUpdateUser;
    }

    public void setcLastUpdateUser(String cLastUpdateUser) {
        this.cLastUpdateUser = cLastUpdateUser == null ? null : cLastUpdateUser.trim();
    }

    public String getcCityId() {
        return cCityId;
    }

    public void setcCityId(String cCityId) {
        this.cCityId = cCityId == null ? null : cCityId.trim();
    }

    public String getcChl() {
        return cChl;
    }

    public void setcChl(String cChl) {
        this.cChl = cChl;
    }

    public String getcProvinceId() {
        return cProvinceId;
    }

    public void setcProvinceId(String cProvinceId) {
        this.cProvinceId = cProvinceId == null ? null : cProvinceId.trim();
    }

    public String getcDistrictId() {
        return cDistrictId;
    }

    public void setcDistrictId(String cDistrictId) {
        this.cDistrictId = cDistrictId == null ? null : cDistrictId.trim();
    }

    public String getcBlockId() {
        return cBlockId;
    }

    public void setcBlockId(String cBlockId) {
        this.cBlockId = cBlockId == null ? null : cBlockId.trim();
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public String getcShopColumnId() {
        return cShopColumnId;
    }

    public void setcShopColumnId(String cShopColumnId) {
        this.cShopColumnId = cShopColumnId == null ? null : cShopColumnId.trim();
    }

    public String getcShopColumnName() {
        return cShopColumnName;
    }

    public void setcShopColumnName(String cShopColumnName) {
        this.cShopColumnName = cShopColumnName == null ? null : cShopColumnName.trim();
    }
}