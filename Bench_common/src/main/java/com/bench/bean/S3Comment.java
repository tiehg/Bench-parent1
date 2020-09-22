package com.bench.bean;

public class S3Comment {
    private Integer id;

    private String conent;

    private Integer uid;

    private Integer aid;

    private String isadoption;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getConent() {
        return conent;
    }

    public void setConent(String conent) {
        this.conent = conent == null ? null : conent.trim();
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getIsadoption() {
        return isadoption;
    }

    public void setIsadoption(String isadoption) {
        this.isadoption = isadoption == null ? null : isadoption.trim();
    }
}