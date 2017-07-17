package com.shandaxueyuan.bean;

import java.util.Date;

public class ProductOdBean {
    private int id;

    private String title;

    private String model;

    private int status;

    private String version;

    private Date addTime;

    private Date updateTime;

    public ProductOdBean() {
    }

    public ProductOdBean(ProductPddBean productPddBean){
        this.id = productPddBean.getId();
        this.title = productPddBean.getTitle();
        this.model = productPddBean.getModel();
        this.status = productPddBean.getStatus();
        this.version = productPddBean.getVersion();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model == null ? null : model.trim();
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version == null ? null : version.trim();
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}