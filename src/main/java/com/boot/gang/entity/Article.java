package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Article {
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

    private String cArticleType;

    private String cCreateUserId;

    private Integer cIfApprover;

    private String cLogo;

    private Integer cRecommend;

    private String cShopId;

    private Integer cSort;

    private String cSummary;

    private String cTitle;

    private Integer cTop;

    private Integer cType;

    private String cUrl;

    private String cChl;

    private String cChlId;

    private String cHide;

    private String cArticleName;

    private String cChlidName;

    private String cChlName;

    private String cTags;

    private Date cEndDate;

    private String cShopName;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cBeginDate;

    private Integer cClicks;

    private Integer cHits;

    private Integer cShares;

    private String cShopColumnId;

    private String cShopColumnName;

    private String cContent;

    public Article(String cId, String cBlockId, String cCityId, Date cCreateTime, String cCreateUser, String cDistrictId, Date cLastUpdateTime, String cLastUpdateUser, String cProvinceId, String cArticleType, String cCreateUserId, Integer cIfApprover, String cLogo, Integer cRecommend, String cShopId, Integer cSort, String cSummary, String cTitle, Integer cTop, Integer cType, String cUrl, String cChl, String cChlId, String cHide, String cArticleName, String cChlidName, String cChlName, String cTags, Date cEndDate, String cShopName, Date cBeginDate, Integer cClicks, Integer cHits, Integer cShares, String cShopColumnId, String cShopColumnName, String cContent) {
        this.cId = cId;
        this.cBlockId = cBlockId;
        this.cCityId = cCityId;
        this.cCreateTime = cCreateTime;
        this.cCreateUser = cCreateUser;
        this.cDistrictId = cDistrictId;
        this.cLastUpdateTime = cLastUpdateTime;
        this.cLastUpdateUser = cLastUpdateUser;
        this.cProvinceId = cProvinceId;
        this.cArticleType = cArticleType;
        this.cCreateUserId = cCreateUserId;
        this.cIfApprover = cIfApprover;
        this.cLogo = cLogo;
        this.cRecommend = cRecommend;
        this.cShopId = cShopId;
        this.cSort = cSort;
        this.cSummary = cSummary;
        this.cTitle = cTitle;
        this.cTop = cTop;
        this.cType = cType;
        this.cUrl = cUrl;
        this.cChl = cChl;
        this.cChlId = cChlId;
        this.cHide = cHide;
        this.cArticleName = cArticleName;
        this.cChlidName = cChlidName;
        this.cChlName = cChlName;
        this.cTags = cTags;
        this.cEndDate = cEndDate;
        this.cShopName = cShopName;
        this.cBeginDate = cBeginDate;
        this.cClicks = cClicks;
        this.cHits = cHits;
        this.cShares = cShares;
        this.cShopColumnId = cShopColumnId;
        this.cShopColumnName = cShopColumnName;
        this.cContent = cContent;
    }

    public Article() {
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

    public String getcArticleType() {
        return cArticleType;
    }

    public void setcArticleType(String cArticleType) {
        this.cArticleType = cArticleType == null ? null : cArticleType.trim();
    }

    public String getcCreateUserId() {
        return cCreateUserId;
    }

    public void setcCreateUserId(String cCreateUserId) {
        this.cCreateUserId = cCreateUserId == null ? null : cCreateUserId.trim();
    }

    public Integer getcIfApprover() {
        return cIfApprover;
    }

    public void setcIfApprover(Integer cIfApprover) {
        this.cIfApprover = cIfApprover;
    }

    public String getcLogo() {
        return cLogo;
    }

    public void setcLogo(String cLogo) {
        this.cLogo = cLogo == null ? null : cLogo.trim();
    }

    public Integer getcRecommend() {
        return cRecommend;
    }

    public void setcRecommend(Integer cRecommend) {
        this.cRecommend = cRecommend;
    }

    public String getcShopId() {
        return cShopId;
    }

    public void setcShopId(String cShopId) {
        this.cShopId = cShopId == null ? null : cShopId.trim();
    }

    public Integer getcSort() {
        return cSort;
    }

    public void setcSort(Integer cSort) {
        this.cSort = cSort;
    }

    public String getcSummary() {
        return cSummary;
    }

    public void setcSummary(String cSummary) {
        this.cSummary = cSummary == null ? null : cSummary.trim();
    }

    public String getcTitle() {
        return cTitle;
    }

    public void setcTitle(String cTitle) {
        this.cTitle = cTitle == null ? null : cTitle.trim();
    }

    public Integer getcTop() {
        return cTop;
    }

    public void setcTop(Integer cTop) {
        this.cTop = cTop;
    }

    public Integer getcType() {
        return cType;
    }

    public void setcType(Integer cType) {
        this.cType = cType;
    }

    public String getcUrl() {
        return cUrl;
    }

    public void setcUrl(String cUrl) {
        this.cUrl = cUrl == null ? null : cUrl.trim();
    }

    public String getcChl() {
        return cChl;
    }

    public void setcChl(String cChl) {
        this.cChl = cChl == null ? null : cChl.trim();
    }

    public String getcChlId() {
        return cChlId;
    }

    public void setcChlId(String cChlId) {
        this.cChlId = cChlId == null ? null : cChlId.trim();
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public String getcArticleName() {
        return cArticleName;
    }

    public void setcArticleName(String cArticleName) {
        this.cArticleName = cArticleName == null ? null : cArticleName.trim();
    }

    public String getcChlidName() {
        return cChlidName;
    }

    public void setcChlidName(String cChlidName) {
        this.cChlidName = cChlidName == null ? null : cChlidName.trim();
    }

    public String getcChlName() {
        return cChlName;
    }

    public void setcChlName(String cChlName) {
        this.cChlName = cChlName == null ? null : cChlName.trim();
    }

    public String getcTags() {
        return cTags;
    }

    public void setcTags(String cTags) {
        this.cTags = cTags == null ? null : cTags.trim();
    }

    public Date getcEndDate() {
        return cEndDate;
    }

    public void setcEndDate(Date cEndDate) {
        this.cEndDate = cEndDate;
    }

    public String getcShopName() {
        return cShopName;
    }

    public void setcShopName(String cShopName) {
        this.cShopName = cShopName == null ? null : cShopName.trim();
    }

    public Date getcBeginDate() {
        return cBeginDate;
    }

    public void setcBeginDate(Date cBeginDate) {
        this.cBeginDate = cBeginDate;
    }

    public Integer getcClicks() {
        return cClicks;
    }

    public void setcClicks(Integer cClicks) {
        this.cClicks = cClicks;
    }

    public Integer getcHits() {
        return cHits;
    }

    public void setcHits(Integer cHits) {
        this.cHits = cHits;
    }

    public Integer getcShares() {
        return cShares;
    }

    public void setcShares(Integer cShares) {
        this.cShares = cShares;
    }

    public String getcShopColumnId() {
        return cShopColumnId;
    }

    public void setcShopColumnId(String cShopColumnId) {
        this.cShopColumnId = cShopColumnId == null ? null : cShopColumnId.trim();
    }

    public String getcShopColumnName() {
        return cShopColumnName;
    }

    public void setcShopColumnName(String cShopColumnName) {
        this.cShopColumnName = cShopColumnName == null ? null : cShopColumnName.trim();
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent == null ? null : cContent.trim();
    }
}