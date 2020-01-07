package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class Order {
    private String cId;             //

    private List<OrderDetail> detailList;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cCreateTime;       // 订单创建时间

    private String cOrderNo;        // 订单号

    private Integer cState;         //  订单状态  0:订单取消 1:待付款 2: 已付款、待发货  3:已发货  4:已收货   5:完结

    private Double cPrice;          // 订单总金额

    private String cUserId;         // 下单人id

    private String cPhone;          // 客户手机

    private String cRealname;       // 客户姓名

    private String cCouponId;       // 优惠券id

    private Double cCouponPrice;    // 优惠卷优惠金额

    private Integer cCategory;      // 订单类别 1=普通订单 2=拼团订单

    private String cCouponComment;      // 优惠券备注

    private String cGroupNum;       // 拼团号(拼团发起单单号)

    private Double cMoneyPay;       // 现金支付金额

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cPayTime;          // 实际支付时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cPlanPayTime;      // 计划支付时间

    private String cPlatformComment;        //平台优惠备注

    private Double cPlatformPrice;          // 平台优惠价

    private Double cTransportPrice;         // 运输费

    private String cTransportationRequirement;      // 运输要求

    private String cWhiteNoteComment;           // 白条备注

    private Double cWhiteNotePrice;             // 白条优惠金额

    private Integer cNum;                       // 使用钢豆数量

    private Double cGold;                       // 钢豆优惠金额

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cLastUpdateTime;               // 最后修改时间

    private String cBlockId;

    private String cCityId;

    private String cDistrictId;

    private String cLastUpdateUser;

    private String cProvinceId;

    private String cAddressid;

    private String cCreateUser;

    private Date cFahuoTime;

    private String cGoodsInterval;

    private Integer cGoodsSex;

    private Integer cGoodsTotal;

    private String cGuige;

    private Double cGzFl;

    private Integer cIfCanInvoice;

    private Integer cIfReply;

    private Integer cIfTake;

    private Integer cIfxianshang;

    private String cInvoiceTitle;

    private String cLeixing;

    private String cLogisticsId;

    private Integer cOrderSsid;

    private String cOutTradeNo;

    private String cParamList;

    private String cPayType;

    private String cPayUser;

    private String cProductCode;

    private String cProductId;

    private String cProductLogo;

    private String cProductName;

    private String cRequire;

    private Double cSexPrice;

    private String cShopbId;

    private String cShopId;

    private Date cShouhuoTime;

    private String cSummary;

    private String cTihuoShopId;

    private String cTrackingComp;

    private String cTrackingNo;

    private String cTransactionId;

    private Integer cType;

    private Double cUnitPrice;

    private Double cYoufeiFee;

    private Double cZhPrice;

    private Double cZjrFl;

    private String cFactId;

    private String cFactName;

    private String cShopName;

    private String cHide;

    private Double cFactMoney;

    private Double cPlatMoney;

    private Double cShopMoney;

    private Integer cRefundNum;

    private Integer cDispute;

    private Integer cStage;

    private String cAgentId;

    private Double cAgentMoney;

    private String cAgentName;

    private String cProduct2Id;

    private Double cOneGold;

    private Double cThreeGold;

    private Double cTwoGold;

    private String cTihuoShopCode;

    private String cTihuoShopName;

    private Double cFuwuFee;

    private String cIfZiti;

    private Integer cSctype;

    private String cFuwuFeeType;

    private String cUserNo;

    private Integer cIfPingjia;

    private String cMemberId;

    private String cMemberName;

    private Integer cMemberNo;

    private String cMemberTime;

    private String cPingjiaMemo;

    private Integer cPingjiaStar;

    private String cXsnum;

    private String cZkbl;

    private Double cMtlGold;

    public Order(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, String cAddressid, String cCouponId, Double cCouponPrice, Date cFahuoTime, Double cGold, String cGoodsInterval, Integer cGoodsSex, Integer cGoodsTotal, String cGuige, Double cGzFl, Integer cIfCanInvoice, Integer cIfReply, Integer cIfTake, Integer cIfxianshang, String cInvoiceTitle, String cLeixing, String cLogisticsId, Integer cNum, String cOrderNo, Integer cOrderSsid, String cOutTradeNo, String cParamList, String cPayType, String cPayUser, Double cPrice, String cProductCode, String cProductId, String cProductLogo, String cProductName, String cRequire, Double cSexPrice, String cShopbId, String cShopId, Date cShouhuoTime, Integer cState, String cSummary, String cTihuoShopId, String cTrackingComp, String cTrackingNo, String cTransactionId, Integer cType, Double cUnitPrice, String cUserId, Double cYoufeiFee, Double cZhPrice, Double cZjrFl, String cFactId, String cFactName, String cShopName, String cHide, Double cFactMoney, Double cPlatMoney, Double cShopMoney, Integer cRefundNum, Integer cDispute, String cPhone, String cRealname, Integer cStage, String cAgentId, Double cAgentMoney, String cAgentName, String cProduct2Id, Double cOneGold, Double cThreeGold, Double cTwoGold, String cTihuoShopCode, String cTihuoShopName, Double cFuwuFee, String cIfZiti, Integer cSctype, String cFuwuFeeType, String cUserNo, Integer cIfPingjia, String cMemberId, String cMemberName, Integer cMemberNo, String cMemberTime, String cPingjiaMemo, Integer cPingjiaStar, String cXsnum, String cZkbl, Double cMtlGold, Integer cCategory, String cCouponComment, String cGroupNum, Double cMoneyPay, Date cPayTime, Date cPlanPayTime, String cPlatformComment, Double cPlatformPrice, Double cTransportPrice, String cTransportationRequirement, String cWhiteNoteComment, Double cWhiteNotePrice) {
        this.cId = cId;
        this.cBlockId = cBlockId;
        this.cCityId = cCityId;
        this.cCreateTime = cCreateTime;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cAddressid = cAddressid;
        this.cCouponId = cCouponId;
        this.cCouponPrice = cCouponPrice;
        this.cFahuoTime = cFahuoTime;
        this.cGold = cGold;
        this.cGoodsInterval = cGoodsInterval;
        this.cGoodsSex = cGoodsSex;
        this.cGoodsTotal = cGoodsTotal;
        this.cGuige = cGuige;
        this.cGzFl = cGzFl;
        this.cIfCanInvoice = cIfCanInvoice;
        this.cIfReply = cIfReply;
        this.cIfTake = cIfTake;
        this.cIfxianshang = cIfxianshang;
        this.cInvoiceTitle = cInvoiceTitle;
        this.cLeixing = cLeixing;
        this.cLogisticsId = cLogisticsId;
        this.cNum = cNum;
        this.cOrderNo = cOrderNo;
        this.cOrderSsid = cOrderSsid;
        this.cOutTradeNo = cOutTradeNo;
        this.cParamList = cParamList;
        this.cPayType = cPayType;
        this.cPayUser = cPayUser;
        this.cPrice = cPrice;
        this.cProductCode = cProductCode;
        this.cProductId = cProductId;
        this.cProductLogo = cProductLogo;
        this.cProductName = cProductName;
        this.cRequire = cRequire;
        this.cSexPrice = cSexPrice;
        this.cShopbId = cShopbId;
        this.cShopId = cShopId;
        this.cShouhuoTime = cShouhuoTime;
        this.cState = cState;
        this.cSummary = cSummary;
        this.cTihuoShopId = cTihuoShopId;
        this.cTrackingComp = cTrackingComp;
        this.cTrackingNo = cTrackingNo;
        this.cTransactionId = cTransactionId;
        this.cType = cType;
        this.cUnitPrice = cUnitPrice;
        this.cUserId = cUserId;
        this.cYoufeiFee = cYoufeiFee;
        this.cZhPrice = cZhPrice;
        this.cZjrFl = cZjrFl;
        this.cFactId = cFactId;
        this.cFactName = cFactName;
        this.cShopName = cShopName;
        this.cHide = cHide;
        this.cFactMoney = cFactMoney;
        this.cPlatMoney = cPlatMoney;
        this.cShopMoney = cShopMoney;
        this.cRefundNum = cRefundNum;
        this.cDispute = cDispute;
        this.cPhone = cPhone;
        this.cRealname = cRealname;
        this.cStage = cStage;
        this.cAgentId = cAgentId;
        this.cAgentMoney = cAgentMoney;
        this.cAgentName = cAgentName;
        this.cProduct2Id = cProduct2Id;
        this.cOneGold = cOneGold;
        this.cThreeGold = cThreeGold;
        this.cTwoGold = cTwoGold;
        this.cTihuoShopCode = cTihuoShopCode;
        this.cTihuoShopName = cTihuoShopName;
        this.cFuwuFee = cFuwuFee;
        this.cIfZiti = cIfZiti;
        this.cSctype = cSctype;
        this.cFuwuFeeType = cFuwuFeeType;
        this.cUserNo = cUserNo;
        this.cIfPingjia = cIfPingjia;
        this.cMemberId = cMemberId;
        this.cMemberName = cMemberName;
        this.cMemberNo = cMemberNo;
        this.cMemberTime = cMemberTime;
        this.cPingjiaMemo = cPingjiaMemo;
        this.cPingjiaStar = cPingjiaStar;
        this.cXsnum = cXsnum;
        this.cZkbl = cZkbl;
        this.cMtlGold = cMtlGold;
        this.cCategory = cCategory;
        this.cCouponComment = cCouponComment;
        this.cGroupNum = cGroupNum;
        this.cMoneyPay = cMoneyPay;
        this.cPayTime = cPayTime;
        this.cPlanPayTime = cPlanPayTime;
        this.cPlatformComment = cPlatformComment;
        this.cPlatformPrice = cPlatformPrice;
        this.cTransportPrice = cTransportPrice;
        this.cTransportationRequirement = cTransportationRequirement;
        this.cWhiteNoteComment = cWhiteNoteComment;
        this.cWhiteNotePrice = cWhiteNotePrice;
    }

    public Order() {
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

    public String getcAddressid() {
        return cAddressid;
    }

    public void setcAddressid(String cAddressid) {
        this.cAddressid = cAddressid == null ? null : cAddressid.trim();
    }

    public String getcCouponId() {
        return cCouponId;
    }

    public void setcCouponId(String cCouponId) {
        this.cCouponId = cCouponId == null ? null : cCouponId.trim();
    }

    public Double getcCouponPrice() {
        return cCouponPrice;
    }

    public void setcCouponPrice(Double cCouponPrice) {
        this.cCouponPrice = cCouponPrice;
    }

    public Date getcFahuoTime() {
        return cFahuoTime;
    }

    public void setcFahuoTime(Date cFahuoTime) {
        this.cFahuoTime = cFahuoTime;
    }

    public Double getcGold() {
        return cGold;
    }

    public void setcGold(Double cGold) {
        this.cGold = cGold;
    }

    public String getcGoodsInterval() {
        return cGoodsInterval;
    }

    public void setcGoodsInterval(String cGoodsInterval) {
        this.cGoodsInterval = cGoodsInterval == null ? null : cGoodsInterval.trim();
    }

    public Integer getcGoodsSex() {
        return cGoodsSex;
    }

    public void setcGoodsSex(Integer cGoodsSex) {
        this.cGoodsSex = cGoodsSex;
    }

    public Integer getcGoodsTotal() {
        return cGoodsTotal;
    }

    public void setcGoodsTotal(Integer cGoodsTotal) {
        this.cGoodsTotal = cGoodsTotal;
    }

    public String getcGuige() {
        return cGuige;
    }

    public void setcGuige(String cGuige) {
        this.cGuige = cGuige == null ? null : cGuige.trim();
    }

    public Double getcGzFl() {
        return cGzFl;
    }

    public void setcGzFl(Double cGzFl) {
        this.cGzFl = cGzFl;
    }

    public Integer getcIfCanInvoice() {
        return cIfCanInvoice;
    }

    public void setcIfCanInvoice(Integer cIfCanInvoice) {
        this.cIfCanInvoice = cIfCanInvoice;
    }

    public Integer getcIfReply() {
        return cIfReply;
    }

    public void setcIfReply(Integer cIfReply) {
        this.cIfReply = cIfReply;
    }

    public Integer getcIfTake() {
        return cIfTake;
    }

    public void setcIfTake(Integer cIfTake) {
        this.cIfTake = cIfTake;
    }

    public Integer getcIfxianshang() {
        return cIfxianshang;
    }

    public void setcIfxianshang(Integer cIfxianshang) {
        this.cIfxianshang = cIfxianshang;
    }

    public String getcInvoiceTitle() {
        return cInvoiceTitle;
    }

    public void setcInvoiceTitle(String cInvoiceTitle) {
        this.cInvoiceTitle = cInvoiceTitle == null ? null : cInvoiceTitle.trim();
    }

    public String getcLeixing() {
        return cLeixing;
    }

    public void setcLeixing(String cLeixing) {
        this.cLeixing = cLeixing == null ? null : cLeixing.trim();
    }

    public String getcLogisticsId() {
        return cLogisticsId;
    }

    public void setcLogisticsId(String cLogisticsId) {
        this.cLogisticsId = cLogisticsId == null ? null : cLogisticsId.trim();
    }

    public Integer getcNum() {
        return cNum;
    }

    public void setcNum(Integer cNum) {
        this.cNum = cNum;
    }

    public String getcOrderNo() {
        return cOrderNo;
    }

    public void setcOrderNo(String cOrderNo) {
        this.cOrderNo = cOrderNo == null ? null : cOrderNo.trim();
    }

    public Integer getcOrderSsid() {
        return cOrderSsid;
    }

    public void setcOrderSsid(Integer cOrderSsid) {
        this.cOrderSsid = cOrderSsid;
    }

    public String getcOutTradeNo() {
        return cOutTradeNo;
    }

    public void setcOutTradeNo(String cOutTradeNo) {
        this.cOutTradeNo = cOutTradeNo == null ? null : cOutTradeNo.trim();
    }

    public String getcParamList() {
        return cParamList;
    }

    public void setcParamList(String cParamList) {
        this.cParamList = cParamList == null ? null : cParamList.trim();
    }

    public String getcPayType() {
        return cPayType;
    }

    public void setcPayType(String cPayType) {
        this.cPayType = cPayType == null ? null : cPayType.trim();
    }

    public String getcPayUser() {
        return cPayUser;
    }

    public void setcPayUser(String cPayUser) {
        this.cPayUser = cPayUser == null ? null : cPayUser.trim();
    }

    public Double getcPrice() {
        return cPrice;
    }

    public void setcPrice(Double cPrice) {
        this.cPrice = cPrice;
    }

    public String getcProductCode() {
        return cProductCode;
    }

    public void setcProductCode(String cProductCode) {
        this.cProductCode = cProductCode == null ? null : cProductCode.trim();
    }

    public String getcProductId() {
        return cProductId;
    }

    public void setcProductId(String cProductId) {
        this.cProductId = cProductId == null ? null : cProductId.trim();
    }

    public String getcProductLogo() {
        return cProductLogo;
    }

    public void setcProductLogo(String cProductLogo) {
        this.cProductLogo = cProductLogo == null ? null : cProductLogo.trim();
    }

    public String getcProductName() {
        return cProductName;
    }

    public void setcProductName(String cProductName) {
        this.cProductName = cProductName == null ? null : cProductName.trim();
    }

    public String getcRequire() {
        return cRequire;
    }

    public void setcRequire(String cRequire) {
        this.cRequire = cRequire == null ? null : cRequire.trim();
    }

    public Double getcSexPrice() {
        return cSexPrice;
    }

    public void setcSexPrice(Double cSexPrice) {
        this.cSexPrice = cSexPrice;
    }

    public String getcShopbId() {
        return cShopbId;
    }

    public void setcShopbId(String cShopbId) {
        this.cShopbId = cShopbId == null ? null : cShopbId.trim();
    }

    public String getcShopId() {
        return cShopId;
    }

    public void setcShopId(String cShopId) {
        this.cShopId = cShopId == null ? null : cShopId.trim();
    }

    public Date getcShouhuoTime() {
        return cShouhuoTime;
    }

    public void setcShouhuoTime(Date cShouhuoTime) {
        this.cShouhuoTime = cShouhuoTime;
    }

    public Integer getcState() {
        return cState;
    }

    public void setcState(Integer cState) {
        this.cState = cState;
    }

    public String getcSummary() {
        return cSummary;
    }

    public void setcSummary(String cSummary) {
        this.cSummary = cSummary == null ? null : cSummary.trim();
    }

    public String getcTihuoShopId() {
        return cTihuoShopId;
    }

    public void setcTihuoShopId(String cTihuoShopId) {
        this.cTihuoShopId = cTihuoShopId == null ? null : cTihuoShopId.trim();
    }

    public String getcTrackingComp() {
        return cTrackingComp;
    }

    public void setcTrackingComp(String cTrackingComp) {
        this.cTrackingComp = cTrackingComp == null ? null : cTrackingComp.trim();
    }

    public String getcTrackingNo() {
        return cTrackingNo;
    }

    public void setcTrackingNo(String cTrackingNo) {
        this.cTrackingNo = cTrackingNo == null ? null : cTrackingNo.trim();
    }

    public String getcTransactionId() {
        return cTransactionId;
    }

    public void setcTransactionId(String cTransactionId) {
        this.cTransactionId = cTransactionId == null ? null : cTransactionId.trim();
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public Double getcUnitPrice() {
        return cUnitPrice;
    }

    public void setcUnitPrice(Double cUnitPrice) {
        this.cUnitPrice = cUnitPrice;
    }

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }

    public Double getcYoufeiFee() {
        return cYoufeiFee;
    }

    public void setcYoufeiFee(Double cYoufeiFee) {
        this.cYoufeiFee = cYoufeiFee;
    }

    public Double getcZhPrice() {
        return cZhPrice;
    }

    public void setcZhPrice(Double cZhPrice) {
        this.cZhPrice = cZhPrice;
    }

    public Double getcZjrFl() {
        return cZjrFl;
    }

    public void setcZjrFl(Double cZjrFl) {
        this.cZjrFl = cZjrFl;
    }

    public String getcFactId() {
        return cFactId;
    }

    public void setcFactId(String cFactId) {
        this.cFactId = cFactId == null ? null : cFactId.trim();
    }

    public String getcFactName() {
        return cFactName;
    }

    public void setcFactName(String cFactName) {
        this.cFactName = cFactName == null ? null : cFactName.trim();
    }

    public String getcShopName() {
        return cShopName;
    }

    public void setcShopName(String cShopName) {
        this.cShopName = cShopName == null ? null : cShopName.trim();
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public Double getcFactMoney() {
        return cFactMoney;
    }

    public void setcFactMoney(Double cFactMoney) {
        this.cFactMoney = cFactMoney;
    }

    public Double getcPlatMoney() {
        return cPlatMoney;
    }

    public void setcPlatMoney(Double cPlatMoney) {
        this.cPlatMoney = cPlatMoney;
    }

    public Double getcShopMoney() {
        return cShopMoney;
    }

    public void setcShopMoney(Double cShopMoney) {
        this.cShopMoney = cShopMoney;
    }

    public Integer getcRefundNum() {
        return cRefundNum;
    }

    public void setcRefundNum(Integer cRefundNum) {
        this.cRefundNum = cRefundNum;
    }

    public Integer getcDispute() {
        return cDispute;
    }

    public void setcDispute(Integer cDispute) {
        this.cDispute = cDispute;
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

    public Integer getcStage() {
        return cStage;
    }

    public void setcStage(Integer cStage) {
        this.cStage = cStage;
    }

    public String getcAgentId() {
        return cAgentId;
    }

    public void setcAgentId(String cAgentId) {
        this.cAgentId = cAgentId == null ? null : cAgentId.trim();
    }

    public Double getcAgentMoney() {
        return cAgentMoney;
    }

    public void setcAgentMoney(Double cAgentMoney) {
        this.cAgentMoney = cAgentMoney;
    }

    public String getcAgentName() {
        return cAgentName;
    }

    public void setcAgentName(String cAgentName) {
        this.cAgentName = cAgentName == null ? null : cAgentName.trim();
    }

    public String getcProduct2Id() {
        return cProduct2Id;
    }

    public void setcProduct2Id(String cProduct2Id) {
        this.cProduct2Id = cProduct2Id == null ? null : cProduct2Id.trim();
    }

    public Double getcOneGold() {
        return cOneGold;
    }

    public void setcOneGold(Double cOneGold) {
        this.cOneGold = cOneGold;
    }

    public Double getcThreeGold() {
        return cThreeGold;
    }

    public void setcThreeGold(Double cThreeGold) {
        this.cThreeGold = cThreeGold;
    }

    public Double getcTwoGold() {
        return cTwoGold;
    }

    public void setcTwoGold(Double cTwoGold) {
        this.cTwoGold = cTwoGold;
    }

    public String getcTihuoShopCode() {
        return cTihuoShopCode;
    }

    public void setcTihuoShopCode(String cTihuoShopCode) {
        this.cTihuoShopCode = cTihuoShopCode == null ? null : cTihuoShopCode.trim();
    }

    public String getcTihuoShopName() {
        return cTihuoShopName;
    }

    public void setcTihuoShopName(String cTihuoShopName) {
        this.cTihuoShopName = cTihuoShopName == null ? null : cTihuoShopName.trim();
    }

    public Double getcFuwuFee() {
        return cFuwuFee;
    }

    public void setcFuwuFee(Double cFuwuFee) {
        this.cFuwuFee = cFuwuFee;
    }

    public String getcIfZiti() {
        return cIfZiti;
    }

    public void setcIfZiti(String cIfZiti) {
        this.cIfZiti = cIfZiti == null ? null : cIfZiti.trim();
    }

    public Integer getcSctype() {
        return cSctype;
    }

    public void setcSctype(Integer cSctype) {
        this.cSctype = cSctype;
    }

    public String getcFuwuFeeType() {
        return cFuwuFeeType;
    }

    public void setcFuwuFeeType(String cFuwuFeeType) {
        this.cFuwuFeeType = cFuwuFeeType == null ? null : cFuwuFeeType.trim();
    }

    public String getcUserNo() {
        return cUserNo;
    }

    public void setcUserNo(String cUserNo) {
        this.cUserNo = cUserNo == null ? null : cUserNo.trim();
    }

    public Integer getcIfPingjia() {
        return cIfPingjia;
    }

    public void setcIfPingjia(Integer cIfPingjia) {
        this.cIfPingjia = cIfPingjia;
    }

    public String getcMemberId() {
        return cMemberId;
    }

    public void setcMemberId(String cMemberId) {
        this.cMemberId = cMemberId == null ? null : cMemberId.trim();
    }

    public String getcMemberName() {
        return cMemberName;
    }

    public void setcMemberName(String cMemberName) {
        this.cMemberName = cMemberName == null ? null : cMemberName.trim();
    }

    public Integer getcMemberNo() {
        return cMemberNo;
    }

    public void setcMemberNo(Integer cMemberNo) {
        this.cMemberNo = cMemberNo;
    }

    public String getcMemberTime() {
        return cMemberTime;
    }

    public void setcMemberTime(String cMemberTime) {
        this.cMemberTime = cMemberTime == null ? null : cMemberTime.trim();
    }

    public String getcPingjiaMemo() {
        return cPingjiaMemo;
    }

    public void setcPingjiaMemo(String cPingjiaMemo) {
        this.cPingjiaMemo = cPingjiaMemo == null ? null : cPingjiaMemo.trim();
    }

    public Integer getcPingjiaStar() {
        return cPingjiaStar;
    }

    public void setcPingjiaStar(Integer cPingjiaStar) {
        this.cPingjiaStar = cPingjiaStar;
    }

    public String getcXsnum() {
        return cXsnum;
    }

    public void setcXsnum(String cXsnum) {
        this.cXsnum = cXsnum == null ? null : cXsnum.trim();
    }

    public String getcZkbl() {
        return cZkbl;
    }

    public void setcZkbl(String cZkbl) {
        this.cZkbl = cZkbl == null ? null : cZkbl.trim();
    }

    public Double getcMtlGold() {
        return cMtlGold;
    }

    public void setcMtlGold(Double cMtlGold) {
        this.cMtlGold = cMtlGold;
    }

    public Integer getcCategory() {
        return cCategory;
    }

    public void setcCategory(Integer cCategory) {
        this.cCategory = cCategory;
    }

    public String getcCouponComment() {
        return cCouponComment;
    }

    public void setcCouponComment(String cCouponComment) {
        this.cCouponComment = cCouponComment == null ? null : cCouponComment.trim();
    }

    public String getcGroupNum() {
        return cGroupNum;
    }

    public void setcGroupNum(String cGroupNum) {
        this.cGroupNum = cGroupNum == null ? null : cGroupNum.trim();
    }

    public Double getcMoneyPay() {
        return cMoneyPay;
    }

    public void setcMoneyPay(Double cMoneyPay) {
        this.cMoneyPay = cMoneyPay;
    }

    public Date getcPayTime() {
        return cPayTime;
    }

    public void setcPayTime(Date cPayTime) {
        this.cPayTime = cPayTime;
    }

    public Date getcPlanPayTime() {
        return cPlanPayTime;
    }

    public void setcPlanPayTime(Date cPlanPayTime) {
        this.cPlanPayTime = cPlanPayTime;
    }

    public String getcPlatformComment() {
        return cPlatformComment;
    }

    public void setcPlatformComment(String cPlatformComment) {
        this.cPlatformComment = cPlatformComment == null ? null : cPlatformComment.trim();
    }

    public Double getcPlatformPrice() {
        return cPlatformPrice;
    }

    public void setcPlatformPrice(Double cPlatformPrice) {
        this.cPlatformPrice = cPlatformPrice;
    }

    public Double getcTransportPrice() {
        return cTransportPrice;
    }

    public void setcTransportPrice(Double cTransportPrice) {
        this.cTransportPrice = cTransportPrice;
    }

    public String getcTransportationRequirement() {
        return cTransportationRequirement;
    }

    public void setcTransportationRequirement(String cTransportationRequirement) {
        this.cTransportationRequirement = cTransportationRequirement == null ? null : cTransportationRequirement.trim();
    }

    public String getcWhiteNoteComment() {
        return cWhiteNoteComment;
    }

    public void setcWhiteNoteComment(String cWhiteNoteComment) {
        this.cWhiteNoteComment = cWhiteNoteComment == null ? null : cWhiteNoteComment.trim();
    }

    public Double getcWhiteNotePrice() {
        return cWhiteNotePrice;
    }

    public void setcWhiteNotePrice(Double cWhiteNotePrice) {
        this.cWhiteNotePrice = cWhiteNotePrice;
    }

    public List<OrderDetail> getDetailList() {
        return detailList;
    }

    public void setDetailList(List<OrderDetail> detailList) {
        this.detailList = detailList;
    }
}