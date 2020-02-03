package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Coupons {
    private String cId;         // 领取记录id

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cCreateTime;       // 优惠券领取时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cBeginTime;       // 有效期（起）

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cEndTime;         // 有效期（止）

    private Integer cIfUse;         // 是否使用 0=否 1=是

    private String cCouponsTypeId;      // 优惠券id

    private String cName;           // 优惠券名

    private Double cPrice;          // 优惠金额

    private String cUserId;         // 用户ID

    private String cRealname;       // 用户名称

    private Double cLimitPrice;     // 满额限制金额

    private String cOutTradeNo;     // 消费凭单(订单号)

    private Integer cUserNo;        // 用户NO

    private String cBlockId;

    private String cCityId;

    private String cCreateUser;

    private String cDistrictId;

    private Date cLastUpdateTime;

    private String cLastUpdateUser;

    private String cProvinceId;

    private String cCode;

    private String cFromArg;

    private Integer cIfOverdue;

    private Integer cIfReceive;

    private String cLogo;

    private String cCreateUserId;

    private String cTransactionId;

    private String cPrId;

    private String cPrName;

    private String cShopId;

    private String cShopName;

    private Integer cNum;

    private Integer cReceiveNum;

    private Integer cType;

    private Integer cUseNum;

    private String cHide;

    public Coupons(String cCouponsTypeId, String cUserId, Double cPrice) {
        this.cCouponsTypeId = cCouponsTypeId;
        this.cUserId = cUserId;
        this.cPrice = cPrice;
    }

    public Coupons(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, Date cBeginTime, String cCode, String cCouponsTypeId, Date cEndTime, String cFromArg, Integer cIfOverdue, Integer cIfReceive, Integer cIfUse, String cLogo, String cName, Double cPrice, String cUserId, Integer cNum, Integer cReceiveNum, Integer cType, Integer cUseNum, String cHide, String cRealname, String cCreateUserId, Double cLimitPrice, String cOutTradeNo, String cTransactionId, Integer cUserNo, String cPrId, String cPrName, String cShopId, String cShopName) {
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
        this.cCode = cCode;
        this.cCouponsTypeId = cCouponsTypeId;
        this.cEndTime = cEndTime;
        this.cFromArg = cFromArg;
        this.cIfOverdue = cIfOverdue;
        this.cIfReceive = cIfReceive;
        this.cIfUse = cIfUse;
        this.cLogo = cLogo;
        this.cName = cName;
        this.cPrice = cPrice;
        this.cUserId = cUserId;
        this.cNum = cNum;
        this.cReceiveNum = cReceiveNum;
        this.cType = cType;
        this.cUseNum = cUseNum;
        this.cHide = cHide;
        this.cRealname = cRealname;
        this.cCreateUserId = cCreateUserId;
        this.cLimitPrice = cLimitPrice;
        this.cOutTradeNo = cOutTradeNo;
        this.cTransactionId = cTransactionId;
        this.cUserNo = cUserNo;
        this.cPrId = cPrId;
        this.cPrName = cPrName;
        this.cShopId = cShopId;
        this.cShopName = cShopName;
    }

    public Coupons() {
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

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode == null ? null : cCode.trim();
    }

    public String getcCouponsTypeId() {
        return cCouponsTypeId;
    }

    public void setcCouponsTypeId(String cCouponsTypeId) {
        this.cCouponsTypeId = cCouponsTypeId == null ? null : cCouponsTypeId.trim();
    }

    public Date getcEndTime() {
        return cEndTime;
    }

    public void setcEndTime(Date cEndTime) {
        this.cEndTime = cEndTime;
    }

    public String getcFromArg() {
        return cFromArg;
    }

    public void setcFromArg(String cFromArg) {
        this.cFromArg = cFromArg == null ? null : cFromArg.trim();
    }

    public Integer getcIfOverdue() {
        return cIfOverdue;
    }

    public void setcIfOverdue(Integer cIfOverdue) {
        this.cIfOverdue = cIfOverdue;
    }

    public Integer getcIfReceive() {
        return cIfReceive;
    }

    public void setcIfReceive(Integer cIfReceive) {
        this.cIfReceive = cIfReceive;
    }

    public Integer getcIfUse() {
        return cIfUse;
    }

    public void setcIfUse(Integer cIfUse) {
        this.cIfUse = cIfUse;
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

    public Double getcPrice() {
        return cPrice;
    }

    public void setcPrice(Double cPrice) {
        this.cPrice = cPrice;
    }

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }

    public Integer getcNum() {
        return cNum;
    }

    public void setcNum(Integer cNum) {
        this.cNum = cNum;
    }

    public Integer getcReceiveNum() {
        return cReceiveNum;
    }

    public void setcReceiveNum(Integer cReceiveNum) {
        this.cReceiveNum = cReceiveNum;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public Integer getcUseNum() {
        return cUseNum;
    }

    public void setcUseNum(Integer cUseNum) {
        this.cUseNum = cUseNum;
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public String getcRealname() {
        return cRealname;
    }

    public void setcRealname(String cRealname) {
        this.cRealname = cRealname == null ? null : cRealname.trim();
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

    public String getcOutTradeNo() {
        return cOutTradeNo;
    }

    public void setcOutTradeNo(String cOutTradeNo) {
        this.cOutTradeNo = cOutTradeNo == null ? null : cOutTradeNo.trim();
    }

    public String getcTransactionId() {
        return cTransactionId;
    }

    public void setcTransactionId(String cTransactionId) {
        this.cTransactionId = cTransactionId == null ? null : cTransactionId.trim();
    }

    public Integer getcUserNo() {
        return cUserNo;
    }

    public void setcUserNo(Integer cUserNo) {
        this.cUserNo = cUserNo;
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
}