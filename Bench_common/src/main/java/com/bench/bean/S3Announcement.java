package com.bench.bean;

import java.util.Date;

public class S3Announcement {
    private Integer id;

    private String conent;

    private Date time;

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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }
}