package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * @Description 用户表
 * @Author dongxiangwei
 * @Date 12:14 2020/12.21
 **/

@ApiModel(value = "用户", description = "")
public class User {
    @ApiModelProperty("用户ID")
    private String cId;     // 用户id

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cCreateTime;   // 创建时间

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cLastUpdateTime;   // 上次修改时间

    private String cBirthday;   // 生日

    private String cEmail;      // email

    private String cIdCardNo;   // 身份证号

    private Integer cLevel;     // 用户级别

    private String cPassword;   // 用户密码

    private String cPhone;      // 用户电话 (登录账号)

    private String cRealname;   // 真实姓名 与身份证号绑定

    private String cSex;        // 性别

    private String cSummary;    //  个人简介

    private String cUsername;   // 昵称

    private String cAddressId;  // 详细地址

    private String cProvince;   // 省份

    private String cCity;       // 城市

    private String cCountry;    // 国家

    private String cCityId;     // 城市编号

    private String cDistrictId;     // 县区编号

    private String cProvinceId;     // 省份编号

    private String cDistrict;       // 县区名称

    private Integer cIfShop;    // 是否审核成为企业 0= 未审核 1=审核中 2=审核成功 3=审核失败

    private String cAgentName;      // 企业法人姓名

    private String cShopName;       // 企业名称

    private Double cUb;             // 茅台ml 数

    private Double cGold;           // 五粮液 ml数

    private String cNowCityId;      // 税号

    private String cNowCityName;    //  开户行

    private String cVipCardno;      // 账号

    private String cFactId;         // 执照号

    private String cFactName;        // 营业执照(照片)

    private Integer cGoldGz;    // 钢豆数量

    private String cVer;        // 企业电话

    private String cLogo;       // 头像

    private Double cTotalPay;       // 白条已使用额度

    private Double cTotalSale;      // 白条未使用额度

    private String cHide;

    private Double cTotalAverage;   // 白条总额度

    private Integer cScore;     // 首页红包是否展示  0=展示 1=不展示   // 此参数不可做其他用处 数据库类别与后端实体类 参数类别不对应 应该是有人做过修改

    private Double cMoney;

    private String cMyRecommendCode;

    private String cMyRecommendUserId;

    private String cNickname;

    private Integer cIfHaveShop;

    private String cHandpic;

    private String cMemberNo;

    private String cShopId;

    private String cWorkNo;

    private Integer cMemberState;

    private String cLanguage;

    private String cOpenid;

    private String cSubscribeTime;

    private Integer cUserNo;

    private Integer cNeedMessage;

    private String cCreateUser;

    private String cLastUpdateUser;

    private Integer cAdsNum;

    private Integer cTempGold;


    private String cVipPassword;

    private Integer cIfVip;

    private String cPayPassword;

    private Integer cIfAgent;

    private Integer cIfFact;

    private String cBlockId;

    private String cBlock;

    private String cInitShopId;

    private String cAgentId;

    private String cGongzhangId;

    private String cZhongjianrenId;

    private String cQrcodeUrl;

    private String cGongzhangName;

    private String cZhongjianrenName;

    private String cXy;

    private Integer cTotalOrder;

    private Integer cIfOpen;

    private String cGeoCode;

    private Integer cFold;

    private String cChlType;

    private String cDeviceId;

    private String cPdf;

    private Integer cRollNum;

    private Integer cStar;

    private Double cRollPay;

    private Integer cGoldRoll;

    private Integer cHaoyouNum;

    private String cIfApp;

    private String cMyRecommendUserNo;

    private Integer cFuwucishu;

    private String cJingyan;

    private Integer cPf1;

    private Integer cPf2;

    private Integer cPf3;

    private Integer cXingji;

    private String cZhicheng;



