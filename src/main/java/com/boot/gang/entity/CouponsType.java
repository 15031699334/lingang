package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class CouponsType {
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cBeginTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cEndTime;

    private Integer cIfOverdue;

    private String cLogo;

    private String cName;

    private Integer cNum;

    private Double cPrice;  //优惠金额/ 优惠金额最小值

    private Double cPriceSuffix;    //优惠金额最大值

    private Integer cReceiveNum;

    private Integer cUseNum;

    private Integer cType;

    private String cHide;

    private String cCreateUserId;

    private Double cLimitPrice;     // 优惠限额条件

    private String cPrId;

    private String cPrName;

    private String cQrCodeUrl;

    private String cShopId;

    private String cShopName;

    public CouponsType(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, Date cBeginTime, Date cEndTime, Integer cIfOverdue, String cLogo, String cName, Integer cNum, Double cPrice,  Double cPriceSuffix, Integer cReceiveNum, Integer cUseNum, Integer cType, String cHide, String cCreateUserId, Double cLimitPrice, String cPrId, String cPrName, String cQrCodeUrl, String cShopId, String cShopName) {
        this.cId = cId;
        this.cBlockId = cBlockId;
        this.cCityId = cCityId;
        this.cCreateTime = cCreateTime;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cBeginTime = cBeginTime;
        this.cEndTime = cEndTime;
        this.cIfOverdue = cIfOverdue;
        this.cLogo = cLogo;
        this.cName = cName;
        this.cNum = cNum;
        this.cPrice = cPrice;
        this.cPriceSuffix = cPriceSuffix;
        this.cReceiveNum = cReceiveNum;
        this.cUseNum = cUseNum;
        this.cType = cType;
        this.cHide = cHide;
        this.cCreateUserId = cCreateUserId;
        this.cLimitPrice = cLimitPrice;
        this.cPrId = cPrId;
        this.cPrName = cPrName;
        this.cQrCodeUrl = cQrCodeUrl;
        this.cShopId = cShopId;
        this.cShopName = cShopName;
    }

    public CouponsType() {
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

    public Date getcBeginTime() {
        return cBeginTime;
    }

    public void setcBeginTime(Date cBeginTime) {
        this.cBeginTime = cBeginTime;
    }

    public Date getcEndTime() {
        return cEndTime;
    }

    public void setcEndTime(Date cEndTime) {
        this.cEndTime = cEndTime;
    }

    public Integer getcIfOverdue() {
        return cIfOverdue;
    }

    public void setcIfOverdue(Integer cIfOverdue) {
        this.cIfOverdue = cIfOverdue;
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

    public Integer getcNum() {
        return cNum;
    }

    public void setcNum(Integer cNum) {
        this.cNum = cNum;
    }

    public Double getcPrice() {
        return cPrice;
    }

    public void setcPrice(Double cPrice) {
        this.cPrice = cPrice;
    }

    public Integer getcReceiveNum() {
        return cReceiveNum;
    }

    public void setcReceiveNum(Integer cReceiveNum) {
        this.cReceiveNum = cReceiveNum;
    }

    public Integer getcUseNum() {
        return cUseNum;
    }

    public void setcUseNum(Integer cUseNum) {
        this.cUseNum = cUseNum;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public String getcCreateUserId() {
        return cCreateUserId;
    }

    public void setcCreateUserId(String cCreateUserId) {
        this.cCreateUserId = cCreateUserId == null ? null : cCreateUserId.trim();
    }

    public Double getcLimitPrice() {
        return cLimitPrice;
    }

    public void setcLimitPrice(Double cLimitPrice) {
        this.cLimitPrice = cLimitPrice;
    }

    public String getcPrId() {
        return cPrId;
    }

    public void setcPrId(String cPrId) {
        this.cPrId = cPrId == null ? null : cPrId.trim();
    }

    public String getcPrName() {
        return cPrName;
    }

    public void setcPrName(String cPrName) {
        this.cPrName = cPrName == null ? null : cPrName.trim();
    }

    public String getcQrCodeUrl() {
        return cQrCodeUrl;
    }

    public void setcQrCodeUrl(String cQrCodeUrl) {
        this.cQrCodeUrl = cQrCodeUrl == null ? null : cQrCodeUrl.trim();
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

    public Double getcPriceSuffix() {
        return cPriceSuffix;
    }

    public void setcPriceSuffix(Double cPriceSuffix) {
        this.cPriceSuffix = cPriceSuffix;
    }
}