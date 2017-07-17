package com.shandaxueyuan.bean;

import java.util.Date;

public class NodePddBean {
    private int id;

    private String title;

    private int prodId;

    private int classification;

    private int detailId;

    private int parentId;

    private int sequence;

    private int depth;

    private Boolean isBom;

    private Boolean isOdBom;

    private int status;

    private Date addTime;

    private Date updateTime;

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

    public int getProdId() {
        return prodId;
    }

    public void setProdId(int prodId) {
        this.prodId = prodId;
    }

    public int getClassification() {
        return classification;
    }

    public void setClassification(int classification) {
        this.classification = classification;
    }

    public int getDetailId() {
        return detailId;
    }

    public void setDetailId(int detailId) {
        this.detailId = detailId;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public int getSequence() {
        return sequence;
    }

    public void setSequence(int sequence) {
        this.sequence = sequence;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public Boolean getIsBom() {
        return isBom;
    }

    public void setIsBom(Boolean isBom) {
        this.isBom = isBom;
    }

    public Boolean getIsOdBom() {
        return isOdBom;
    }

    public void setIsOdBom(Boolean isOdBom) {
        this.isOdBom = isOdBom;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
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

    public NodePddBean() {
    }

    public NodePddBean(NodePddBean copiedNode) {

        this.title = copiedNode.getTitle();
        this.prodId = copiedNode.getProdId();
        this.classification = copiedNode.getClassification();
        this.detailId = copiedNode.getDetailId();
        this.parentId = copiedNode.getParentId();
        this.sequence = copiedNode.getSequence();
        this.depth = copiedNode.getDepth();
        this.isOdBom = copiedNode.getIsOdBom();
    }
}