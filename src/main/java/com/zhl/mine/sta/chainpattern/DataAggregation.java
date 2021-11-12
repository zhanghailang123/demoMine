package com.zhl.mine.sta.chainpattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 责任链为请求创建了一个接收者对象的链。这种模式给与请求的类型，对请求的发送者和接收者进行解耦。
 * @author: zhanghailang
 * @date: 2021/8/6 14:00
 */
@Component
public class DataAggregation {

    @Autowired
    private SkuInfoHandler skuInfoHandler;
    @Autowired
    private IntermInfoHandler intermInfoHandler;

    public Map convertItemDetail() throws Exception {
        Map result = new HashMap(2);
        result.put("skuInfoHandler",skuInfoHandler.doRequest("模拟数据请求"));
        result.put("intermInfoHandler",intermInfoHandler.doRequest("模拟数据请求"));
        return result;
    }

    public static void main(String[] args) throws Exception {
        ApplicationContext context = new ClassPathXmlApplicationContext("classpath:applicationContext.xml");
        DataAggregation dataAggregation = (DataAggregation) context.getBean("dataAggregation");
        Map map = dataAggregation.convertItemDetail();
        System.out.println(map.toString());
    }
}