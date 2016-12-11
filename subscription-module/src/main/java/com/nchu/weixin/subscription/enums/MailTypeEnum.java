package com.nchu.weixin.subscription.enums;

/**
 * 邮件类型 枚举
 * Created by fujianjian on 2016/12/11.
 */
public enum MailTypeEnum {
    GOODS("GOODS", "商品"),
    ORDER("ORDER", "订单"),
    ;
    private String value;

    private String desc;

    MailTypeEnum(String value, String desc) {
        this.value = value;
        this.desc = desc;
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
