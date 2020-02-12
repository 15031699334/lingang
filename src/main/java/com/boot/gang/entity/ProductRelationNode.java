package com.boot.gang.entity;

import java.util.Date;

public class ProductRelationNode {
    private String cId;

    private String cBlockId;

    private String cCityId;

    private Date cCreateTime;

    private String cCreateUser;

    private String cDistrictId;

    private Date cLastUpdateTime;

    private String cLastUpdateUser;

    private String cProvinceId;

    private String cAgentId;

    private String cAlbumId;

    private String cBrandId;

    private Double cCityGold;

    private Integer cDiscount;

    private Double cDistrictGold;

    private Double cFactGold;

    private Double cGold;               //厚度

    private String cGoodsInterval;

    private Integer cGoodsSex;

    private Integer cGoodsTotal;

    private String cGuige;

    private Integer cIfCanInvoice;

    private Integer cIfPrivate;

    private Integer cIfRecommend;

    private Integer cIfRecommendPc;

    private Integer ifShopInsideRecommend;

    private Integer ifApprove;

    private String cJianmoney;

    private Date cJztime;

    private String cLogo;           // logo

    private Integer cMyStockNum;

    private Double cNowPrice;       // 单价

    private String cNowPriceDescription;

    private Double cOneGold;

    private Double cOriginalPrice;

    private Integer cPaixuNum;

    private Double cPlatGold;

    private String cPrefectureId;

    private String cPriceList;

    private String cPriceType;

    private String cProductCode;

    private String cProductId;

    private String cName;           // 品名

    private String cProductRelationId;

    private Integer cProductStockNum;

    private String cPrtype;

    private Double cPrvcGold;

    private String cQrcodeUrl;

    private Integer cReplynum;

    private String cSalesInformation;

    private String cSceneId;

    private Double cScore;

    private Double cSexPrice;

    private String cShopColumnId;

    private String cShopColumnTypeId;

    private String cShopId;

    private String cShopName;

    private Double cShowPrice;

    private String cShuxing;

    private String cSn;

    private Integer cSoldNum;

    private Integer cStockNum;          //库存卷数

    private String cSummary;            // 备注

    private Double cThreeGold;          // 厚度

    private Integer cTicketNum;

    private String cTop;                // 规格

    private Double cTwoGold;            // 宽度

    private String cUserId;

    private String cXsnum;              // 材质

    private String cZkbl;       // 所属仓库 // 添加商品时 商户所属的库同步过来

    private String cHide;

    private Integer ifHidePrice;

    private String cPercentNowPrice;

    private String cPercentSexPrice;

    private Integer type;

    private Double cNewYunfei;

    private String cDescription;

