package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class IntegralDetail {
    private String iId;

    private Double iChangeintegral;

    private Integer iChangetype;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date iCreatetime;

    private Double iNowintegral;

    private String iOrderno;

    private String iRealname;

    private String iUserid;

    private String iReason;

    private Integer iIntegraltype;   // 1= 钢豆 2= ml

    public IntegralDetail(String iId, Double iChangeintegral, Integer iChangetype, Date iCreatetime, Double iNowintegral, String iOrderno, String iRealname, String iUserid, String iReason, Integer iIntegraltype) {
        this.iId = iId;
        this.iChangeintegral = iChangeintegral;
        this.iChangetype = iChangetype;
        this.iCreatetime = iCreatetime;
        this.iNowintegral = iNowintegral;
        this.iOrderno = iOrderno;
        this.iRealname = iRealname;
        this.iUserid = iUserid;
        this.iReason = iReason;
        this.iIntegraltype = iIntegraltype;
    }

    public IntegralDetail() {
        super();
    }

    public String getiId() {
        return iId;
    }

    public void setiId(String iId) {
        this.iId = iId == null ? null : iId.trim();
    }

    public Double getiChangeintegral() {
        return iChangeintegral;
    }

    public void setiChangeintegral(Double iChangeintegral) {
        this.iChangeintegral = iChangeintegral;
    }

    public Integer getiChangetype() {
        return iChangetype;
    }

    public void setiChangetype(Integer iChangetype) {
        this.iChangetype = iChangetype;
    }

    public Date getiCreatetime() {
        return iCreatetime;
    }

    public void setiCreatetime(Date iCreatetime) {
        this.iCreatetime = iCreatetime;
    }

    public Double getiNowintegral() {
        return iNowintegral;
    }

    public void setiNowintegral(Double iNowintegral) {
        this.iNowintegral = iNowintegral;
    }

    public String getiOrderno() {
        return iOrderno;
    }

    public void setiOrderno(String iOrderno) {
        this.iOrderno = iOrderno == null ? null : iOrderno.trim();
    }

    public String getiRealname() {
        return iRealname;
    }

    public void setiRealname(String iRealname) {
        this.iRealname = iRealname == null ? null : iRealname.trim();
    }

    public String getiUserid() {
        return iUserid;
    }

    public void setiUserid(String iUserid) {
        this.iUserid = iUserid == null ? null : iUserid.trim();
    }

    public String getiReason() {
        return iReason;
    }

    public void setiReason(String iReason) {
        this.iReason = iReason == null ? null : iReason.trim();
    }

    public Integer getiIntegraltype() {
        return iIntegraltype;
    }

    public void setiIntegraltype(Integer iIntegraltype) {
        this.iIntegraltype = iIntegraltype;
    }
}