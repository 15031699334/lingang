package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class PlanShoppingReply {
    private String psrId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date psrCreateTime;

    private String psId;

    private String psExplain;

    private String psNum;

    private String psPhone;

    private String psrComment;

    private String psrPhone;

    private String psrRealname;

    private String psrUserId;

    private String psRealname;

    private String psShopColumnName;

    private String psShopname;

    private String psSpec;

    private String psTexttrue;

    private String psUnit;

    private String psUserId;

    public String getPsrId() {
        return psrId;
    }

    public void setPsrId(String psrId) {
        this.psrId = psrId == null ? null : psrId.trim();
    }

    public Date getPsrCreateTime() {
        return psrCreateTime;
    }

    public void setPsrCreateTime(Date psrCreateTime) {
        this.psrCreateTime = psrCreateTime;
    }

    public String getPsId() {
        return psId;
    }

    public void setPsId(String psId) {
        this.psId = psId;
    }

    public String getPsExplain() {
        return psExplain;
    }

    public void setPsExplain(String psExplain) {
        this.psExplain = psExplain == null ? null : psExplain.trim();
    }

    public String getPsNum() {
        return psNum;
    }

    public void setPsNum(String psNum) {
        this.psNum = psNum == null ? null : psNum.trim();
    }

    public String getPsPhone() {
        return psPhone;
    }

    public void setPsPhone(String psPhone) {
        this.psPhone = psPhone == null ? null : psPhone.trim();
    }

    public String getPsrComment() {
        return psrComment;
    }

    public void setPsrComment(String psrComment) {
        this.psrComment = psrComment == null ? null : psrComment.trim();
    }

    public String getPsrPhone() {
        return psrPhone;
    }

    public void setPsrPhone(String psrPhone) {
        this.psrPhone = psrPhone == null ? null : psrPhone.trim();
    }

    public String getPsrRealname() {
        return psrRealname;
    }

    public void setPsrRealname(String psrRealname) {
        this.psrRealname = psrRealname == null ? null : psrRealname.trim();
    }

    public String getPsrUserId() {
        return psrUserId;
    }

    public void setPsrUserId(String psrUserId) {
        this.psrUserId = psrUserId == null ? null : psrUserId.trim();
    }

    public String getPsRealname() {
        return psRealname;
    }

    public void setPsRealname(String psRealname) {
        this.psRealname = psRealname == null ? null : psRealname.trim();
    }

    public String getPsShopColumnName() {
        return psShopColumnName;
    }

    public void setPsShopColumnName(String psShopColumnName) {
        this.psShopColumnName = psShopColumnName == null ? null : psShopColumnName.trim();
    }

    public String getPsShopname() {
        return psShopname;
    }

    public void setPsShopname(String psShopname) {
        this.psShopname = psShopname == null ? null : psShopname.trim();
    }

    public String getPsSpec() {
        return psSpec;
    }

    public void setPsSpec(String psSpec) {
        this.psSpec = psSpec == null ? null : psSpec.trim();
    }

    public String getPsTexttrue() {
        return psTexttrue;
    }

    public void setPsTexttrue(String psTexttrue) {
        this.psTexttrue = psTexttrue == null ? null : psTexttrue.trim();
    }

    public String getPsUnit() {
        return psUnit;
    }

    public void setPsUnit(String psUnit) {
        this.psUnit = psUnit == null ? null : psUnit.trim();
    }

    public String getPsUserId() {
        return psUserId;
    }

    public void setPsUserId(String psUserId) {
        this.psUserId = psUserId == null ? null : psUserId.trim();
    }
}