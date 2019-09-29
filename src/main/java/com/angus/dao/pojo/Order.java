package com.angus.dao.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class Order {

    private Integer id;

    private String orderNumber;

    private String orderName;

    //下单日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    //服务项目
    private String serviceProject;

    private Integer charge;

    //到款情况
    private String moneySituation;

    //服务状态
    private String serviceStatus;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getServiceProject() {
        return serviceProject;
    }

    public void setServiceProject(String serviceProject) {
        this.serviceProject = serviceProject;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public String getServiceStatus() {
        return serviceStatus;
    }

    public void setServiceStatus(String serviceStatus) {
        this.serviceStatus = serviceStatus;
    }

    public String getMoneySituation() {
        return moneySituation;
    }

    public void setMoneySituation(String moneySituation) {
        this.moneySituation = moneySituation;
    }

    public String getOrderName ()
    {
        return orderName;
    }

    public void setOrderName (String orderName)
    {
        this.orderName = orderName;
    }
}
