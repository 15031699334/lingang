package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Description 卷价趋势
 * @Author dongxiangwei
 * @Date 16:04 2020/3/27
 **/
public class VolumePriceTrend {
    private Integer id;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date vptCreateTime;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date vptLastUpdateTime;

    private Double vptPrice;

    private String vptTypeName;

    @JsonFormat(pattern = "MM-dd", timezone = "GMT+8")
    private Date vptTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getVptCreateTime() {
        return vptCreateTime;
    }

    public void setVptCreateTime(Date vptCreateTime) {
        this.vptCreateTime = vptCreateTime;
    }

    public Date getVptLastUpdateTime() {
        return vptLastUpdateTime;
    }

    public void setVptLastUpdateTime(Date vptLastUpdateTime) {
        this.vptLastUpdateTime = vptLastUpdateTime;
    }

    public Double getVptPrice() {
        return vptPrice;
    }

    public void setVptPrice(Double vptPrice) {
        this.vptPrice = vptPrice;
    }

    public String getVptTypeName() {
        return vptTypeName;
    }

    public void setVptTypeName(String vptTypeName) {
        this.vptTypeName = vptTypeName == null ? null : vptTypeName.trim();
    }

    public Date getVptTime() {
        return vptTime;
    }

    public void setVptTime(Date vptTime) {
        this.vptTime = vptTime;
    }
}