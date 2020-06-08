package com.boot.gang.entity;

import java.util.Date;

public class Admin {
    private String cId;

    private String cBlockId;

    private String cCityId;

    private Date cCreateTime;

    private String cCreateUser;

    private String cDistrictId;

    private Date cLastUpdateTime;

    private String cLastUpdateUser;

    private String cProvinceId;

    private String cPassword;

    private String cUsername;

    private String cHide;

    private String cPhone;

    private String cPhoto;

    private String cQqnum;

    private String adminname;

    private String adminno;

    private String adminpic;

    private Integer receivemessage;

    private String role;

    private String cMenuStr;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcBlockId() {
        return cBlockId;
    }

    public void setcBlockId(String cBlockId) {
        this.cBlockId = cBlockId == null ? null : cBlockId.trim();
    }

    public String getcCityId() {
        return cCityId;
    }

    public void setcCityId(String cCityId) {
        this.cCityId = cCityId == null ? null : cCityId.trim();
    }

    public Date getcCreateTime() {
        return cCreateTime;
    }

    public void setcCreateTime(Date cCreateTime) {
        this.cCreateTime = cCreateTime;
    }

    public String getcCreateUser() {
        return cCreateUser;
    }

    public void setcCreateUser(String cCreateUser) {
        this.cCreateUser = cCreateUser == null ? null : cCreateUser.trim();
    }

    public String getcDistrictId() {
        return cDistrictId;
    }

    public void setcDistrictId(String cDistrictId) {
        this.cDistrictId = cDistrictId == null ? null : cDistrictId.trim();
    }

    public Date getcLastUpdateTime() {
        return cLastUpdateTime;
    }

    public void setcLastUpdateTime(Date cLastUpdateTime) {
        this.cLastUpdateTime = cLastUpdateTime;
    }

    public String getcLastUpdateUser() {
        return cLastUpdateUser;
    }

    public void setcLastUpdateUser(String cLastUpdateUser) {
        this.cLastUpdateUser = cLastUpdateUser == null ? null : cLastUpdateUser.trim();
    }

    public String getcProvinceId() {
        return cProvinceId;
    }

    public void setcProvinceId(String cProvinceId) {
        this.cProvinceId = cProvinceId == null ? null : cProvinceId.trim();
    }

    public String getcPassword() {
        return cPassword;
    }

    public void setcPassword(String cPassword) {
        this.cPassword = cPassword == null ? null : cPassword.trim();
    }

    public String getcUsername() {
        return cUsername;
    }

    public void setcUsername(String cUsername) {
        this.cUsername = cUsername == null ? null : cUsername.trim();
    }

    public String getcHide() {
        return cHide;
    }

    public void setcHide(String cHide) {
        this.cHide = cHide == null ? null : cHide.trim();
    }

    public String getcPhone() {
        return cPhone;
    }

    public void setcPhone(String cPhone) {
        this.cPhone = cPhone == null ? null : cPhone.trim();
    }

    public String getcPhoto() {
        return cPhoto;
    }

    public void setcPhoto(String cPhoto) {
        this.cPhoto = cPhoto == null ? null : cPhoto.trim();
    }

    public String getcQqnum() {
        return cQqnum;
    }

    public void setcQqnum(String cQqnum) {
        this.cQqnum = cQqnum == null ? null : cQqnum.trim();
    }

    public String getAdminname() {
        return adminname;
    }

    public void setAdminname(String adminname) {
        this.adminname = adminname == null ? null : adminname.trim();
    }

    public String getAdminno() {
        return adminno;
    }

    public void setAdminno(String adminno) {
        this.adminno = adminno == null ? null : adminno.trim();
    }

    public String getAdminpic() {
        return adminpic;
    }

    public void setAdminpic(String adminpic) {
        this.adminpic = adminpic == null ? null : adminpic.trim();
    }

    public Integer getReceivemessage() {
        return receivemessage;
    }

    public void setReceivemessage(Integer receivemessage) {
        this.receivemessage = receivemessage;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getcMenuStr() {
        return cMenuStr;
    }

    public void setcMenuStr(String cMenuStr) {
        this.cMenuStr = cMenuStr == null ? null : cMenuStr.trim();
    }
}