package com.angus.util;

import java.util.ArrayList;
import java.util.HashMap;

public final class PageListMapUtil extends HashMap
{

    public final static ArrayList<String> businessList = new ArrayList<String>();
    public final static ArrayList<String> customerBelongList = new ArrayList<String>();
    public final static ArrayList<String> customerTypeList = new ArrayList<String>();
    public final static ArrayList<String> cooperationStatusList = new ArrayList<String>();
    public final static ArrayList<String> serviceTypeList = new ArrayList<String>();


    private PageListMapUtil(){


        //行业
        this.businessList.add("日化清洗");
        this.businessList.add("建筑助剂");
        this.businessList.add("油墨涂料");
        this.businessList.add("胶黏剂/树脂乳液");
        this.businessList.add("表面处理");
        this.businessList.add("高分子材料");
        this.businessList.add("原料贸易");
        this.businessList.add("医药");
        this.businessList.add("设备");
        this.businessList.add("其他");

        //客户归属
        this.customerBelongList.add("丁庆超");
        this.customerBelongList.add("周金铃");
        this.customerBelongList.add("xxx");
        this.customerBelongList.add("公司客户维护组1");
        this.customerBelongList.add("公司客户维护组2");


        //客户类型
        this.customerTypeList.add("主动开发");
        this.customerTypeList.add("被动信息");
        this.customerTypeList.add("公司分配");

        //合作状态
        this.cooperationStatusList.add("未合作");
        this.cooperationStatusList.add("潜在客户");
        this.cooperationStatusList.add("重要潜在客户");
        this.cooperationStatusList.add("合作客户");
        this.cooperationStatusList.add("VIP客户");
        this.cooperationStatusList.add("流失客户");
        this.cooperationStatusList.add("黑名单客户");


        //业务类型
        this.serviceTypeList.add("未合作");
        this.serviceTypeList.add("成分综合分析");
        this.serviceTypeList.add("定性分析");
        this.serviceTypeList.add("理化指标");
        this.serviceTypeList.add("仪器检测");
        this.serviceTypeList.add("外包项目");
        this.serviceTypeList.add("产品研发");
        this.serviceTypeList.add("工业诊断");
        this.serviceTypeList.add("其他业务");

    }




}
