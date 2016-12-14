package com.nchu.weixin.subscription.enums;

/**
 * 商品状态枚举
 * Created by fujianjian on 2016/12/10.
 */
public enum GoodsStatusEnum {
    WAIT_SHELVE("WAIT_SHELVE", "待上架"),
    IN_SALE("IN_SALE", "正在销售"),
    REBACK("REBACK", "召回"),
    UN_SHELVE("UN_SHELVE", "已下架")
    ;

    private String value;

    private String desc;

    GoodsStatusEnum(String desc, String value) {
        this.desc = desc;
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
