package com.nchu.weixin.subscription.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 标记类型
 * Created by fujianjian on 2017/2/23.
 */
public enum IndexTypeEnum {
    GOODS("商品"),
    ORDER("订单"),
    ;

    @Getter
    @Setter
    private String desc;

    IndexTypeEnum(String desc){
        this.desc = desc;
    }
}
