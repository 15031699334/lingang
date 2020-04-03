package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderPreorder {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date opCreateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date opLastUpdateTime;

    private Double opPrice;

    private String opPrnId;

    private String opPrnName;

    private String opRealName;

    private String opSpec;

    private String opTexttrue;

    private String opUserId;

    private Integer opStatus;

    private String opPhone;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getOpCreateTime() {
        return opCreateTime;
    }

    public void setOpCreateTime(Date opCreateTime) {
        this.opCreateTime = opCreateTime;
    }

    public Date getOpLastUpdateTime() {
        return opLastUpdateTime;
    }

    public void setOpLastUpdateTime(Date opLastUpdateTime) {
        this.opLastUpdateTime = opLastUpdateTime;
    }

    public Double getOpPrice() {
        return opPrice;
    }

    public void setOpPrice(Double opPrice) {
        this.opPrice = opPrice;
    }

    public String getOpPrnId() {
        return opPrnId;
    }

    public void setOpPrnId(String opPrnId) {
        this.opPrnId = opPrnId == null ? null : opPrnId.trim();
    }

    public String getOpPrnName() {
        return opPrnName;
    }

    public void setOpPrnName(String opPrnName) {
        this.opPrnName = opPrnName == null ? null : opPrnName.trim();
    }

    public String getOpRealName() {
        return opRealName;
    }

    public void setOpRealName(String opRealName) {
        this.opRealName = opRealName == null ? null : opRealName.trim();
    }

    public String getOpSpec() {
        return opSpec;
    }

    public void setOpSpec(String opSpec) {
        this.opSpec = opSpec == null ? null : opSpec.trim();
    }

    public String getOpTexttrue() {
        return opTexttrue;
    }

    public void setOpTexttrue(String opTexttrue) {
        this.opTexttrue = opTexttrue == null ? null : opTexttrue.trim();
    }

    public String getOpUserId() {
        return opUserId;
    }

    public void setOpUserId(String opUserId) {
        this.opUserId = opUserId == null ? null : opUserId.trim();
    }

    public Integer getOpStatus() {
        return opStatus;
    }

    public void setOpStatus(Integer opStatus) {
        this.opStatus = opStatus;
    }

    public String getOpPhone() {
        return opPhone;
    }

    public void setOpPhone(String opPhone) {
        this.opPhone = opPhone == null ? null : opPhone.trim();
    }
}