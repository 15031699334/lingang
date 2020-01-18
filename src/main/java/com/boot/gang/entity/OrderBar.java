package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderBar {
    private String cId;         // 订单id\

    private String cBlockId;        //

    private String cCityId;         //收货地址 城市

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cCreateTime;       // 创建时间

    private String cCreateUser;

    private String cDistrictId;     // 收货城市 县区

    private String cProvinceId;     // 收货城市 省份

    private String cAddress;        // 收货详细地址

    private String cHide;

    private Date cLastUpdateTime;

    private String cLastUpdateUser;

    private Integer cCategory;      // 类别       1.茅台酒兑换 2.五粮液兑换

    private String cPhone;          // 收货人电话

    private String cProductName;      // 货物名称

    private String cRealname;       // 收货人姓名

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cReceiveTime;      // 收货时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cSendTime;         // 发货时间

    private String cShopId;         // 分配商户id

    private String cShopName;       // 分配钢厂的名称

    private Integer cState;         // 订单状态 0=订单取消 1=审核中 2=待发货 3=已发货 4=完成

    private String cSummary;        // 备注

    private String cTrackingComp;       // 快递公司

    private String cTrackingNo;         // 单号

    private String cUserId;         // 下单人id


    public OrderBar(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, String cHide, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, Integer cCategory, String cPhone, String cProductName, String cRealname, Date cReceiveTime, Date cSendTime, String cShopId, String cShopName, Integer cState, String cSummary, String cTrackingComp, String cTrackingNo, String cUserId, String cAddress) {
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
        this.cCategory = cCategory;
        this.cPhone = cPhone;
        this.cProductName = cProductName;
        this.cRealname = cRealname;
        this.cReceiveTime = cReceiveTime;
        this.cSendTime = cSendTime;
        this.cShopId = cShopId;
        this.cShopName = cShopName;
        this.cState = cState;
        this.cSummary = cSummary;
        this.cTrackingComp = cTrackingComp;
        this.cTrackingNo = cTrackingNo;
        this.cUserId = cUserId;
        this.cAddress = cAddress;
    }

    public OrderBar() {
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

    public Integer getcCategory() {
        return cCategory;
    }

    public void setcCategory(Integer cCategory) {
        this.cCategory = cCategory;
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcProductName() {
        return cProductName;
    }

    public void setcProductName(String cProductName) {
        this.cProductName = cProductName == null ? null : cProductName.trim();
    }

    public String getcRealname() {
        return cRealname;
    }

    public void setcRealname(String cRealname) {
        this.cRealname = cRealname == null ? null : cRealname.trim();
    }

    public Date getcReceiveTime() {
        return cReceiveTime;
    }

    public void setcReceiveTime(Date cReceiveTime) {
        this.cReceiveTime = cReceiveTime;
    }

    public Date getcSendTime() {
        return cSendTime;
    }

    public void setcSendTime(Date cSendTime) {
        this.cSendTime = cSendTime;
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

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
    }

    public String getcAddress() {
        return cAddress;
    }

    public void setcAddress(String cAddress) {
        this.cAddress = cAddress == null ? null : cAddress.trim();
    }
}