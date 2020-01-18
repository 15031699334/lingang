package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description 成交记录表
 * @Author dongxiangwei
 * @Date 5:48 2020/1/18
 **/
public class OrderRecord {
    private String cId;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date orCreatettime;

    private String orPhone;

    private String orRealname;

    private Integer orState;

    private String orUnit;

    private String orUsername;  // 商品名

    private String orVolume;

    private String orUserid;

    public OrderRecord(String cId, Date orCreatettime, String orPhone, String orRealname, Integer orState, String orUnit, String orUsername, String orVolume, String orUserid) {
        this.cId = cId;
        this.orCreatettime = orCreatettime;
        this.orPhone = orPhone;
        this.orRealname = orRealname;
        this.orState = orState;
        this.orUnit = orUnit;
        this.orUsername = orUsername;
        this.orVolume = orVolume;
        this.orUserid = orUserid;
    }

    public OrderRecord() {
        super();
    }

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public Date getOrCreatettime() {
        return orCreatettime;
    }

    public void setOrCreatettime(Date orCreatettime) {
        this.orCreatettime = orCreatettime;
    }

    public String getOrPhone() {
        return orPhone;
    }

    public void setOrPhone(String orPhone) {
        this.orPhone = orPhone == null ? null : orPhone.trim();
    }

    public String getOrRealname() {
        return orRealname;
    }

    public void setOrRealname(String orRealname) {
        this.orRealname = orRealname == null ? null : orRealname.trim();
    }

    public Integer getOrState() {
        return orState;
    }

    public void setOrState(Integer orState) {
        this.orState = orState;
    }

    public String getOrUnit() {
        return orUnit;
    }

    public void setOrUnit(String orUnit) {
        this.orUnit = orUnit == null ? null : orUnit.trim();
    }

    public String getOrUsername() {
        return orUsername;
    }

    public void setOrUsername(String orUsername) {
        this.orUsername = orUsername == null ? null : orUsername.trim();
    }

    public String getOrVolume() {
        return orVolume;
    }

    public void setOrVolume(String orVolume) {
        this.orVolume = orVolume == null ? null : orVolume.trim();
    }

    public String getOrUserid() {
        return orUserid;
    }

    public void setOrUserid(String orUserid) {
        this.orUserid = orUserid == null ? null : orUserid.trim();
    }
}