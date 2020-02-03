package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class IntegralDetail {
    private String iId;     // id

    private Double iChangeintegral;     // 改变的数量

    private Integer iChangetype;        // 变化状态 0=减少 1=增加

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date iCreatetime;       // 添加时间

    private Double iNowintegral;      // 变化后的数量

    private String iOrderno;            // 订单号  默认:'否'

    private String iRealname;           // 用户真实姓名

    private String iUserid;             // 用户id

    private String iReason;             // 原因(备注)

    private Integer iIntegraltype;   // 1= 钢豆 2= 茅台ml数 3=五粮液

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

    @Override
    public String toString() {
        return "IntegralDetail{" + "iId='" + iId + '\'' + ", iChangeintegral=" + iChangeintegral + ", iChangetype=" + iChangetype + ", iCreatetime=" + iCreatetime + ", iNowintegral=" + iNowintegral + ", iOrderno='" + iOrderno + '\'' + ", iRealname='" + iRealname + '\'' + ", iUserid='" + iUserid + '\'' + ", iReason='" + iReason + '\'' + ", iIntegraltype=" + iIntegraltype + '}';
    }
}