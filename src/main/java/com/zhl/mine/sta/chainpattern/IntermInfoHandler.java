package com.zhl.mine.sta.chainpattern;

import lombok.Data;
import org.springframework.stereotype.Component;

/**
 * @description:
 * @author: zhanghailang
 * @date: 2021/8/6 13:35
 */
@Component
public class IntermInfoHandler extends AbstractDataHandeler<IntermInfoHandler.ItemInfo>{
    @Override
    protected ItemInfo doRequest(String query) throws Exception {
        ItemInfo itemInfo = new ItemInfo();
        itemInfo.setItemId(123456L);
        itemInfo.setItemName("测试商品");
        return itemInfo;
    }
    @Data
    public static class ItemInfo{
        private Long itemId;
        private String itemName;
    }
}
