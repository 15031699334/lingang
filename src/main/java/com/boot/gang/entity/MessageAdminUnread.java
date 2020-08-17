package com.boot.gang.entity;

import java.util.Date;

public class MessageAdminUnread {
    private Integer auId;

    private String auAdminNo;

    private Date auCreateTime;

    private String auUserId;

    public Integer getAuId() {
        return auId;
    }

    public void setAuId(Integer auId) {
        this.auId = auId;
    }

    public String getAuAdminNo() {
        return auAdminNo;
    }

    public void setAuAdminNo(String auAdminNo) {
        this.auAdminNo = auAdminNo == null ? null : auAdminNo.trim();
    }

    public Date getAuCreateTime() {
        return auCreateTime;
    }

    public void setAuCreateTime(Date auCreateTime) {
        this.auCreateTime = auCreateTime;
    }

    public String getAuUserId() {
        return auUserId;
    }

    public void setAuUserId(String auUserId) {
        this.auUserId = auUserId == null ? null : auUserId.trim();
    }
}