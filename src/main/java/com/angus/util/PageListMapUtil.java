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
    public final static ArrayList<String> orderTypeList = new ArrayList<String>();
    public final static ArrayList<String> orderServiceTypeList = new ArrayList<String>();
    public final static ArrayList<String> receiveLaborList = new ArrayList<String>();
    public final static ArrayList<String> cheapConditionList = new ArrayList<String>();
    public final static ArrayList<String> projectProcessList = new ArrayList<String>();
    public final static ArrayList<String> ticketStatusList = new ArrayList<String>();

    static{
        //行业
        businessList.add("日化清洗");
        businessList.add("建筑助剂");
        businessList.add("油墨涂料");
        businessList.add("胶黏剂/树脂乳液");
        businessList.add("表面处理");
        businessList.add("高分子材料");
        businessList.add("原料贸易");
        businessList.add("医药");
        businessList.add("设备");
        businessList.add("其他");

        //客户归属
        customerBelongList.add("丁庆超");
        customerBelongList.add("周金铃");
        customerBelongList.add("xxx");
        customerBelongList.add("公司客户维护组1");
        customerBelongList.add("公司客户维护组2");


        //客户类型
        customerTypeList.add("主动开发");
        customerTypeList.add("被动信息");
        customerTypeList.add("公司分配");

        //合作状态
        cooperationStatusList.add("未合作");
        cooperationStatusList.add("潜在客户");
        cooperationStatusList.add("重要潜在客户");
        cooperationStatusList.add("合作客户");
        cooperationStatusList.add("VIP客户");
        cooperationStatusList.add("流失客户");
        cooperationStatusList.add("黑名单客户");


        //业务类型
        serviceTypeList.add("未合作");
        serviceTypeList.add("成分综合分析");
        serviceTypeList.add("定性分析");
        serviceTypeList.add("理化指标");
        serviceTypeList.add("仪器检测");
        serviceTypeList.add("外包项目");
        serviceTypeList.add("产品研发");
        serviceTypeList.add("工业诊断");
        serviceTypeList.add("其他业务");


        //下单类型
        orderTypeList.add("个人新客户");
        orderTypeList.add("个人老客户");
        orderTypeList.add("公司客户产生");


        //订单业务类型
        orderServiceTypeList.add("样品成分综合分析");
        orderServiceTypeList.add("成分分析（按成分收费）");
        orderServiceTypeList.add("仪器检测");
        orderServiceTypeList.add("理化指标分析");
        orderServiceTypeList.add("委外项目");
        orderServiceTypeList.add("立项研发");

        //承接实验室
        receiveLaborList.add("常化所");
        receiveLaborList.add("联泓");

        //优惠条件
        cheapConditionList.add("领导特批");
        cheapConditionList.add("协议价格");
        cheapConditionList.add("活动特惠");

        //项目进展
        projectProcessList.add("暂停作业");
        projectProcessList.add("开始作业");
        projectProcessList.add("报告已出（未发）");
        projectProcessList.add("报告已发");

        //发票状态
        ticketStatusList.add("不需要");
        ticketStatusList.add("未开");
        ticketStatusList.add("已开");

    }




}
