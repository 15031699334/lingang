package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PlanShopping {
    private String cId;

    private String cBlockId;

    private String cCityId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cCreateTime;

    private String cCreateUser;

    private String cDistrictId;

    private String cHide;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cLastUpdateTime;

    private String cLastUpdateUser;

    private String cProvinceId;

    private String cExplain;

    private String cNum;

    private Integer psType;     // 0 = 计划采购 1 = 求购信息

    private String cShopColumnName;

    private String cShopColumnTypeId;

    private String cShopname;   // 商品名

    private String cSpec;

    private String cTexttrue;

    private String cUnit;

    private String cUserId;

    private String cPhone;

    private String cRealname;

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

    public String getcExplain() {
        return cExplain;
    }

    public void setcExplain(String cExplain) {
        this.cExplain = cExplain == null ? null : cExplain.trim();
    }

    public String getcNum() {
        return cNum;
    }

    public void setcNum(String cNum) {
        this.cNum = cNum == null ? null : cNum.trim();
    }

    public Integer getPsType() {
        return psType;
    }

    public void setPsType(Integer psType) {
        this.psType = psType;
    }

    public String getcShopColumnName() {
        return cShopColumnName;
    }

    public void setcShopColumnName(String cShopColumnName) {
        this.cShopColumnName = cShopColumnName == null ? null : cShopColumnName.trim();
    }

    public String getcShopColumnTypeId() {
        return cShopColumnTypeId;
    }

    public void setcShopColumnTypeId(String cShopColumnTypeId) {
        this.cShopColumnTypeId = cShopColumnTypeId == null ? null : cShopColumnTypeId.trim();
    }

    public String getcShopname() {
        return cShopname;
    }

    public void setcShopname(String cShopname) {
        this.cShopname = cShopname == null ? null : cShopname.trim();
    }

    public String getcSpec() {
        return cSpec;
    }

    public void setcSpec(String cSpec) {
        this.cSpec = cSpec == null ? null : cSpec.trim();
    }

    public String getcTexttrue() {
        return cTexttrue;
    }

    public void setcTexttrue(String cTexttrue) {
        this.cTexttrue = cTexttrue == null ? null : cTexttrue.trim();
    }

    public String getcUnit() {
        return cUnit;
    }

    public void setcUnit(String cUnit) {
        this.cUnit = cUnit == null ? null : cUnit.trim();
    }

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcRealname() {
        return cRealname;
    }

    public void setcRealname(String cRealname) {
        this.cRealname = cRealname == null ? null : cRealname.trim();
    }
}