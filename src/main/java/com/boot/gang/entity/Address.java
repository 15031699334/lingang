package com.boot.gang.entity;

import java.util.Date;

public class Address {
    private String cId;

    private String cBlockId;

    private String cCityId;     // 城市编号

    private Date cCreateTime;   // 创建时间

    private String cCreateUser;     // 创建人

    private String cDistrictId;     // 地区编号

    private Date cLastUpdateTime;   // 上次修改时间

    private String cLastUpdateUser;

    private String cProvinceId;     // 省份编号

    private String cAddress;        // 详细地址

    private Integer cIfDefault;     // 是否默认

    private String cName;           // 收件人姓名

    private String cPhone;          // 收件人电话

    private String cRelationId;     // 所属人用户id

    private Integer cType;

    private String cZipcode;

    private String cHide;

    private String cCity;       // 城市

    private String cDistrict;       // 县区

    private String cProvince;       //省份名称

    public Address(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, String cAddress, Integer cIfDefault, String cName, String cPhone, String cRelationId, Integer cType, String cZipcode, String cHide, String cCity, String cDistrict, String cProvince) {
        this.cId = cId;
        this.cBlockId = cBlockId;
        this.cCityId = cCityId;
        this.cCreateTime = cCreateTime;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cAddress = cAddress;
        this.cIfDefault = cIfDefault;
        this.cName = cName;
        this.cPhone = cPhone;
        this.cRelationId = cRelationId;
        this.cType = cType;
        this.cZipcode = cZipcode;
        this.cHide = cHide;
        this.cCity = cCity;
        this.cDistrict = cDistrict;
        this.cProvince = cProvince;
    }

    public Address() {
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

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }

    public Integer getcIfDefault() {
        return cIfDefault;
    }

    public void setcIfDefault(Integer cIfDefault) {
        this.cIfDefault = cIfDefault;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcRelationId() {
        return cRelationId;
    }

    public void setcRelationId(String cRelationId) {
        this.cRelationId = cRelationId == null ? null : cRelationId.trim();
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public String getcZipcode() {
        return cZipcode;
    }

    public void setcZipcode(String cZipcode) {
        this.cZipcode = cZipcode == null ? null : cZipcode.trim();
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity == null ? null : cCity.trim();
    }

    public String getcDistrict() {
        return cDistrict;
    }

    public void setcDistrict(String cDistrict) {
        this.cDistrict = cDistrict == null ? null : cDistrict.trim();
    }

    public String getcProvince() {
        return cProvince;
    }

    public void setcProvince(String cProvince) {
        this.cProvince = cProvince == null ? null : cProvince.trim();
    }
}