    public ProductRelationNode(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, String cAgentId, String cAlbumId, String cBrandId, Double cCityGold, Integer cDiscount, Double cDistrictGold, Double cFactGold, Double cGold, String cGoodsInterval, Integer cGoodsSex, Integer cGoodsTotal, String cGuige, Integer cIfCanInvoice, Integer cIfPrivate, Integer cIfRecommend, Integer cIfRecommendPc, Integer ifShopInsideRecommend, Integer ifApprove, String cJianmoney, Date cJztime, String cLogo, Integer cMyStockNum, Double cNowPrice, String cNowPriceDescription, Double cOneGold, Double cOriginalPrice, Integer cPaixuNum, Double cPlatGold, String cPrefectureId, String cPriceList, String cPriceType, String cProductCode, String cProductId, String cName, String cProductRelationId, Integer cProductStockNum, String cPrtype, Double cPrvcGold, String cQrcodeUrl, Integer cReplynum, String cSalesInformation, String cSceneId, Double cScore, Double cSexPrice, String cShopColumnId, String cShopColumnTypeId, String cShopId, String cShopName, Double cShowPrice, String cShuxing, String cSn, Integer cSoldNum, Integer cStockNum, String cSummary, Double cThreeGold, Integer cTicketNum, String cTop, Double cTwoGold, String cUserId, String cXsnum, String cZkbl, String cHide, Integer ifHidePrice, String cPercentNowPrice, String cPercentSexPrice, Integer type, Double cNewYunfei, String cDescription) {
        this.cId = cId;
        this.cBlockId = cBlockId;
        this.cCityId = cCityId;
        this.cCreateTime = cCreateTime;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cAgentId = cAgentId;
        this.cAlbumId = cAlbumId;
        this.cBrandId = cBrandId;
        this.cCityGold = cCityGold;
        this.cDiscount = cDiscount;
        this.cDistrictGold = cDistrictGold;
        this.cFactGold = cFactGold;
        this.cGold = cGold;
        this.cGoodsInterval = cGoodsInterval;
        this.cGoodsSex = cGoodsSex;
        this.cGoodsTotal = cGoodsTotal;
        this.cGuige = cGuige;
        this.cIfCanInvoice = cIfCanInvoice;
        this.cIfPrivate = cIfPrivate;
        this.cIfRecommend = cIfRecommend;
        this.cIfRecommendPc = cIfRecommendPc;
        this.ifShopInsideRecommend = ifShopInsideRecommend;
        this.ifApprove = ifApprove;
        this.cJianmoney = cJianmoney;
        this.cJztime = cJztime;
        this.cLogo = cLogo;
        this.cMyStockNum = cMyStockNum;
        this.cNowPrice = cNowPrice;
        this.cNowPriceDescription = cNowPriceDescription;
        this.cOneGold = cOneGold;
        this.cOriginalPrice = cOriginalPrice;
        this.cPaixuNum = cPaixuNum;
        this.cPlatGold = cPlatGold;
        this.cPrefectureId = cPrefectureId;
        this.cPriceList = cPriceList;
        this.cPriceType = cPriceType;
        this.cProductCode = cProductCode;
        this.cProductId = cProductId;
        this.cName = cName;
        this.cProductRelationId = cProductRelationId;
        this.cProductStockNum = cProductStockNum;
        this.cPrtype = cPrtype;
        this.cPrvcGold = cPrvcGold;
        this.cQrcodeUrl = cQrcodeUrl;
        this.cReplynum = cReplynum;
        this.cSalesInformation = cSalesInformation;
        this.cSceneId = cSceneId;
        this.cScore = cScore;
        this.cSexPrice = cSexPrice;
        this.cShopColumnId = cShopColumnId;
        this.cShopColumnTypeId = cShopColumnTypeId;
        this.cShopId = cShopId;
        this.cShopName = cShopName;
        this.cShowPrice = cShowPrice;
        this.cShuxing = cShuxing;
        this.cSn = cSn;
        this.cSoldNum = cSoldNum;
        this.cStockNum = cStockNum;
        this.cSummary = cSummary;
        this.cThreeGold = cThreeGold;
        this.cTicketNum = cTicketNum;
        this.cTop = cTop;
        this.cTwoGold = cTwoGold;
        this.cUserId = cUserId;
        this.cXsnum = cXsnum;
        this.cZkbl = cZkbl;
        this.cHide = cHide;
        this.ifHidePrice = ifHidePrice;
        this.cPercentNowPrice = cPercentNowPrice;
        this.cPercentSexPrice = cPercentSexPrice;
        this.type = type;
        this.cNewYunfei = cNewYunfei;
        this.cDescription = cDescription;
    }

