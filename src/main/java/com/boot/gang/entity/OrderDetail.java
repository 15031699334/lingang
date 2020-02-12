package com.boot.gang.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class OrderDetail {
    private String dId;             // 详情id

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Date dCreatetime;       // 添加时间

    private String dOrderno;        // 订单号

    private Double dProcessprice;    // 加工费用

    private String dProcessrequirement;     // 加工要求

    private String dProcessway;         // 加工方式

    private String dProductid;          //      商品id

    private String dProductnum;         // 商品数量

    private String dProductspec;        // 商品规格

    private String dProducttexture;     // 材质

    private String dShopcolumntype;     // 商品类别名称

    private String dShopcolumntypeid;       // 类别id

    private String dShopid;             // 所属厂商id

    private String dShopname;           // 厂家名称

    private String dTonnum;             // 吨数

    private Double dPrnPrice;           // 商品单价

    private Double dPrice;              // 价格 单价    (后台可修改)

    private String dStorename;          // 仓库名称

    private String dExtract;            // 提货信息

    public OrderDetail(String dId, Date dCreatetime, String dOrderno, Double dProcessprice, String dProcessrequirement, String dProcessway, String dProductid, String dProductnum, String dProductspec, String dProducttexture, String dShopcolumntype, String dShopcolumntypeid, String dShopid, String dShopname, String dTonnum, Double dPrnPrice, Double dPrice, String dStorename, String dExtract) {
        this.dId = dId;
        this.dCreatetime = dCreatetime;
        this.dOrderno = dOrderno;
        this.dProcessprice = dProcessprice;
        this.dProcessrequirement = dProcessrequirement;
        this.dProcessway = dProcessway;
        this.dProductid = dProductid;
        this.dProductnum = dProductnum;
        this.dProductspec = dProductspec;
        this.dProducttexture = dProducttexture;
        this.dShopcolumntype = dShopcolumntype;
        this.dShopcolumntypeid = dShopcolumntypeid;
        this.dShopid = dShopid;
        this.dShopname = dShopname;
        this.dTonnum = dTonnum;
        this.dPrnPrice = dPrnPrice;
        this.dPrice = dPrice;
        this.dStorename = dStorename;
        this.dExtract = dExtract;
    }

    public OrderDetail() {
        super();
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId == null ? null : dId.trim();
    }

    public Date getdCreatetime() {
        return dCreatetime;
    }

    public void setdCreatetime(Date dCreatetime) {
        this.dCreatetime = dCreatetime;
    }

    public String getdOrderno() {
        return dOrderno;
    }

    public void setdOrderno(String dOrderno) {
        this.dOrderno = dOrderno == null ? null : dOrderno.trim();
    }

    public Double getdProcessprice() {
        return dProcessprice;
    }

    public void setdProcessprice(Double dProcessprice) {
        this.dProcessprice = dProcessprice;
    }

    public String getdProcessrequirement() {
        return dProcessrequirement;
    }

    public void setdProcessrequirement(String dProcessrequirement) {
        this.dProcessrequirement = dProcessrequirement == null ? null : dProcessrequirement.trim();
    }

    public String getdProcessway() {
        return dProcessway;
    }

    public void setdProcessway(String dProcessway) {
        this.dProcessway = dProcessway;
    }

    public String getdProductid() {
        return dProductid;
    }

    public void setdProductid(String dProductid) {
        this.dProductid = dProductid == null ? null : dProductid.trim();
    }

    public String getdProductnum() {
        return dProductnum;
    }

    public void setdProductnum(String dProductnum) {
        this.dProductnum = dProductnum == null ? null : dProductnum.trim();
    }

    public String getdProductspec() {
        return dProductspec;
    }

    public void setdProductspec(String dProductspec) {
        this.dProductspec = dProductspec == null ? null : dProductspec.trim();
    }

    public String getdProducttexture() {
        return dProducttexture;
    }

    public void setdProducttexture(String dProducttexture) {
        this.dProducttexture = dProducttexture == null ? null : dProducttexture.trim();
    }

    public String getdShopcolumntype() {
        return dShopcolumntype;
    }

    public void setdShopcolumntype(String dShopcolumntype) {
        this.dShopcolumntype = dShopcolumntype == null ? null : dShopcolumntype.trim();
    }

    public String getdShopcolumntypeid() {
        return dShopcolumntypeid;
    }

    public void setdShopcolumntypeid(String dShopcolumntypeid) {
        this.dShopcolumntypeid = dShopcolumntypeid == null ? null : dShopcolumntypeid.trim();
    }

    public String getdShopid() {
        return dShopid;
    }

    public void setdShopid(String dShopid) {
        this.dShopid = dShopid == null ? null : dShopid.trim();
    }

    public String getdShopname() {
        return dShopname;
    }

    public void setdShopname(String dShopname) {
        this.dShopname = dShopname == null ? null : dShopname.trim();
    }

    public String getdTonnum() {
        return dTonnum;
    }

    public void setdTonnum(String dTonnum) {
        this.dTonnum = dTonnum == null ? null : dTonnum.trim();
    }

    public Double getdPrnPrice() {
        return dPrnPrice;
    }

    public void setdPrnPrice(Double dPrnPrice) {
        this.dPrnPrice = dPrnPrice;
    }

    public Double getdPrice() {
        return dPrice;
    }

    public void setdPrice(Double dPrice) {
        this.dPrice = dPrice;
    }

    public String getdStorename() {
        return dStorename;
    }

    public void setdStorename(String dStorename) {
        this.dStorename = dStorename;
    }

    public String getdExtract() {
        return dExtract;
    }

    public void setdExtract(String dExtract) {
        this.dExtract = dExtract;
    }

    @Override
    public String toString() {
        return "OrderDetail{" +
                "dId='" + dId + '\'' +
                ", dCreatetime=" + dCreatetime +
                ", dOrderno='" + dOrderno + '\'' +
                ", dProcessprice=" + dProcessprice +
                ", dProcessrequirement='" + dProcessrequirement + '\'' +
                ", dProductid='" + dProductid + '\'' +
                ", dProductnum='" + dProductnum + '\'' +
                ", dProductspec='" + dProductspec + '\'' +
                ", dProducttexture='" + dProducttexture + '\'' +
                ", dShopcolumntype='" + dShopcolumntype + '\'' +
                ", dShopcolumntypeid='" + dShopcolumntypeid + '\'' +
                ", dShopid='" + dShopid + '\'' +
                ", dShopname='" + dShopname + '\'' +
                ", dTonnum='" + dTonnum + '\'' +
                ", dPrice=" + dPrice +
                ", dStorename=" + dStorename +
                '}';
    }
}