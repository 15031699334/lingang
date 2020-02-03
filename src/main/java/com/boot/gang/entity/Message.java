package com.boot.gang.entity;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {

    private static final long serialVersionUID = -6227040332527483184L;
    private Integer id;

    private Date createtime;

    private Date lastupdatetime;

    private String adminname;

    private String adminno;

    private String adminpic;

    private Integer recruitinfoid;

    private Integer state;

    private String summary;

    private String userid;

    private String username;

    private String userpic;

    private int messageType;

    public Message(Integer id, Date createtime, Date lastupdatetime, String adminname, String adminno, String adminpic, Integer recruitinfoid, Integer state, String summary, String userid, String username, String userpic, int messageType) {
        this.id = id;
        this.createtime = createtime;
        this.lastupdatetime = lastupdatetime;
        this.adminname = adminname;
        this.adminno = adminno;
        this.adminpic = adminpic;
        this.recruitinfoid = recruitinfoid;
        this.state = state;
        this.summary = summary;
        this.userid = userid;
        this.username = username;
        this.userpic = userpic;
        this.messageType = messageType;
    }

    public Message() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public Date getLastupdatetime() {
        return lastupdatetime;
    }

    public void setLastupdatetime(Date lastupdatetime) {
        this.lastupdatetime = lastupdatetime;
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

    public Integer getRecruitinfoid() {
        return recruitinfoid;
    }

    public void setRecruitinfoid(Integer recruitinfoid) {
        this.recruitinfoid = recruitinfoid;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpic() {
        return userpic;
    }

    public void setUserpic(String userpic) {
        this.userpic = userpic == null ? null : userpic.trim();
    }

    public int getMessageType() {
        return messageType;
    }

    public void setMessageType(int messageType) {
        this.messageType = messageType;
    }
}