    public ProductRelationNode() {
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

    public String getcAgentId() {
        return cAgentId;
    }

    public void setcAgentId(String cAgentId) {
        this.cAgentId = cAgentId == null ? null : cAgentId.trim();
    }

    public String getcAlbumId() {
        return cAlbumId;
    }

    public void setcAlbumId(String cAlbumId) {
        this.cAlbumId = cAlbumId == null ? null : cAlbumId.trim();
    }

    public String getcBrandId() {
        return cBrandId;
    }

    public void setcBrandId(String cBrandId) {
        this.cBrandId = cBrandId == null ? null : cBrandId.trim();
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

    public Integer getcIfRecommendPc() {
        return cIfRecommendPc;
    }

    public void setcIfRecommendPc(Integer cIfRecommendPc) {
        this.cIfRecommendPc = cIfRecommendPc;
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

    public String getcJianmoney() {
        return cJianmoney;
    }

    public void setcJianmoney(String cJianmoney) {
        this.cJianmoney = cJianmoney == null ? null : cJianmoney.trim();
    }

    public Date getcJztime() {
        return cJztime;
    }

    public void setcJztime(Date cJztime) {
        this.cJztime = cJztime;
    }

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo == null ? null : cLogo.trim();
    }

    public Integer getcMyStockNum() {
        return cMyStockNum;
    }

    public void setcMyStockNum(Integer cMyStockNum) {
        this.cMyStockNum = cMyStockNum;
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

    public String getcPrefectureId() {
        return cPrefectureId;
    }

    public void setcPrefectureId(String cPrefectureId) {
        this.cPrefectureId = cPrefectureId == null ? null : cPrefectureId.trim();
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

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcProductRelationId() {
        return cProductRelationId;
    }

    public void setcProductRelationId(String cProductRelationId) {
        this.cProductRelationId = cProductRelationId == null ? null : cProductRelationId.trim();
    }

    public Integer getcProductStockNum() {
        return cProductStockNum;
    }

    public void setcProductStockNum(Integer cProductStockNum) {
        this.cProductStockNum = cProductStockNum;
    }

    public String getcPrtype() {
        return cPrtype;
    }

    public void setcPrtype(String cPrtype) {
        this.cPrtype = cPrtype == null ? null : cPrtype.trim();
    }

    public Double getcPrvcGold() {
        return cPrvcGold;
    }

    public void setcPrvcGold(Double cPrvcGold) {
        this.cPrvcGold = cPrvcGold;
    }

    public String getcQrcodeUrl() {
        return cQrcodeUrl;
    }

    public void setcQrcodeUrl(String cQrcodeUrl) {
        this.cQrcodeUrl = cQrcodeUrl == null ? null : cQrcodeUrl.trim();
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

    public String getcSceneId() {
        return cSceneId;
    }

    public void setcSceneId(String cSceneId) {
        this.cSceneId = cSceneId == null ? null : cSceneId.trim();
    }

    public Double getcScore() {
        return cScore;
    }

    public void setcScore(Double cScore) {
        this.cScore = cScore;
    }

    public Double getcSexPrice() {
        return cSexPrice;
    }

    public void setcSexPrice(Double cSexPrice) {
        this.cSexPrice = cSexPrice;
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

    public String getcShuxing() {
        return cShuxing;
    }

    public void setcShuxing(String cShuxing) {
        this.cShuxing = cShuxing == null ? null : cShuxing.trim();
    }

    public String getcSn() {
        return cSn;
    }

    public void setcSn(String cSn) {
        this.cSn = cSn == null ? null : cSn.trim();
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

    public String getcTop() {
        return cTop;
    }

    public void setcTop(String cTop) {
        this.cTop = cTop == null ? null : cTop.trim();
    }

    public Double getcTwoGold() {
        return cTwoGold;
    }

    public void setcTwoGold(Double cTwoGold) {
        this.cTwoGold = cTwoGold;
    }

    public String getcUserId() {
        return cUserId;
    }

    public void setcUserId(String cUserId) {
        this.cUserId = cUserId == null ? null : cUserId.trim();
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

    public String getcPercentNowPrice() {
        return cPercentNowPrice;
    }

    public void setcPercentNowPrice(String cPercentNowPrice) {
        this.cPercentNowPrice = cPercentNowPrice == null ? null : cPercentNowPrice.trim();
    }

    public String getcPercentSexPrice() {
        return cPercentSexPrice;
    }

    public void setcPercentSexPrice(String cPercentSexPrice) {
        this.cPercentSexPrice = cPercentSexPrice == null ? null : cPercentSexPrice.trim();
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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
}