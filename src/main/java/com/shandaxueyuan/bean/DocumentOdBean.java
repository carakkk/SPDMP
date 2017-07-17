package com.shandaxueyuan.bean;

import java.util.Date;

public class DocumentOdBean {
    private Integer id;

    private Integer nodeId;

    private String title;

    private Integer sequence;

    private Integer status;

    private Date addTime;

    private Date updateTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNodeId() {
        return nodeId;
    }

    public void setNodeId(Integer nodeId) {
        this.nodeId = nodeId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public Integer getSequence() {
        return sequence;
    }

    public void setSequence(Integer sequence) {
        this.sequence = sequence;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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

    public DocumentOdBean(DocumentPddBean documentPddBean) {
        this.id = documentPddBean.getId();
        this.nodeId = documentPddBean.getNodeId();
        this.title = documentPddBean.getTitle();
        this.sequence = documentPddBean.getSequence();
        this.status = documentPddBean.getStatus();
    }

    public DocumentOdBean() {

    }
}