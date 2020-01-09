package com.boot.gang.entity;

import java.util.Date;

public class Province {
    private String cId;

    private String cNo;

    private String cName;

    private Date cCreateTime;

    private Date cLastUpdateTime;

    private Integer cSort;

    private String cAdminId;

    private String cAdminName;

    private String cAreaId;

    private String cAreaName;

    private String cShopId;

    private String cShopName;

    private String cSsId;

    private String cCityId;

    private String cCreateUser;

    private String cDistrictId;

    private String cLastUpdateUser;

    private String cProvinceId;

    private String cAgenCode;

    private String cAgenUserId;

    private String cLogo;

    private String cBlockId;

    private String cHide;

    private String isVolumePrice;

    private String cStoreName;

    public Province(String cId, String cNo, String cName, Date cCreateTime, Date cLastUpdateTime, Integer cSort, String cAdminId, String cAdminName, String cAreaId, String cAreaName, String cShopId, String cShopName, String cSsId, String cCityId, String cCreateUser, String cDistrictId, String cLastUpdateUser, String cProvinceId, String cAgenCode, String cAgenUserId, String cLogo, String cBlockId, String cHide, String isVolumePrice, String cStoreName) {
        this.cId = cId;
        this.cNo = cNo;
        this.cName = cName;
        this.cCreateTime = cCreateTime;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cSort = cSort;
        this.cAdminId = cAdminId;
        this.cAdminName = cAdminName;
        this.cAreaId = cAreaId;
        this.cAreaName = cAreaName;
        this.cShopId = cShopId;
        this.cShopName = cShopName;
        this.cSsId = cSsId;
        this.cCityId = cCityId;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cAgenCode = cAgenCode;
        this.cAgenUserId = cAgenUserId;
        this.cLogo = cLogo;
        this.cBlockId = cBlockId;
        this.cHide = cHide;
        this.isVolumePrice = isVolumePrice;
        this.cStoreName = cStoreName;
    }

    public Province() {
        super();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcNo() {
        return cNo;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo == null ? null : cNo.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
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

    public Integer getcSort() {
        return cSort;
    }

    public void setcSort(Integer cSort) {
        this.cSort = cSort;
    }

    public String getcAdminId() {
        return cAdminId;
    }

    public void setcAdminId(String cAdminId) {
        this.cAdminId = cAdminId == null ? null : cAdminId.trim();
    }

    public String getcAdminName() {
        return cAdminName;
    }

    public void setcAdminName(String cAdminName) {
        this.cAdminName = cAdminName == null ? null : cAdminName.trim();
    }

    public String getcAreaId() {
        return cAreaId;
    }

    public void setcAreaId(String cAreaId) {
        this.cAreaId = cAreaId == null ? null : cAreaId.trim();
    }

    public String getcAreaName() {
        return cAreaName;
    }

    public void setcAreaName(String cAreaName) {
        this.cAreaName = cAreaName == null ? null : cAreaName.trim();
    }

    public String getcShopId() {
        return cShopId;
    }

    public void setcShopId(String cShopId) {
        this.cShopId = cShopId == null ? null : cShopId.trim();
    }

    public String getcShopName() {
        return cShopName;
    }

    public void setcShopName(String cShopName) {
        this.cShopName = cShopName == null ? null : cShopName.trim();
    }

    public String getcSsId() {
        return cSsId;
    }

    public void setcSsId(String cSsId) {
        this.cSsId = cSsId == null ? null : cSsId.trim();
    }

    public String getcCityId() {
        return cCityId;
    }

    public void setcCityId(String cCityId) {
        this.cCityId = cCityId == null ? null : cCityId.trim();
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

    public String getcAgenCode() {
        return cAgenCode;
    }

    public void setcAgenCode(String cAgenCode) {
        this.cAgenCode = cAgenCode == null ? null : cAgenCode.trim();
    }

    public String getcAgenUserId() {
        return cAgenUserId;
    }

    public void setcAgenUserId(String cAgenUserId) {
        this.cAgenUserId = cAgenUserId == null ? null : cAgenUserId.trim();
    }

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo == null ? null : cLogo.trim();
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

    public String getIsVolumePrice() {
        return isVolumePrice;
    }

    public void setIsVolumePrice(String isVolumePrice) {
        this.isVolumePrice = isVolumePrice == null ? null : isVolumePrice.trim();
    }

    public String getcStoreName() {
        return cStoreName;
    }

    public void setcStoreName(String cStoreName) {
        this.cStoreName = cStoreName == null ? null : cStoreName.trim();
    }
}