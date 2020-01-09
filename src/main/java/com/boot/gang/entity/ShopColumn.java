package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ShopColumn {
    private String cId;

    private String cBlockId;

    private String cCityId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cCreateTime;

    private String cCreateUser;

    private String cDistrictId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cLastUpdateTime;

    private String cLastUpdateUser;

    private String cProvinceId;

    private String cDescription;

    private String cGuige;

    private String cLogo;

    private String cName;

    private Integer cSort;

    private String cSummary;

    private Integer cType;

    private String cGglogo;

    private String cHide;

    public ShopColumn(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, String cDescription, String cGuige, String cLogo, String cName, Integer cSort, String cSummary, Integer cType, String cGglogo, String cHide) {
        this.cId = cId;
        this.cBlockId = cBlockId;
        this.cCityId = cCityId;
        this.cCreateTime = cCreateTime;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cDescription = cDescription;
        this.cGuige = cGuige;
        this.cLogo = cLogo;
        this.cName = cName;
        this.cSort = cSort;
        this.cSummary = cSummary;
        this.cType = cType;
        this.cGglogo = cGglogo;
        this.cHide = cHide;
    }

    public ShopColumn() {
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

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription == null ? null : cDescription.trim();
    }

    public String getcGuige() {
        return cGuige;
    }

    public void setcGuige(String cGuige) {
        this.cGuige = cGuige == null ? null : cGuige.trim();
    }

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo == null ? null : cLogo.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Integer getcSort() {
        return cSort;
    }

    public void setcSort(Integer cSort) {
        this.cSort = cSort;
    }

    public String getcSummary() {
        return cSummary;
    }

    public void setcSummary(String cSummary) {
        this.cSummary = cSummary == null ? null : cSummary.trim();
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public String getcGglogo() {
        return cGglogo;
    }

    public void setcGglogo(String cGglogo) {
        this.cGglogo = cGglogo == null ? null : cGglogo.trim();
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }
}