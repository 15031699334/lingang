package com.boot.gang.entity;

import java.util.Date;

public class Feedback {
    private String cId;

    private String cContent;

    private Date cCreatetime;

    private String cImages;

    private Date cLastupdatetime;

    private String cMsg;

    private String cRealname;

    private Integer cStatus;

    private String cUserid;

    public Feedback(String cId, String cContent, Date cCreatetime, String cImages, Date cLastupdatetime, String cMsg, String cRealname, Integer cStatus, String cUserid) {
        this.cId = cId;
        this.cContent = cContent;
        this.cCreatetime = cCreatetime;
        this.cImages = cImages;
        this.cLastupdatetime = cLastupdatetime;
        this.cMsg = cMsg;
        this.cRealname = cRealname;
        this.cStatus = cStatus;
        this.cUserid = cUserid;
    }

    public Feedback() {
        super();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcContent() {
        return cContent;
    }

    public void setcContent(String cContent) {
        this.cContent = cContent == null ? null : cContent.trim();
    }

    public Date getcCreatetime() {
        return cCreatetime;
    }

    public void setcCreatetime(Date cCreatetime) {
        this.cCreatetime = cCreatetime;
    }

    public String getcImages() {
        return cImages;
    }

    public void setcImages(String cImages) {
        this.cImages = cImages == null ? null : cImages.trim();
    }

    public Date getcLastupdatetime() {
        return cLastupdatetime;
    }

    public void setcLastupdatetime(Date cLastupdatetime) {
        this.cLastupdatetime = cLastupdatetime;
    }

    public String getcMsg() {
        return cMsg;
    }

    public void setcMsg(String cMsg) {
        this.cMsg = cMsg == null ? null : cMsg.trim();
    }

    public String getcRealname() {
        return cRealname;
    }

    public void setcRealname(String cRealname) {
        this.cRealname = cRealname == null ? null : cRealname.trim();
    }

    public Integer getcStatus() {
        return cStatus;
    }

    public void setcStatus(Integer cStatus) {
        this.cStatus = cStatus;
    }

    public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid == null ? null : cUserid.trim();
    }
}