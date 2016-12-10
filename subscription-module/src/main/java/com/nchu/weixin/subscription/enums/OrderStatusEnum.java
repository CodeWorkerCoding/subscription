package com.nchu.weixin.subscription.enums;

/**
 * 订单状态枚举
 * Created by Alen on 2016/12/10.
 */
public enum OrderStatusEnum {
    ;

    private String value;

    private String desc;

    OrderStatusEnum(String desc, String value) {
        this.desc = desc;
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
