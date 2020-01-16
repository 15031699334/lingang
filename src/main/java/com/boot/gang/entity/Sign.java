package com.boot.gang.entity;

import java.util.Date;

public class Sign {
    private Integer id;

    private String userId;

    private Integer cntDays;

    private Date lastSignTime;

    private Integer douDay;

    public Sign(Integer id, String userId, Integer cntDays, Date lastSignTime) {
        this.id = id;
        this.userId = userId;
        this.cntDays = cntDays;
        this.lastSignTime = lastSignTime;
    }

    public Sign(String userId, Integer cntDays, Date lastSignTime) {
        this.userId = userId;
        this.cntDays = cntDays;
        this.lastSignTime = lastSignTime;
    }

    public Sign() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getCntDays() {
        return cntDays;
    }

    public void setCntDays(Integer cntDays) {
        this.cntDays = cntDays;
    }

    public Date getLastSignTime() {
        return lastSignTime;
    }

    public void setLastSignTime(Date lastSignTime) {
        this.lastSignTime = lastSignTime;
    }

    public Integer getDouDay() {
        return douDay;
    }

    public void setDouDay(Integer douDay) {
        this.douDay = douDay;
    }

    @Override
    public String toString() {
        return "Sign{" +
                "id=" + id +
                ", userId=" + userId +
                ", cntDays=" + cntDays +
                ", lastSignTime=" + lastSignTime +
                '}';
    }
}