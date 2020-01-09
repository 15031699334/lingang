package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Shop {
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

    private String cAddressId;

    private String cB22o;

    private String cBusinessLicenseImg;

    private String cBusinessLicenseNo;

    private String cCity;

    private String cContactEmail;

    private String cContactNumber;

    private String cContactPhone;

    private String cDistrict;

    private Double double1;

    private Double cGold;

    private Double cGold2;

    private Double cGold3;

    private Double cGold4;

    private String cIdCardImgBack;

    private String cIdCardImgFront;

    private Integer cIfHot;

    private Integer cIfNew;

    private Integer cIfOpen;

    private Integer cIfPrivate;

    private Integer cIfRecommend;

    private String cLegalPersonName;

    private Integer cLevel;

    private String cLogo;

    private String cMyRecommendUserId;

    private String cProvince;

    private Double cR1;

    private Double cR2;

    private Double cR3;

    private Double cR4;

    private Double cR5;

    private Double cR6;

    private Double cR7;

    private Double cR8;

    private String cShopColumnId;

    private String cShopName;

    private Integer cSort;

    private Integer cState;

    private String cSummary;

    private String cTaxImg;

    private Integer cUserno;

    private String cXy;

    private String cFactId;

    private String cShopChl;

    private String cAgentId;

    private String cPrefectureidList;

    private Integer cIfShiti;

    private String cHide;

    private Double cPostageLimit;

    private Double cPostagePrice;

    private Double cTotalJinhuoAverage;

    private Double cTotalJinhuoMoney;

    private Integer cTotalJinhuoNum;

    private Double cTotalSaleAverage;

    private Double cTotalSaleMoney;

    private Integer cTotalSaleNum;

    private String cAgentName;

    private String cFactName;

    private Integer cExhibitNum;

    private Integer cInviteNum;

    private String cCreateUserId;

    private String cCharge;

    private Integer cTjOrdernum;

    private Integer cTjOrdernumMonth;

    private String cGeoCode;

    private String cScene;

    private String cSceneId;

    private String cPassword;

    private String cUsername;

    private Integer cIfFact;

    private String cBrandidList;

    private String cSceneidList;

    private String cShopcolumnidList;

    private String cShopcolumntypeidList;

    private String cContent;

    public Shop(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, String cAddressId, String cB22o, String cBusinessLicenseImg, String cBusinessLicenseNo, String cCity, String cContactEmail, String cContactNumber, String cContactPhone, String cDistrict, Double double1, Double cGold, Double cGold2, Double cGold3, Double cGold4, String cIdCardImgBack, String cIdCardImgFront, Integer cIfHot, Integer cIfNew, Integer cIfOpen, Integer cIfPrivate, Integer cIfRecommend, String cLegalPersonName, Integer cLevel, String cLogo, String cMyRecommendUserId, String cProvince, Double cR1, Double cR2, Double cR3, Double cR4, Double cR5, Double cR6, Double cR7, Double cR8, String cShopColumnId, String cShopName, Integer cSort, Integer cState, String cSummary, String cTaxImg, Integer cUserno, String cXy, String cFactId, String cShopChl, String cAgentId, String cPrefectureidList, Integer cIfShiti, String cHide, Double cPostageLimit, Double cPostagePrice, Double cTotalJinhuoAverage, Double cTotalJinhuoMoney, Integer cTotalJinhuoNum, Double cTotalSaleAverage, Double cTotalSaleMoney, Integer cTotalSaleNum, String cAgentName, String cFactName, Integer cExhibitNum, Integer cInviteNum, String cCreateUserId, String cCharge, Integer cTjOrdernum, Integer cTjOrdernumMonth, String cGeoCode, String cScene, String cSceneId, String cPassword, String cUsername, Integer cIfFact) {
        this.cId = cId;
        this.cBlockId = cBlockId;
        this.cCityId = cCityId;
        this.cCreateTime = cCreateTime;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cAddressId = cAddressId;
        this.cB22o = cB22o;
        this.cBusinessLicenseImg = cBusinessLicenseImg;
        this.cBusinessLicenseNo = cBusinessLicenseNo;
        this.cCity = cCity;
        this.cContactEmail = cContactEmail;
        this.cContactNumber = cContactNumber;
        this.cContactPhone = cContactPhone;
        this.cDistrict = cDistrict;
        this.double1 = double1;
        this.cGold = cGold;
        this.cGold2 = cGold2;
        this.cGold3 = cGold3;
        this.cGold4 = cGold4;
        this.cIdCardImgBack = cIdCardImgBack;
        this.cIdCardImgFront = cIdCardImgFront;
        this.cIfHot = cIfHot;
        this.cIfNew = cIfNew;
        this.cIfOpen = cIfOpen;
        this.cIfPrivate = cIfPrivate;
        this.cIfRecommend = cIfRecommend;
        this.cLegalPersonName = cLegalPersonName;
        this.cLevel = cLevel;
        this.cLogo = cLogo;
        this.cMyRecommendUserId = cMyRecommendUserId;
        this.cProvince = cProvince;
        this.cR1 = cR1;
        this.cR2 = cR2;
        this.cR3 = cR3;
        this.cR4 = cR4;
        this.cR5 = cR5;
        this.cR6 = cR6;
        this.cR7 = cR7;
        this.cR8 = cR8;
        this.cShopColumnId = cShopColumnId;
        this.cShopName = cShopName;
        this.cSort = cSort;
        this.cState = cState;
        this.cSummary = cSummary;
        this.cTaxImg = cTaxImg;
        this.cUserno = cUserno;
        this.cXy = cXy;
        this.cFactId = cFactId;
        this.cShopChl = cShopChl;
        this.cAgentId = cAgentId;
        this.cPrefectureidList = cPrefectureidList;
        this.cIfShiti = cIfShiti;
        this.cHide = cHide;
        this.cPostageLimit = cPostageLimit;
        this.cPostagePrice = cPostagePrice;
        this.cTotalJinhuoAverage = cTotalJinhuoAverage;
        this.cTotalJinhuoMoney = cTotalJinhuoMoney;
        this.cTotalJinhuoNum = cTotalJinhuoNum;
        this.cTotalSaleAverage = cTotalSaleAverage;
        this.cTotalSaleMoney = cTotalSaleMoney;
        this.cTotalSaleNum = cTotalSaleNum;
        this.cAgentName = cAgentName;
        this.cFactName = cFactName;
        this.cExhibitNum = cExhibitNum;
        this.cInviteNum = cInviteNum;
        this.cCreateUserId = cCreateUserId;
        this.cCharge = cCharge;
        this.cTjOrdernum = cTjOrdernum;
        this.cTjOrdernumMonth = cTjOrdernumMonth;
        this.cGeoCode = cGeoCode;
        this.cScene = cScene;
        this.cSceneId = cSceneId;
        this.cPassword = cPassword;
        this.cUsername = cUsername;
        this.cIfFact = cIfFact;
    }

    public Shop() {
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

    public String getcAddressId() {
        return cAddressId;
    }

    public void setcAddressId(String cAddressId) {
        this.cAddressId = cAddressId == null ? null : cAddressId.trim();
    }

    public String getcB22o() {
        return cB22o;
    }

    public void setcB22o(String cB22o) {
        this.cB22o = cB22o == null ? null : cB22o.trim();
    }

    public String getcBusinessLicenseImg() {
        return cBusinessLicenseImg;
    }

    public void setcBusinessLicenseImg(String cBusinessLicenseImg) {
        this.cBusinessLicenseImg = cBusinessLicenseImg == null ? null : cBusinessLicenseImg.trim();
    }

    public String getcBusinessLicenseNo() {
        return cBusinessLicenseNo;
    }

    public void setcBusinessLicenseNo(String cBusinessLicenseNo) {
        this.cBusinessLicenseNo = cBusinessLicenseNo == null ? null : cBusinessLicenseNo.trim();
    }

    public String getcCity() {
        return cCity;
    }

    public void setcCity(String cCity) {
        this.cCity = cCity == null ? null : cCity.trim();
    }

    public String getcContactEmail() {
        return cContactEmail;
    }

    public void setcContactEmail(String cContactEmail) {
        this.cContactEmail = cContactEmail == null ? null : cContactEmail.trim();
    }

    public String getcContactNumber() {
        return cContactNumber;
    }

    public void setcContactNumber(String cContactNumber) {
        this.cContactNumber = cContactNumber == null ? null : cContactNumber.trim();
    }

    public String getcContactPhone() {
        return cContactPhone;
    }

    public void setcContactPhone(String cContactPhone) {
        this.cContactPhone = cContactPhone == null ? null : cContactPhone.trim();
    }

    public String getcDistrict() {
        return cDistrict;
    }

    public void setcDistrict(String cDistrict) {
        this.cDistrict = cDistrict == null ? null : cDistrict.trim();
    }

    public Double getDouble1() {
        return double1;
    }

    public void setDouble1(Double double1) {
        this.double1 = double1;
    }

    public Double getcGold() {
        return cGold;
    }

    public void setcGold(Double cGold) {
        this.cGold = cGold;
    }

    public Double getcGold2() {
        return cGold2;
    }

    public void setcGold2(Double cGold2) {
        this.cGold2 = cGold2;
    }

    public Double getcGold3() {
        return cGold3;
    }

    public void setcGold3(Double cGold3) {
        this.cGold3 = cGold3;
    }

    public Double getcGold4() {
        return cGold4;
    }

    public void setcGold4(Double cGold4) {
        this.cGold4 = cGold4;
    }

    public String getcIdCardImgBack() {
        return cIdCardImgBack;
    }

    public void setcIdCardImgBack(String cIdCardImgBack) {
        this.cIdCardImgBack = cIdCardImgBack == null ? null : cIdCardImgBack.trim();
    }

    public String getcIdCardImgFront() {
        return cIdCardImgFront;
    }

    public void setcIdCardImgFront(String cIdCardImgFront) {
        this.cIdCardImgFront = cIdCardImgFront == null ? null : cIdCardImgFront.trim();
    }

    public Integer getcIfHot() {
        return cIfHot;
    }

    public void setcIfHot(Integer cIfHot) {
        this.cIfHot = cIfHot;
    }

    public Integer getcIfNew() {
        return cIfNew;
    }

    public void setcIfNew(Integer cIfNew) {
        this.cIfNew = cIfNew;
    }

    public Integer getcIfOpen() {
        return cIfOpen;
    }

    public void setcIfOpen(Integer cIfOpen) {
        this.cIfOpen = cIfOpen;
    }

    public Integer getcIfPrivate() {
        return cIfPrivate;
    }

    public void setcIfPrivate(Integer cIfPrivate) {
        this.cIfPrivate = cIfPrivate;
    }

    public Integer getcIfRecommend() {
        return cIfRecommend;
    }

    public void setcIfRecommend(Integer cIfRecommend) {
        this.cIfRecommend = cIfRecommend;
    }

    public String getcLegalPersonName() {
        return cLegalPersonName;
    }

    public void setcLegalPersonName(String cLegalPersonName) {
        this.cLegalPersonName = cLegalPersonName == null ? null : cLegalPersonName.trim();
    }

    public Integer getcLevel() {
        return cLevel;
    }

    public void setcLevel(Integer cLevel) {
        this.cLevel = cLevel;
    }

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo == null ? null : cLogo.trim();
    }

    public String getcMyRecommendUserId() {
        return cMyRecommendUserId;
    }

    public void setcMyRecommendUserId(String cMyRecommendUserId) {
        this.cMyRecommendUserId = cMyRecommendUserId == null ? null : cMyRecommendUserId.trim();
    }

    public String getcProvince() {
        return cProvince;
    }

    public void setcProvince(String cProvince) {
        this.cProvince = cProvince == null ? null : cProvince.trim();
    }

    public Double getcR1() {
        return cR1;
    }

    public void setcR1(Double cR1) {
        this.cR1 = cR1;
    }

    public Double getcR2() {
        return cR2;
    }

    public void setcR2(Double cR2) {
        this.cR2 = cR2;
    }

    public Double getcR3() {
        return cR3;
    }

    public void setcR3(Double cR3) {
        this.cR3 = cR3;
    }

    public Double getcR4() {
        return cR4;
    }

    public void setcR4(Double cR4) {
        this.cR4 = cR4;
    }

    public Double getcR5() {
        return cR5;
    }

    public void setcR5(Double cR5) {
        this.cR5 = cR5;
    }

    public Double getcR6() {
        return cR6;
    }

    public void setcR6(Double cR6) {
        this.cR6 = cR6;
    }

    public Double getcR7() {
        return cR7;
    }

    public void setcR7(Double cR7) {
        this.cR7 = cR7;
    }

    public Double getcR8() {
        return cR8;
    }

    public void setcR8(Double cR8) {
        this.cR8 = cR8;
    }

    public String getcShopColumnId() {
        return cShopColumnId;
    }

    public void setcShopColumnId(String cShopColumnId) {
        this.cShopColumnId = cShopColumnId == null ? null : cShopColumnId.trim();
    }

    public String getcShopName() {
        return cShopName;
    }

    public void setcShopName(String cShopName) {
        this.cShopName = cShopName == null ? null : cShopName.trim();
    }

    public Integer getcSort() {
        return cSort;
    }

    public void setcSort(Integer cSort) {
        this.cSort = cSort;
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

    public String getcTaxImg() {
        return cTaxImg;
    }

    public void setcTaxImg(String cTaxImg) {
        this.cTaxImg = cTaxImg == null ? null : cTaxImg.trim();
    }

    public Integer getcUserno() {
        return cUserno;
    }

    public void setcUserno(Integer cUserno) {
        this.cUserno = cUserno;
    }

    public String getcXy() {
        return cXy;
    }

    public void setcXy(String cXy) {
        this.cXy = cXy == null ? null : cXy.trim();
    }

    public String getcFactId() {
        return cFactId;
    }

    public void setcFactId(String cFactId) {
        this.cFactId = cFactId == null ? null : cFactId.trim();
    }

    public String getcShopChl() {
        return cShopChl;
    }

    public void setcShopChl(String cShopChl) {
        this.cShopChl = cShopChl == null ? null : cShopChl.trim();
    }

    public String getcAgentId() {
        return cAgentId;
    }

    public void setcAgentId(String cAgentId) {
        this.cAgentId = cAgentId == null ? null : cAgentId.trim();
    }

    public String getcPrefectureidList() {
        return cPrefectureidList;
    }

    public void setcPrefectureidList(String cPrefectureidList) {
        this.cPrefectureidList = cPrefectureidList == null ? null : cPrefectureidList.trim();
    }

    public Integer getcIfShiti() {
        return cIfShiti;
    }

    public void setcIfShiti(Integer cIfShiti) {
        this.cIfShiti = cIfShiti;
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public Double getcPostageLimit() {
        return cPostageLimit;
    }

    public void setcPostageLimit(Double cPostageLimit) {
        this.cPostageLimit = cPostageLimit;
    }

    public Double getcPostagePrice() {
        return cPostagePrice;
    }

    public void setcPostagePrice(Double cPostagePrice) {
        this.cPostagePrice = cPostagePrice;
    }

    public Double getcTotalJinhuoAverage() {
        return cTotalJinhuoAverage;
    }

    public void setcTotalJinhuoAverage(Double cTotalJinhuoAverage) {
        this.cTotalJinhuoAverage = cTotalJinhuoAverage;
    }

    public Double getcTotalJinhuoMoney() {
        return cTotalJinhuoMoney;
    }

    public void setcTotalJinhuoMoney(Double cTotalJinhuoMoney) {
        this.cTotalJinhuoMoney = cTotalJinhuoMoney;
    }

    public Integer getcTotalJinhuoNum() {
        return cTotalJinhuoNum;
    }

    public void setcTotalJinhuoNum(Integer cTotalJinhuoNum) {
        this.cTotalJinhuoNum = cTotalJinhuoNum;
    }

    public Double getcTotalSaleAverage() {
        return cTotalSaleAverage;
    }

    public void setcTotalSaleAverage(Double cTotalSaleAverage) {
        this.cTotalSaleAverage = cTotalSaleAverage;
    }

    public Double getcTotalSaleMoney() {
        return cTotalSaleMoney;
    }

    public void setcTotalSaleMoney(Double cTotalSaleMoney) {
        this.cTotalSaleMoney = cTotalSaleMoney;
    }

    public Integer getcTotalSaleNum() {
        return cTotalSaleNum;
    }

    public void setcTotalSaleNum(Integer cTotalSaleNum) {
        this.cTotalSaleNum = cTotalSaleNum;
    }

    public String getcAgentName() {
        return cAgentName;
    }

    public void setcAgentName(String cAgentName) {
        this.cAgentName = cAgentName == null ? null : cAgentName.trim();
    }

    public String getcFactName() {
        return cFactName;
    }

    public void setcFactName(String cFactName) {
        this.cFactName = cFactName == null ? null : cFactName.trim();
    }

    public Integer getcExhibitNum() {
        return cExhibitNum;
    }

    public void setcExhibitNum(Integer cExhibitNum) {
        this.cExhibitNum = cExhibitNum;
    }

    public Integer getcInviteNum() {
        return cInviteNum;
    }

    public void setcInviteNum(Integer cInviteNum) {
        this.cInviteNum = cInviteNum;
    }

    public String getcCreateUserId() {
        return cCreateUserId;
    }

    public void setcCreateUserId(String cCreateUserId) {
        this.cCreateUserId = cCreateUserId == null ? null : cCreateUserId.trim();
    }

    public String getcCharge() {
        return cCharge;
    }

    public void setcCharge(String cCharge) {
        this.cCharge = cCharge == null ? null : cCharge.trim();
    }

    public Integer getcTjOrdernum() {
        return cTjOrdernum;
    }

    public void setcTjOrdernum(Integer cTjOrdernum) {
        this.cTjOrdernum = cTjOrdernum;
    }

    public Integer getcTjOrdernumMonth() {
        return cTjOrdernumMonth;
    }

    public void setcTjOrdernumMonth(Integer cTjOrdernumMonth) {
        this.cTjOrdernumMonth = cTjOrdernumMonth;
    }

    public String getcGeoCode() {
        return cGeoCode;
    }

    public void setcGeoCode(String cGeoCode) {
        this.cGeoCode = cGeoCode == null ? null : cGeoCode.trim();
    }

    public String getcScene() {
        return cScene;
    }

    public void setcScene(String cScene) {
        this.cScene = cScene == null ? null : cScene.trim();
    }

    public String getcSceneId() {
        return cSceneId;
    }

    public void setcSceneId(String cSceneId) {
        this.cSceneId = cSceneId == null ? null : cSceneId.trim();
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername == null ? null : cUsername.trim();
    }

    public Integer getcIfFact() {
        return cIfFact;
    }

    public void setcIfFact(Integer cIfFact) {
        this.cIfFact = cIfFact;
    }

    public String getcBrandidList() {
        return cBrandidList;
    }

    public void setcBrandidList(String cBrandidList) {
        this.cBrandidList = cBrandidList == null ? null : cBrandidList.trim();
    }

    public String getcSceneidList() {
        return cSceneidList;
    }

    public void setcSceneidList(String cSceneidList) {
        this.cSceneidList = cSceneidList == null ? null : cSceneidList.trim();
    }

    public String getcShopcolumnidList() {
        return cShopcolumnidList;
    }

    public void setcShopcolumnidList(String cShopcolumnidList) {
        this.cShopcolumnidList = cShopcolumnidList == null ? null : cShopcolumnidList.trim();
    }

    public String getcShopcolumntypeidList() {
        return cShopcolumntypeidList;
    }

    public void setcShopcolumntypeidList(String cShopcolumntypeidList) {
        this.cShopcolumntypeidList = cShopcolumntypeidList == null ? null : cShopcolumntypeidList.trim();
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent == null ? null : cContent.trim();
    }
}