package com.angus.dao.pojo;

public class Customer {

    private Integer customerId;

    private String name;

    //行业
    private String business;

    private String linkMan;

    private String phoneNumber;

    private String email;

    //地区
    private String district;

    //合作状态
    private String cooperationStatus;

    //客户归属
    private String customerBelong;

    //客户类型
    private String customerType;

    //业务类型
    private String serviceType;

    //跟进记录
    private String followRecord;

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBusiness() {
        return business;
    }

    public void setBusiness(String business) {
        this.business = business;
    }

    public String getLinkMan() {
        return linkMan;
    }

    public void setLinkMan(String linkMan) {
        this.linkMan = linkMan;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getCooperationStatus() {
        return cooperationStatus;
    }

    public void setCooperationStatus(String cooperationStatus) {
        this.cooperationStatus = cooperationStatus;
    }

    public String getCustomerBelong() {
        return customerBelong;
    }

    public void setCustomerBelong(String customerBelong) {
        this.customerBelong = customerBelong;
    }

    public String getCustomerType() {
        return customerType;
    }

    public void setCustomerType(String customerType) {
        this.customerType = customerType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getFollowRecord() {
        return followRecord;
    }

    public void setFollowRecord(String followRecord) {
        this.followRecord = followRecord;
    }
}
