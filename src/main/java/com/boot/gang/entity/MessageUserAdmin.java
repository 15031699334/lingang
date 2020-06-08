package com.boot.gang.entity;

import java.util.Date;

public class MessageUserAdmin {
    private String umId;

    private String umAdminId;

    private Date umCreateTime;

    private Date umLastTime;

    private Integer umStatus;

    private String umUserId;

    public MessageUserAdmin() {
    }

    public MessageUserAdmin(String umId, String umAdminId, Date umCreateTime, Date umLastTime, String umUserId) {
        this.umId = umId;
        this.umAdminId = umAdminId;
        this.umCreateTime = umCreateTime;
        this.umLastTime = umLastTime;
        this.umUserId = umUserId;
    }

    public String getUmId() {
        return umId;
    }

    public void setUmId(String umId) {
        this.umId = umId == null ? null : umId.trim();
    }

    public String getUmAdminId() {
        return umAdminId;
    }

    public void setUmAdminId(String umAdminId) {
        this.umAdminId = umAdminId == null ? null : umAdminId.trim();
    }

    public Date getUmCreateTime() {
        return umCreateTime;
    }

    public void setUmCreateTime(Date umCreateTime) {
        this.umCreateTime = umCreateTime;
    }

    public Date getUmLastTime() {
        return umLastTime;
    }

    public void setUmLastTime(Date umLastTime) {
        this.umLastTime = umLastTime;
    }

    public Integer getUmStatus() {
        return umStatus;
    }

    public void setUmStatus(Integer umStatus) {
        this.umStatus = umStatus;
    }

    public String getUmUserId() {
        return umUserId;
    }

    public void setUmUserId(String umUserId) {
        this.umUserId = umUserId == null ? null : umUserId.trim();
    }
}