    public User(String cId, Date cCreateTime, Date cLastUpdateTime, String cBirthday, String cEmail, String cHandpic, String cIdCardNo, Integer cIfHaveShop, Integer cLevel, Double cMoney, String cMyRecommendCode, String cMyRecommendUserId, String cNickname, String cPassword, String cPhone, String cRealname, Integer cScore, String cSex, String cSummary, String cUsername, String cAddressId, Double cGold, String cMemberNo, String cShopId, String cWorkNo, Integer cMemberState, String cProvince, String cCity, String cCountry, String cLanguage, String cOpenid, String cSubscribeTime, Integer cUserNo, Integer cNeedMessage, String cCreateUser, String cLastUpdateUser, String cCityId, String cDistrictId, String cProvinceId, Integer cAdsNum, String cDistrict, Integer cTempGold, String cVipCardno, String cVipPassword, Integer cIfVip, String cPayPassword, Integer cIfAgent, Integer cIfFact, Integer cIfShop, String cBlockId, String cBlock, String cInitShopId, String cAgentId, String cGongzhangId, String cZhongjianrenId, String cQrcodeUrl, String cAgentName, String cGongzhangName, String cShopName, String cZhongjianrenName, String cXy, Double cTotalPay, Double cUb, Double cTotalSale, String cHide, String cNowCityId, String cNowCityName, Double cTotalAverage, Integer cTotalOrder, String cFactId, String cFactName, Integer cIfOpen, String cGeoCode, Integer cFold, String cChlType, String cDeviceId, Integer cGoldGz, String cPdf, Integer cRollNum, Integer cStar, Double cRollPay, Integer cGoldRoll, Integer cHaoyouNum, String cIfApp, String cVer, String cMyRecommendUserNo, Integer cFuwucishu, String cJingyan, Integer cPf1, Integer cPf2, Integer cPf3, Integer cXingji, String cZhicheng, String cLogo) {
        this.cId = cId;
        this.cCreateTime = cCreateTime;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cBirthday = cBirthday;
        this.cEmail = cEmail;
        this.cHandpic = cHandpic;
        this.cIdCardNo = cIdCardNo;
        this.cIfHaveShop = cIfHaveShop;
        this.cLevel = cLevel;
        this.cMoney = cMoney;
        this.cMyRecommendCode = cMyRecommendCode;
        this.cMyRecommendUserId = cMyRecommendUserId;
        this.cNickname = cNickname;
        this.cPassword = cPassword;
        this.cPhone = cPhone;
        this.cRealname = cRealname;
        this.cScore = cScore;
        this.cSex = cSex;
        this.cSummary = cSummary;
        this.cUsername = cUsername;
        this.cAddressId = cAddressId;
        this.cGold = cGold;
        this.cMemberNo = cMemberNo;
        this.cShopId = cShopId;
        this.cWorkNo = cWorkNo;
        this.cMemberState = cMemberState;
        this.cProvince = cProvince;
        this.cCity = cCity;
        this.cCountry = cCountry;
        this.cLanguage = cLanguage;
        this.cOpenid = cOpenid;
        this.cSubscribeTime = cSubscribeTime;
        this.cUserNo = cUserNo;
        this.cNeedMessage = cNeedMessage;
        this.cCreateUser = cCreateUser;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cCityId = cCityId;
        this.cDistrictId = cDistrictId;
        this.cProvinceId = cProvinceId;
        this.cAdsNum = cAdsNum;
        this.cDistrict = cDistrict;
        this.cTempGold = cTempGold;
        this.cVipCardno = cVipCardno;
        this.cVipPassword = cVipPassword;
        this.cIfVip = cIfVip;
        this.cPayPassword = cPayPassword;
        this.cIfAgent = cIfAgent;
        this.cIfFact = cIfFact;
        this.cIfShop = cIfShop;
        this.cBlockId = cBlockId;
        this.cBlock = cBlock;
        this.cInitShopId = cInitShopId;
        this.cAgentId = cAgentId;
        this.cGongzhangId = cGongzhangId;
        this.cZhongjianrenId = cZhongjianrenId;
        this.cQrcodeUrl = cQrcodeUrl;
        this.cAgentName = cAgentName;
        this.cGongzhangName = cGongzhangName;
        this.cShopName = cShopName;
        this.cZhongjianrenName = cZhongjianrenName;
        this.cXy = cXy;
        this.cTotalPay = cTotalPay;
        this.cUb = cUb;
        this.cTotalSale = cTotalSale;
        this.cHide = cHide;
        this.cNowCityId = cNowCityId;
        this.cNowCityName = cNowCityName;
        this.cTotalAverage = cTotalAverage;
        this.cTotalOrder = cTotalOrder;
        this.cFactId = cFactId;
        this.cFactName = cFactName;
        this.cIfOpen = cIfOpen;
        this.cGeoCode = cGeoCode;
        this.cFold = cFold;
        this.cChlType = cChlType;
        this.cDeviceId = cDeviceId;
        this.cGoldGz = cGoldGz;
        this.cPdf = cPdf;
        this.cRollNum = cRollNum;
        this.cStar = cStar;
        this.cRollPay = cRollPay;
        this.cGoldRoll = cGoldRoll;
        this.cHaoyouNum = cHaoyouNum;
        this.cIfApp = cIfApp;
        this.cVer = cVer;
        this.cMyRecommendUserNo = cMyRecommendUserNo;
        this.cFuwucishu = cFuwucishu;
        this.cJingyan = cJingyan;
        this.cPf1 = cPf1;
        this.cPf2 = cPf2;
        this.cPf3 = cPf3;
        this.cXingji = cXingji;
        this.cZhicheng = cZhicheng;
        this.cLogo = cLogo;
    }

