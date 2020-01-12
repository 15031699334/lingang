package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Product {
    private String cId;

    private String cBlockId;

    private String cCityId;     //城市id

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cCreateTime;       // 创建时间

    private String cCreateUser;

    private String cDistrictId;     // 地区id

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cLastUpdateTime;       // 最后修改时间

    private String cLastUpdateUser;

    private String cProvinceId;         // 省份id

    private String cAlbumId;

    private Double cCityGold;

    private Integer cDiscount;

    private Double cDistrictGold;

    private Double cFactGold;

    private Integer cGoodsSex;

    private Integer cIfCanInvoice;

    private Integer cIfPrivate;

    private Integer cIfRecommend;

    private Integer ifShopInsideRecommend;

    private Integer ifApprove;

    private String cLogo;   // xxxx.png

    private String cName;       // 商品名称

    private Double cNowPrice;       // 现价

    private String cNowPriceDescription;

    private Double cOneGold;

    private Double cOriginalPrice;

    private Integer cPaixuNum;

    private Double cPlatGold;

    private String cProductCode;

    private Double cPrvcGold;

    private Integer cReplynum;

    private String cSalesInformation;

    private String cShopColumnId;

    private String cShopColumnTypeId;   // 品名id

    private String cShopId;         // 所属商铺id

    private Integer cSoldNum;

    private Integer cStockNum;      // 库存 吨数

    private String cSummary;        // 简介 备注

    private Double cThreeGold;

    private Integer cTicketNum;

    private Double cTwoGold;

    private Double cScore;          // 吨数

    private String cQrcodeUrl;

    private Integer cIfRecommendPc;

    private String cGuige;

    private String cGoodsInterval;

    private Integer cGoodsTotal;

    private String cProductRelationId;

    private Double cGold;

    private String cJianmoney;

    private String cJztime;

    private Integer cShuxing;

    private String cXsnum;

    private String cZkbl;       // 所属仓库 // 添加商品时 商户所属的库同步过来

    private String cAgentId;

    private String cBrandId;

    private String cSceneId;

    private String cTop;

    private String cPrefectureId;

    private String cShopName;

    private Double cShowPrice;

    private Integer cMyStockNum;

    private Double cSexPrice;

    private String cHide;

    private Integer ifHidePrice;

    private String cYunfeeId;

    private String cYunfeeTitle;

    private String cP1;         // 材料   // 返回前台的时用的字段

    private String cP2;

    private String cP3;

    private String cP4;

    private String cP5;

    private String cP6;

    private Integer type;

    private String cPrtype;

    private String cP0;             // 规格   // 返回前台时用的字段

    private Double cNewYunfei;

    private String cDescription;

    private String cPriceList;      // 规格及库存所在字段

    private String cPriceType;

    public Product(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, String cAlbumId, Double cCityGold, Integer cDiscount, Double cDistrictGold, Double cFactGold, Integer cGoodsSex, Integer cIfCanInvoice, Integer cIfPrivate, Integer cIfRecommend, Integer ifShopInsideRecommend, Integer ifApprove, String cLogo, String cName, Double cNowPrice, String cNowPriceDescription, Double cOneGold, Double cOriginalPrice, Integer cPaixuNum, Double cPlatGold, String cProductCode, Double cPrvcGold, Integer cReplynum, String cSalesInformation, String cShopColumnId, String cShopColumnTypeId, String cShopId, Integer cSoldNum, Integer cStockNum, String cSummary, Double cThreeGold, Integer cTicketNum, Double cTwoGold, Double cScore, String cQrcodeUrl, Integer cIfRecommendPc, String cGuige, String cGoodsInterval, Integer cGoodsTotal, String cProductRelationId, Double cGold, String cJianmoney, String cJztime, Integer cShuxing, String cXsnum, String cZkbl, String cAgentId, String cBrandId, String cSceneId, String cTop, String cPrefectureId, String cShopName, Double cShowPrice, Integer cMyStockNum, Double cSexPrice, String cHide, Integer ifHidePrice, String cYunfeeId, String cYunfeeTitle, String cP1, String cP2, String cP3, String cP4, String cP5, String cP6, Integer type, String cPrtype, String cP0, Double cNewYunfei, String cDescription, String cPriceList, String cPriceType) {
        this.cId = cId;
        this.cBlockId = cBlockId;
        this.cCityId = cCityId;
        this.cCreateTime = cCreateTime;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cAlbumId = cAlbumId;
        this.cCityGold = cCityGold;
        this.cDiscount = cDiscount;
        this.cDistrictGold = cDistrictGold;
        this.cFactGold = cFactGold;
        this.cGoodsSex = cGoodsSex;
        this.cIfCanInvoice = cIfCanInvoice;
        this.cIfPrivate = cIfPrivate;
        this.cIfRecommend = cIfRecommend;
        this.ifShopInsideRecommend = ifShopInsideRecommend;
        this.ifApprove = ifApprove;
        this.cLogo = cLogo;
        this.cName = cName;
        this.cNowPrice = cNowPrice;
        this.cNowPriceDescription = cNowPriceDescription;
        this.cOneGold = cOneGold;
        this.cOriginalPrice = cOriginalPrice;
        this.cPaixuNum = cPaixuNum;
        this.cPlatGold = cPlatGold;
        this.cProductCode = cProductCode;
        this.cPrvcGold = cPrvcGold;
        this.cReplynum = cReplynum;
        this.cSalesInformation = cSalesInformation;
        this.cShopColumnId = cShopColumnId;
        this.cShopColumnTypeId = cShopColumnTypeId;
        this.cShopId = cShopId;
        this.cSoldNum = cSoldNum;
        this.cStockNum = cStockNum;
        this.cSummary = cSummary;
        this.cThreeGold = cThreeGold;
        this.cTicketNum = cTicketNum;
        this.cTwoGold = cTwoGold;
        this.cScore = cScore;
        this.cQrcodeUrl = cQrcodeUrl;
        this.cIfRecommendPc = cIfRecommendPc;
        this.cGuige = cGuige;
        this.cGoodsInterval = cGoodsInterval;
        this.cGoodsTotal = cGoodsTotal;
        this.cProductRelationId = cProductRelationId;
        this.cGold = cGold;
        this.cJianmoney = cJianmoney;
        this.cJztime = cJztime;
        this.cShuxing = cShuxing;
        this.cXsnum = cXsnum;
        this.cZkbl = cZkbl;
        this.cAgentId = cAgentId;
        this.cBrandId = cBrandId;
        this.cSceneId = cSceneId;
        this.cTop = cTop;
        this.cPrefectureId = cPrefectureId;
        this.cShopName = cShopName;
        this.cShowPrice = cShowPrice;
        this.cMyStockNum = cMyStockNum;
        this.cSexPrice = cSexPrice;
        this.cHide = cHide;
        this.ifHidePrice = ifHidePrice;
        this.cYunfeeId = cYunfeeId;
        this.cYunfeeTitle = cYunfeeTitle;
        this.cP1 = cP1;
        this.cP2 = cP2;
        this.cP3 = cP3;
        this.cP4 = cP4;
        this.cP5 = cP5;
        this.cP6 = cP6;
        this.type = type;
        this.cPrtype = cPrtype;
        this.cP0 = cP0;
        this.cNewYunfei = cNewYunfei;
        this.cDescription = cDescription;
        this.cPriceList = cPriceList;
        this.cPriceType = cPriceType;
    }

    public Product() {
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

    public String getcAlbumId() {
        return cAlbumId;
    }

    public void setcAlbumId(String cAlbumId) {
        this.cAlbumId = cAlbumId == null ? null : cAlbumId.trim();
    }

    public Double getcCityGold() {
        return cCityGold;
    }

    public void setcCityGold(Double cCityGold) {
        this.cCityGold = cCityGold;
    }

    public Integer getcDiscount() {
        return cDiscount;
    }

    public void setcDiscount(Integer cDiscount) {
        this.cDiscount = cDiscount;
    }

    public Double getcDistrictGold() {
        return cDistrictGold;
    }

    public void setcDistrictGold(Double cDistrictGold) {
        this.cDistrictGold = cDistrictGold;
    }

    public Double getcFactGold() {
        return cFactGold;
    }

    public void setcFactGold(Double cFactGold) {
        this.cFactGold = cFactGold;
    }

    public Integer getcGoodsSex() {
        return cGoodsSex;
    }

    public void setcGoodsSex(Integer cGoodsSex) {
        this.cGoodsSex = cGoodsSex;
    }

    public Integer getcIfCanInvoice() {
        return cIfCanInvoice;
    }

    public void setcIfCanInvoice(Integer cIfCanInvoice) {
        this.cIfCanInvoice = cIfCanInvoice;
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

    public Integer getIfShopInsideRecommend() {
        return ifShopInsideRecommend;
    }

    public void setIfShopInsideRecommend(Integer ifShopInsideRecommend) {
        this.ifShopInsideRecommend = ifShopInsideRecommend;
    }

    public Integer getIfApprove() {
        return ifApprove;
    }

    public void setIfApprove(Integer ifApprove) {
        this.ifApprove = ifApprove;
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

    public Double getcNowPrice() {
        return cNowPrice;
    }

    public void setcNowPrice(Double cNowPrice) {
        this.cNowPrice = cNowPrice;
    }

    public String getcNowPriceDescription() {
        return cNowPriceDescription;
    }

    public void setcNowPriceDescription(String cNowPriceDescription) {
        this.cNowPriceDescription = cNowPriceDescription == null ? null : cNowPriceDescription.trim();
    }

    public Double getcOneGold() {
        return cOneGold;
    }

    public void setcOneGold(Double cOneGold) {
        this.cOneGold = cOneGold;
    }

    public Double getcOriginalPrice() {
        return cOriginalPrice;
    }

    public void setcOriginalPrice(Double cOriginalPrice) {
        this.cOriginalPrice = cOriginalPrice;
    }

    public Integer getcPaixuNum() {
        return cPaixuNum;
    }

    public void setcPaixuNum(Integer cPaixuNum) {
        this.cPaixuNum = cPaixuNum;
    }

    public Double getcPlatGold() {
        return cPlatGold;
    }

    public void setcPlatGold(Double cPlatGold) {
        this.cPlatGold = cPlatGold;
    }

    public String getcProductCode() {
        return cProductCode;
    }

    public void setcProductCode(String cProductCode) {
        this.cProductCode = cProductCode == null ? null : cProductCode.trim();
    }

    public Double getcPrvcGold() {
        return cPrvcGold;
    }

    public void setcPrvcGold(Double cPrvcGold) {
        this.cPrvcGold = cPrvcGold;
    }

    public Integer getcReplynum() {
        return cReplynum;
    }

    public void setcReplynum(Integer cReplynum) {
        this.cReplynum = cReplynum;
    }

    public String getcSalesInformation() {
        return cSalesInformation;
    }

    public void setcSalesInformation(String cSalesInformation) {
        this.cSalesInformation = cSalesInformation == null ? null : cSalesInformation.trim();
    }

    public String getcShopColumnId() {
        return cShopColumnId;
    }

    public void setcShopColumnId(String cShopColumnId) {
        this.cShopColumnId = cShopColumnId == null ? null : cShopColumnId.trim();
    }

    public String getcShopColumnTypeId() {
        return cShopColumnTypeId;
    }

    public void setcShopColumnTypeId(String cShopColumnTypeId) {
        this.cShopColumnTypeId = cShopColumnTypeId == null ? null : cShopColumnTypeId.trim();
    }

    public String getcShopId() {
        return cShopId;
    }

    public void setcShopId(String cShopId) {
        this.cShopId = cShopId == null ? null : cShopId.trim();
    }

    public Integer getcSoldNum() {
        return cSoldNum;
    }

    public void setcSoldNum(Integer cSoldNum) {
        this.cSoldNum = cSoldNum;
    }

    public Integer getcStockNum() {
        return cStockNum;
    }

    public void setcStockNum(Integer cStockNum) {
        this.cStockNum = cStockNum;
    }

    public String getcSummary() {
        return cSummary;
    }

    public void setcSummary(String cSummary) {
        this.cSummary = cSummary == null ? null : cSummary.trim();
    }

    public Double getcThreeGold() {
        return cThreeGold;
    }

    public void setcThreeGold(Double cThreeGold) {
        this.cThreeGold = cThreeGold;
    }

    public Integer getcTicketNum() {
        return cTicketNum;
    }

    public void setcTicketNum(Integer cTicketNum) {
        this.cTicketNum = cTicketNum;
    }

    public Double getcTwoGold() {
        return cTwoGold;
    }

    public void setcTwoGold(Double cTwoGold) {
        this.cTwoGold = cTwoGold;
    }

    public Double getcScore() {
        return cScore;
    }

    public void setcScore(Double cScore) {
        this.cScore = cScore;
    }

    public String getcQrcodeUrl() {
        return cQrcodeUrl;
    }

    public void setcQrcodeUrl(String cQrcodeUrl) {
        this.cQrcodeUrl = cQrcodeUrl == null ? null : cQrcodeUrl.trim();
    }

    public Integer getcIfRecommendPc() {
        return cIfRecommendPc;
    }

    public void setcIfRecommendPc(Integer cIfRecommendPc) {
        this.cIfRecommendPc = cIfRecommendPc;
    }

    public String getcGuige() {
        return cGuige;
    }

    public void setcGuige(String cGuige) {
        this.cGuige = cGuige == null ? null : cGuige.trim();
    }

    public String getcGoodsInterval() {
        return cGoodsInterval;
    }

    public void setcGoodsInterval(String cGoodsInterval) {
        this.cGoodsInterval = cGoodsInterval == null ? null : cGoodsInterval.trim();
    }

    public Integer getcGoodsTotal() {
        return cGoodsTotal;
    }

    public void setcGoodsTotal(Integer cGoodsTotal) {
        this.cGoodsTotal = cGoodsTotal;
    }

    public String getcProductRelationId() {
        return cProductRelationId;
    }

    public void setcProductRelationId(String cProductRelationId) {
        this.cProductRelationId = cProductRelationId == null ? null : cProductRelationId.trim();
    }

    public Double getcGold() {
        return cGold;
    }

    public void setcGold(Double cGold) {
        this.cGold = cGold;
    }

    public String getcJianmoney() {
        return cJianmoney;
    }

    public void setcJianmoney(String cJianmoney) {
        this.cJianmoney = cJianmoney == null ? null : cJianmoney.trim();
    }

    public String getcJztime() {
        return cJztime;
    }

    public void setcJztime(String cJztime) {
        this.cJztime = cJztime == null ? null : cJztime.trim();
    }

    public Integer getcShuxing() {
        return cShuxing;
    }

    public void setcShuxing(Integer cShuxing) {
        this.cShuxing = cShuxing;
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

    public String getcAgentId() {
        return cAgentId;
    }

    public void setcAgentId(String cAgentId) {
        this.cAgentId = cAgentId == null ? null : cAgentId.trim();
    }

    public String getcBrandId() {
        return cBrandId;
    }

    public void setcBrandId(String cBrandId) {
        this.cBrandId = cBrandId == null ? null : cBrandId.trim();
    }

    public String getcSceneId() {
        return cSceneId;
    }

    public void setcSceneId(String cSceneId) {
        this.cSceneId = cSceneId == null ? null : cSceneId.trim();
    }

    public String getcTop() {
        return cTop;
    }

    public void setcTop(String cTop) {
        this.cTop = cTop == null ? null : cTop.trim();
    }

    public String getcPrefectureId() {
        return cPrefectureId;
    }

    public void setcPrefectureId(String cPrefectureId) {
        this.cPrefectureId = cPrefectureId == null ? null : cPrefectureId.trim();
    }

    public String getcShopName() {
        return cShopName;
    }

    public void setcShopName(String cShopName) {
        this.cShopName = cShopName == null ? null : cShopName.trim();
    }

    public Double getcShowPrice() {
        return cShowPrice;
    }

    public void setcShowPrice(Double cShowPrice) {
        this.cShowPrice = cShowPrice;
    }

    public Integer getcMyStockNum() {
        return cMyStockNum;
    }

    public void setcMyStockNum(Integer cMyStockNum) {
        this.cMyStockNum = cMyStockNum;
    }

    public Double getcSexPrice() {
        return cSexPrice;
    }

    public void setcSexPrice(Double cSexPrice) {
        this.cSexPrice = cSexPrice;
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public Integer getIfHidePrice() {
        return ifHidePrice;
    }

    public void setIfHidePrice(Integer ifHidePrice) {
        this.ifHidePrice = ifHidePrice;
    }

    public String getcYunfeeId() {
        return cYunfeeId;
    }

    public void setcYunfeeId(String cYunfeeId) {
        this.cYunfeeId = cYunfeeId == null ? null : cYunfeeId.trim();
    }

    public String getcYunfeeTitle() {
        return cYunfeeTitle;
    }

    public void setcYunfeeTitle(String cYunfeeTitle) {
        this.cYunfeeTitle = cYunfeeTitle == null ? null : cYunfeeTitle.trim();
    }

    public String getcP1() {
        return cP1;
    }

    public void setcP1(String cP1) {
        this.cP1 = cP1 == null ? null : cP1.trim();
    }

    public String getcP2() {
        return cP2;
    }

    public void setcP2(String cP2) {
        this.cP2 = cP2 == null ? null : cP2.trim();
    }

    public String getcP3() {
        return cP3;
    }

    public void setcP3(String cP3) {
        this.cP3 = cP3 == null ? null : cP3.trim();
    }

    public String getcP4() {
        return cP4;
    }

    public void setcP4(String cP4) {
        this.cP4 = cP4 == null ? null : cP4.trim();
    }

    public String getcP5() {
        return cP5;
    }

    public void setcP5(String cP5) {
        this.cP5 = cP5 == null ? null : cP5.trim();
    }

    public String getcP6() {
        return cP6;
    }

    public void setcP6(String cP6) {
        this.cP6 = cP6 == null ? null : cP6.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getcPrtype() {
        return cPrtype;
    }

    public void setcPrtype(String cPrtype) {
        this.cPrtype = cPrtype == null ? null : cPrtype.trim();
    }

    public String getcP0() {
        return cP0;
    }

    public void setcP0(String cP0) {
        this.cP0 = cP0 == null ? null : cP0.trim();
    }

    public Double getcNewYunfei() {
        return cNewYunfei;
    }

    public void setcNewYunfei(Double cNewYunfei) {
        this.cNewYunfei = cNewYunfei;
    }

    public String getcDescription() {
        return cDescription;
    }

    public void setcDescription(String cDescription) {
        this.cDescription = cDescription == null ? null : cDescription.trim();
    }

    public String getcPriceList() {
        return cPriceList;
    }

    public void setcPriceList(String cPriceList) {
        this.cPriceList = cPriceList == null ? null : cPriceList.trim();
    }

    public String getcPriceType() {
        return cPriceType;
    }

    public void setcPriceType(String cPriceType) {
        this.cPriceType = cPriceType == null ? null : cPriceType.trim();
    }
}