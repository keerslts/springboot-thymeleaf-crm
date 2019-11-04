package com.angus.dao.pojo;

import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

public class Order {

    private Integer orderId;

    private String orderEncode;

    private Integer orderNumber;

    //下单日期
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date orderDate;

    private String orderName;

    //下单类型
    private String orderType;

    //业务类型
    private String serviceType;

    //承接实验室
    private String receiveLabor;

    //特殊要求或注意点
    private String specialRequest;

    //收费金额（含税）
    private Integer charge;

    //优惠条件
    private String cheapCondition;

    //实际下单金额（含税）
    private Integer realCharge;

    //已到账金额
    private Integer  accountCharge;

    //尾款
    private Integer tailCharge;

    //常化所成本
    private Integer CHCost;

    //联泓所成本
    private Integer LHCost;

    //委外所成本
    private Integer WWCost;

    //项目进展
    private String projectProcess;

    //其他说明
    private String otherRemark;

    //样品名称
    private String exampleName;

    //测试项目
    private String testProject;

    //负责工程师
    private String dutyProjector;

    //发票状态
    private String ticketStatus;

    //销售负责
    private String salePerson;

    //毛利
    private Integer calculateCharge;

    public Integer getCalculateCharge() {
        return calculateCharge;
    }

    public void setCalculateCharge(Integer calculateCharge) {
        this.calculateCharge = calculateCharge;
    }

    public String getExampleName() {
        return exampleName;
    }

    public void setExampleName(String exampleName) {
        this.exampleName = exampleName;
    }

    public String getTestProject() {
        return testProject;
    }

    public void setTestProject(String testProject) {
        this.testProject = testProject;
    }

    public String getDutyProjector() {
        return dutyProjector;
    }

    public void setDutyProjector(String dutyProjector) {
        this.dutyProjector = dutyProjector;
    }

    public String getTicketStatus() {
        return ticketStatus;
    }

    public void setTicketStatus(String ticketStatus) {
        this.ticketStatus = ticketStatus;
    }

    public String getSalePerson() {
        return salePerson;
    }

    public void setSalePerson(String salePerson) {
        this.salePerson = salePerson;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderEncode() {
        return orderEncode;
    }

    public void setOrderEncode(String orderEncode) {
        this.orderEncode = orderEncode;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getReceiveLabor() {
        return receiveLabor;
    }

    public void setReceiveLabor(String receiveLabor) {
        this.receiveLabor = receiveLabor;
    }

    public String getSpecialRequest() {
        return specialRequest;
    }

    public void setSpecialRequest(String specialRequest) {
        this.specialRequest = specialRequest;
    }

    public Integer getCharge() {
        return charge;
    }

    public void setCharge(Integer charge) {
        this.charge = charge;
    }

    public String getCheapCondition() {
        return cheapCondition;
    }

    public void setCheapCondition(String cheapCondition) {
        this.cheapCondition = cheapCondition;
    }

    public Integer getRealCharge() {
        return realCharge;
    }

    public void setRealCharge(Integer realCharge) {
        this.realCharge = realCharge;
    }

    public Integer getAccountCharge() {
        return accountCharge;
    }

    public void setAccountCharge(Integer accountCharge) {
        this.accountCharge = accountCharge;
    }

    public Integer getTailCharge() {
        return tailCharge;
    }

    public void setTailCharge(Integer tailCharge) {
        this.tailCharge = tailCharge;
    }

    public Integer getCHCost() {
        return CHCost;
    }

    public void setCHCost(Integer CHCost) {
        this.CHCost = CHCost;
    }

    public Integer getLHCost() {
        return LHCost;
    }

    public void setLHCost(Integer LHCost) {
        this.LHCost = LHCost;
    }

    public Integer getWWCost() {
        return WWCost;
    }

    public void setWWCost(Integer WWCost) {
        this.WWCost = WWCost;
    }

    public String getProjectProcess() {
        return projectProcess;
    }

    public void setProjectProcess(String projectProcess) {
        this.projectProcess = projectProcess;
    }

    public String getOtherRemark() {
        return otherRemark;
    }

    public void setOtherRemark(String otherRemark) {
        this.otherRemark = otherRemark;
    }
}
