package com.nchu.weixin.subscription.enums;

/**
 * 商品状态枚举
 * Created by fujianjian on 2016/12/10.
 */
public enum GoodsStatusEnum {

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