    public User() {
    }

    public User(String cId, Double cUb) {
        this.cId = cId;
        this.cUb = cUb;
    }

    public User(Double cGold, String cId) {
        this.cId = cId;
        this.cGold = cGold;
    }

    public User(String cId, Integer cGoldGz) {
        this.cId = cId;
        this.cGoldGz = cGoldGz;
    }

    public User(String cId, String cPhone, String cPassword, String cCreateUser, Date cCreateTime) {
        this.cId = cId;
        this.cPhone = cPhone;  
        this.cPassword = cPassword;
        this.cCreateUser = cCreateUser;
        this.cCreateTime = cCreateTime;
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

    public String getcBirthday() {
        return cBirthday;
    }

    public void setcBirthday(String cBirthday) {
        this.cBirthday = cBirthday == null ? null : cBirthday.trim();
    }

    public String getcEmail() {
        return cEmail;
    }

    public void setcEmail(String cEmail) {
        this.cEmail = cEmail == null ? null : cEmail.trim();
    }

    public String getcHandpic() {
        return cHandpic;
    }

    public void setcHandpic(String cHandpic) {
        this.cHandpic = cHandpic == null ? null : cHandpic.trim();
    }

    public String getcIdCardNo() {
        return cIdCardNo;
    }

    public void setcIdCardNo(String cIdCardNo) {
        this.cIdCardNo = cIdCardNo == null ? null : cIdCardNo.trim();
    }

    public Integer getcIfHaveShop() {
        return cIfHaveShop;
    }

    public void setcIfHaveShop(Integer cIfHaveShop) {
        this.cIfHaveShop = cIfHaveShop;
    }

    public Integer getcLevel() {
        return cLevel;
    }

    public void setcLevel(Integer cLevel) {
        this.cLevel = cLevel;
    }

    public Double getcMoney() {
        return cMoney;
    }

    public void setcMoney(Double cMoney) {
        this.cMoney = cMoney;
    }

    public String getcMyRecommendCode() {
        return cMyRecommendCode;
    }

    public void setcMyRecommendCode(String cMyRecommendCode) {
        this.cMyRecommendCode = cMyRecommendCode == null ? null : cMyRecommendCode.trim();
    }

    public String getcMyRecommendUserId() {
        return cMyRecommendUserId;
    }

    public void setcMyRecommendUserId(String cMyRecommendUserId) {
        this.cMyRecommendUserId = cMyRecommendUserId == null ? null : cMyRecommendUserId.trim();
    }

    public String getcNickname() {
        return cNickname;
    }

    public void setcNickname(String cNickname) {
        this.cNickname = cNickname == null ? null : cNickname.trim();
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
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

    public Integer getcScore() {
        return cScore;
    }

    public void setcScore(Integer cScore) {
        this.cScore = cScore;
    }

    public String getcSex() {
        return cSex;
    }

    public void setcSex(String cSex) {
        this.cSex = cSex == null ? null : cSex.trim();
    }

    public String getcSummary() {
        return cSummary;
    }

    public void setcSummary(String cSummary) {
        this.cSummary = cSummary == null ? null : cSummary.trim();
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername == null ? null : cUsername.trim();
    }

    public String getcAddressId() {
        return cAddressId;
    }

    public void setcAddressId(String cAddressId) {
        this.cAddressId = cAddressId == null ? null : cAddressId.trim();
    }

    public Double getcGold() {
        return cGold;
    }

    public void setcGold(Double cGold) {
        this.cGold = cGold;
    }

    public String getcMemberNo() {
        return cMemberNo;
    }

    public void setcMemberNo(String cMemberNo) {
        this.cMemberNo = cMemberNo == null ? null : cMemberNo.trim();
    }

    public String getcShopId() {
        return cShopId;
    }

    public void setcShopId(String cShopId) {
        this.cShopId = cShopId == null ? null : cShopId.trim();
    }

    public String getcWorkNo() {
        return cWorkNo;
    }

    public void setcWorkNo(String cWorkNo) {
        this.cWorkNo = cWorkNo == null ? null : cWorkNo.trim();
    }

    public Integer getcMemberState() {
        return cMemberState;
    }

    public void setcMemberState(Integer cMemberState) {
        this.cMemberState = cMemberState;
    }

    public String getcProvince() {
        return cProvince;
    }

    public void setcProvince(String cProvince) {
        this.cProvince = cProvince == null ? null : cProvince.trim();
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity == null ? null : cCity.trim();
    }

    public String getcCountry() {
        return cCountry;
    }

    public void setcCountry(String cCountry) {
        this.cCountry = cCountry == null ? null : cCountry.trim();
    }

    public String getcLanguage() {
        return cLanguage;
    }

    public void setcLanguage(String cLanguage) {
        this.cLanguage = cLanguage == null ? null : cLanguage.trim();
    }

    public String getcOpenid() {
        return cOpenid;
    }

    public void setcOpenid(String cOpenid) {
        this.cOpenid = cOpenid == null ? null : cOpenid.trim();
    }

    public String getcSubscribeTime() {
        return cSubscribeTime;
    }

    public void setcSubscribeTime(String cSubscribeTime) {
        this.cSubscribeTime = cSubscribeTime == null ? null : cSubscribeTime.trim();
    }

    public Integer getcUserNo() {
        return cUserNo;
    }

    public void setcUserNo(Integer cUserNo) {
        this.cUserNo = cUserNo;
    }

    public Integer getcNeedMessage() {
        return cNeedMessage;
    }

    public void setcNeedMessage(Integer cNeedMessage) {
        this.cNeedMessage = cNeedMessage;
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

    public String getcDistrictId() {
        return cDistrictId;
    }

    public void setcDistrictId(String cDistrictId) {
        this.cDistrictId = cDistrictId == null ? null : cDistrictId.trim();
    }

    public String getcProvinceId() {
        return cProvinceId;
    }

    public void setcProvinceId(String cProvinceId) {
        this.cProvinceId = cProvinceId == null ? null : cProvinceId.trim();
    }

    public Integer getcAdsNum() {
        return cAdsNum;
    }

    public void setcAdsNum(Integer cAdsNum) {
        this.cAdsNum = cAdsNum;
    }

    public String getcDistrict() {
        return cDistrict;
    }

    public void setcDistrict(String cDistrict) {
        this.cDistrict = cDistrict == null ? null : cDistrict.trim();
    }

    public Integer getcTempGold() {
        return cTempGold;
    }

    public void setcTempGold(Integer cTempGold) {
        this.cTempGold = cTempGold;
    }

    public String getcVipCardno() {
        return cVipCardno;
    }

    public void setcVipCardno(String cVipCardno) {
        this.cVipCardno = cVipCardno == null ? null : cVipCardno.trim();
    }

    public String getcVipPassword() {
        return cVipPassword;
    }

    public void setcVipPassword(String cVipPassword) {
        this.cVipPassword = cVipPassword == null ? null : cVipPassword.trim();
    }

    public Integer getcIfVip() {
        return cIfVip;
    }

    public void setcIfVip(Integer cIfVip) {
        this.cIfVip = cIfVip;
    }

    public String getcPayPassword() {
        return cPayPassword;
    }

    public void setcPayPassword(String cPayPassword) {
        this.cPayPassword = cPayPassword == null ? null : cPayPassword.trim();
    }

    public Integer getcIfAgent() {
        return cIfAgent;
    }

    public void setcIfAgent(Integer cIfAgent) {
        this.cIfAgent = cIfAgent;
    }

    public Integer getcIfFact() {
        return cIfFact;
    }

    public void setcIfFact(Integer cIfFact) {
        this.cIfFact = cIfFact;
    }

    public Integer getcIfShop() {
        return cIfShop;
    }

    public void setcIfShop(Integer cIfShop) {
        this.cIfShop = cIfShop;
    }

    public String getcBlockId() {
        return cBlockId;
    }

    public void setcBlockId(String cBlockId) {
        this.cBlockId = cBlockId == null ? null : cBlockId.trim();
    }

    public String getcBlock() {
        return cBlock;
    }

    public void setcBlock(String cBlock) {
        this.cBlock = cBlock == null ? null : cBlock.trim();
    }

    public String getcInitShopId() {
        return cInitShopId;
    }

    public void setcInitShopId(String cInitShopId) {
        this.cInitShopId = cInitShopId == null ? null : cInitShopId.trim();
    }

    public String getcAgentId() {
        return cAgentId;
    }

    public void setcAgentId(String cAgentId) {
        this.cAgentId = cAgentId == null ? null : cAgentId.trim();
    }

    public String getcGongzhangId() {
        return cGongzhangId;
    }

    public void setcGongzhangId(String cGongzhangId) {
        this.cGongzhangId = cGongzhangId == null ? null : cGongzhangId.trim();
    }

    public String getcZhongjianrenId() {
        return cZhongjianrenId;
    }

    public void setcZhongjianrenId(String cZhongjianrenId) {
        this.cZhongjianrenId = cZhongjianrenId == null ? null : cZhongjianrenId.trim();
    }

    public String getcQrcodeUrl() {
        return cQrcodeUrl;
    }

    public void setcQrcodeUrl(String cQrcodeUrl) {
        this.cQrcodeUrl = cQrcodeUrl == null ? null : cQrcodeUrl.trim();
    }

    public String getcAgentName() {
        return cAgentName;
    }

    public void setcAgentName(String cAgentName) {
        this.cAgentName = cAgentName == null ? null : cAgentName.trim();
    }

    public String getcGongzhangName() {
        return cGongzhangName;
    }

    public void setcGongzhangName(String cGongzhangName) {
        this.cGongzhangName = cGongzhangName == null ? null : cGongzhangName.trim();
    }

    public String getcShopName() {
        return cShopName;
    }

    public void setcShopName(String cShopName) {
        this.cShopName = cShopName == null ? null : cShopName.trim();
    }

    public String getcZhongjianrenName() {
        return cZhongjianrenName;
    }

    public void setcZhongjianrenName(String cZhongjianrenName) {
        this.cZhongjianrenName = cZhongjianrenName == null ? null : cZhongjianrenName.trim();
    }

    public String getcXy() {
        return cXy;
    }

    public void setcXy(String cXy) {
        this.cXy = cXy == null ? null : cXy.trim();
    }

    public Double getcTotalPay() {
        return cTotalPay;
    }

    public void setcTotalPay(Double cTotalPay) {
        this.cTotalPay = cTotalPay;
    }

    public Double getcUb() {
        return cUb;
    }

    public void setcUb(Double cUb) {
        this.cUb = cUb;
    }

    public Double getcTotalSale() {
        return cTotalSale;
    }

    public void setcTotalSale(Double cTotalSale) {
        this.cTotalSale = cTotalSale;
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public String getcNowCityId() {
        return cNowCityId;
    }

    public void setcNowCityId(String cNowCityId) {
        this.cNowCityId = cNowCityId == null ? null : cNowCityId.trim();
    }

    public String getcNowCityName() {
        return cNowCityName;
    }

    public void setcNowCityName(String cNowCityName) {
        this.cNowCityName = cNowCityName == null ? null : cNowCityName.trim();
    }

    public Double getcTotalAverage() {
        return cTotalAverage;
    }

    public void setcTotalAverage(Double cTotalAverage) {
        this.cTotalAverage = cTotalAverage;
    }

    public Integer getcTotalOrder() {
        return cTotalOrder;
    }

    public void setcTotalOrder(Integer cTotalOrder) {
        this.cTotalOrder = cTotalOrder;
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

    public Integer getcIfOpen() {
        return cIfOpen;
    }

    public void setcIfOpen(Integer cIfOpen) {
        this.cIfOpen = cIfOpen;
    }

    public String getcGeoCode() {
        return cGeoCode;
    }

    public void setcGeoCode(String cGeoCode) {
        this.cGeoCode = cGeoCode == null ? null : cGeoCode.trim();
    }

    public Integer getcFold() {
        return cFold;
    }

    public void setcFold(Integer cFold) {
        this.cFold = cFold;
    }

    public String getcChlType() {
        return cChlType;
    }

    public void setcChlType(String cChlType) {
        this.cChlType = cChlType == null ? null : cChlType.trim();
    }

    public String getcDeviceId() {
        return cDeviceId;
    }

    public void setcDeviceId(String cDeviceId) {
        this.cDeviceId = cDeviceId == null ? null : cDeviceId.trim();
    }

    public Integer getcGoldGz() {
        return cGoldGz;
    }

    public void setcGoldGz(Integer cGoldGz) {
        this.cGoldGz = cGoldGz;
    }

    public String getcPdf() {
        return cPdf;
    }

    public void setcPdf(String cPdf) {
        this.cPdf = cPdf == null ? null : cPdf.trim();
    }

    public Integer getcRollNum() {
        return cRollNum;
    }

    public void setcRollNum(Integer cRollNum) {
        this.cRollNum = cRollNum;
    }

    public Integer getcStar() {
        return cStar;
    }

    public void setcStar(Integer cStar) {
        this.cStar = cStar;
    }

    public Double getcRollPay() {
        return cRollPay;
    }

    public void setcRollPay(Double cRollPay) {
        this.cRollPay = cRollPay;
    }

    public Integer getcGoldRoll() {
        return cGoldRoll;
    }

    public void setcGoldRoll(Integer cGoldRoll) {
        this.cGoldRoll = cGoldRoll;
    }

    public Integer getcHaoyouNum() {
        return cHaoyouNum;
    }

    public void setcHaoyouNum(Integer cHaoyouNum) {
        this.cHaoyouNum = cHaoyouNum;
    }

    public String getcIfApp() {
        return cIfApp;
    }

    public void setcIfApp(String cIfApp) {
        this.cIfApp = cIfApp == null ? null : cIfApp.trim();
    }

    public String getcVer() {
        return cVer;
    }

    public void setcVer(String cVer) {
        this.cVer = cVer == null ? null : cVer.trim();
    }

    public String getcMyRecommendUserNo() {
        return cMyRecommendUserNo;
    }

    public void setcMyRecommendUserNo(String cMyRecommendUserNo) {
        this.cMyRecommendUserNo = cMyRecommendUserNo == null ? null : cMyRecommendUserNo.trim();
    }

    public Integer getcFuwucishu() {
        return cFuwucishu;
    }

    public void setcFuwucishu(Integer cFuwucishu) {
        this.cFuwucishu = cFuwucishu;
    }

    public String getcJingyan() {
        return cJingyan;
    }

    public void setcJingyan(String cJingyan) {
        this.cJingyan = cJingyan == null ? null : cJingyan.trim();
    }

    public Integer getcPf1() {
        return cPf1;
    }

    public void setcPf1(Integer cPf1) {
        this.cPf1 = cPf1;
    }

    public Integer getcPf2() {
        return cPf2;
    }

    public void setcPf2(Integer cPf2) {
        this.cPf2 = cPf2;
    }

    public Integer getcPf3() {
        return cPf3;
    }

    public void setcPf3(Integer cPf3) {
        this.cPf3 = cPf3;
    }

    public Integer getcXingji() {
        return cXingji;
    }

    public void setcXingji(Integer cXingji) {
        this.cXingji = cXingji;
    }

    public String getcZhicheng() {
        return cZhicheng;
    }

    public void setcZhicheng(String cZhicheng) {
        this.cZhicheng = cZhicheng == null ? null : cZhicheng.trim();
    }

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo == null ? null : cLogo.trim();
    }

    @Override
    public String toString() {
        return "User{" +
                "cId='" + cId + '\'' +
                ", cCreateTime=" + cCreateTime +
                ", cLastUpdateTime=" + cLastUpdateTime +
                ", cBirthday='" + cBirthday + '\'' +
                ", cEmail='" + cEmail + '\'' +
                ", cHandpic='" + cHandpic + '\'' +
                ", cIdCardNo='" + cIdCardNo + '\'' +
                ", cIfHaveShop=" + cIfHaveShop +
                ", cLevel=" + cLevel +
                ", cMoney=" + cMoney +
                ", cMyRecommendCode='" + cMyRecommendCode + '\'' +
                ", cMyRecommendUserId='" + cMyRecommendUserId + '\'' +
                ", cNickname='" + cNickname + '\'' +
                ", cPassword='" + cPassword + '\'' +
                ", cPhone='" + cPhone + '\'' +
                ", cRealname='" + cRealname + '\'' +
                ", cScore=" + cScore +
                ", cSex='" + cSex + '\'' +
                ", cSummary='" + cSummary + '\'' +
                ", cUsername='" + cUsername + '\'' +
                ", cAddressId='" + cAddressId + '\'' +
                ", cGold=" + cGold +
                ", cMemberNo='" + cMemberNo + '\'' +
                ", cShopId='" + cShopId + '\'' +
                ", cWorkNo='" + cWorkNo + '\'' +
                ", cMemberState=" + cMemberState +
                ", cProvince='" + cProvince + '\'' +
                ", cCity='" + cCity + '\'' +
                ", cCountry='" + cCountry + '\'' +
                ", cLanguage='" + cLanguage + '\'' +
                ", cOpenid='" + cOpenid + '\'' +
                ", cSubscribeTime='" + cSubscribeTime + '\'' +
                ", cUserNo=" + cUserNo +
                ", cNeedMessage=" + cNeedMessage +
                ", cCreateUser='" + cCreateUser + '\'' +
                ", cLastUpdateUser='" + cLastUpdateUser + '\'' +
                ", cCityId='" + cCityId + '\'' +
                ", cDistrictId='" + cDistrictId + '\'' +
                ", cProvinceId='" + cProvinceId + '\'' +
                ", cAdsNum=" + cAdsNum +
                ", cDistrict='" + cDistrict + '\'' +
                ", cTempGold=" + cTempGold +
                ", cVipCardno='" + cVipCardno + '\'' +
                ", cVipPassword='" + cVipPassword + '\'' +
                ", cIfVip=" + cIfVip +
                ", cPayPassword='" + cPayPassword + '\'' +
                ", cIfAgent=" + cIfAgent +
                ", cIfFact=" + cIfFact +
                ", cIfShop=" + cIfShop +
                ", cBlockId='" + cBlockId + '\'' +
                ", cBlock='" + cBlock + '\'' +
                ", cInitShopId='" + cInitShopId + '\'' +
                ", cAgentId='" + cAgentId + '\'' +
                ", cGongzhangId='" + cGongzhangId + '\'' +
                ", cZhongjianrenId='" + cZhongjianrenId + '\'' +
                ", cQrcodeUrl='" + cQrcodeUrl + '\'' +
                ", cAgentName='" + cAgentName + '\'' +
                ", cGongzhangName='" + cGongzhangName + '\'' +
                ", cShopName='" + cShopName + '\'' +
                ", cZhongjianrenName='" + cZhongjianrenName + '\'' +
                ", cXy='" + cXy + '\'' +
                ", cTotalPay=" + cTotalPay +
                ", cUb=" + cUb +
                ", cTotalSale=" + cTotalSale +
                ", cHide='" + cHide + '\'' +
                ", cNowCityId='" + cNowCityId + '\'' +
                ", cNowCityName='" + cNowCityName + '\'' +
                ", cTotalAverage=" + cTotalAverage +
                ", cTotalOrder=" + cTotalOrder +
                ", cFactId='" + cFactId + '\'' +
                ", cFactName='" + cFactName + '\'' +
                ", cIfOpen=" + cIfOpen +
                ", cGeoCode='" + cGeoCode + '\'' +
                ", cFold=" + cFold +
                ", cChlType='" + cChlType + '\'' +
                ", cDeviceId='" + cDeviceId + '\'' +
                ", cGoldGz=" + cGoldGz +
                ", cPdf='" + cPdf + '\'' +
                ", cRollNum=" + cRollNum +
                ", cStar=" + cStar +
                ", cRollPay=" + cRollPay +
                ", cGoldRoll=" + cGoldRoll +
                ", cHaoyouNum=" + cHaoyouNum +
                ", cIfApp='" + cIfApp + '\'' +
                ", cVer='" + cVer + '\'' +
                ", cMyRecommendUserNo='" + cMyRecommendUserNo + '\'' +
                ", cFuwucishu=" + cFuwucishu +
                ", cJingyan='" + cJingyan + '\'' +
                ", cPf1=" + cPf1 +
                ", cPf2=" + cPf2 +
                ", cPf3=" + cPf3 +
                ", cXingji=" + cXingji +
                ", cZhicheng='" + cZhicheng + '\'' +
                ", cLogo='" + cLogo + '\'' +
                '}';
    }
}