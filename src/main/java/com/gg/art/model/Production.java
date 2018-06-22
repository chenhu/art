package com.gg.art.model;

import java.math.BigDecimal;
import java.util.Date;

public class Production {
    private Integer id;

    private Byte property;

    private String name;

    private Integer authorId;

    private BigDecimal purchasingPrice;

    private BigDecimal sellingPrice;

    private Integer supplyChannels;

    private Integer makeTime;

    private Integer purchasingTime;

    private Integer sellingTime;

    private Date addTime;

    private Byte isSelled;

    private String image;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Byte getProperty() {
        return property;
    }

    public void setProperty(Byte property) {
        this.property = property;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public BigDecimal getPurchasingPrice() {
        return purchasingPrice;
    }

    public void setPurchasingPrice(BigDecimal purchasingPrice) {
        this.purchasingPrice = purchasingPrice;
    }

    public BigDecimal getSellingPrice() {
        return sellingPrice;
    }

    public void setSellingPrice(BigDecimal sellingPrice) {
        this.sellingPrice = sellingPrice;
    }

    public Integer getSupplyChannels() {
        return supplyChannels;
    }

    public void setSupplyChannels(Integer supplyChannels) {
        this.supplyChannels = supplyChannels;
    }

    public Integer getMakeTime() {
        return makeTime;
    }

    public void setMakeTime(Integer makeTime) {
        this.makeTime = makeTime;
    }

    public Integer getPurchasingTime() {
        return purchasingTime;
    }

    public void setPurchasingTime(Integer purchasingTime) {
        this.purchasingTime = purchasingTime;
    }

    public Integer getSellingTime() {
        return sellingTime;
    }

    public void setSellingTime(Integer sellingTime) {
        this.sellingTime = sellingTime;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    public Byte getIsSelled() {
        return isSelled;
    }

    public void setIsSelled(Byte isSelled) {
        this.isSelled = isSelled;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}