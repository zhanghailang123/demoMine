package com.zhl.mine.sta.chainpattern;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/6 13:51
 */
@Component
public class SkuInfoHandler extends AbstractDataHandeler<SkuInfoHandler.SkuInfo>{
    @Override
    protected SkuInfo doRequest(String query) throws Exception {
        SkuInfo info = new SkuInfo();
        info.setSkuId(78910L);
        info.setSkuName("测试Sku");
        return info;
    }

    @Data
    public static class SkuInfo{
        private Long skuId;
        private String skuName;
    }
}