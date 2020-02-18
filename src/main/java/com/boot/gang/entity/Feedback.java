package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Feedback {
    private String cId;

    private String cContent;    // 反馈内容

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cCreatetime;

    private String cImages;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date cLastupdatetime;

    private String cMsg;        // 反馈备注

    private String cRealname;       // 姓名

    private Integer cStatus;

    private String cUserid;

    private String cReplymsg;      // 客户回复信息

    public Feedback(String cId, String cContent, Date cCreatetime, String cImages, Date cLastupdatetime, String cMsg, String cRealname, Integer cStatus, String cUserid, String cReplymsg) {
        this.cId = cId;
        this.cContent = cContent;
        this.cCreatetime = cCreatetime;
        this.cImages = cImages;
        this.cLastupdatetime = cLastupdatetime;
        this.cMsg = cMsg;
        this.cRealname = cRealname;
        this.cStatus = cStatus;
        this.cUserid = cUserid;
        this.cReplymsg = cReplymsg;
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

    public String getcReplymsg() {
        return cReplymsg;
    }

    public void setcReplymsg(String cReplymsg) {
        this.cReplymsg = cReplymsg;
    }
}