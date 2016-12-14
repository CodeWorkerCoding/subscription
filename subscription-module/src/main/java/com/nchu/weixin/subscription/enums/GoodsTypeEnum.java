package com.nchu.weixin.subscription.enums;

/**
 * 商品类型模型
 * Created by fujianjian on 2016/12/10.
 */
public enum GoodsTypeEnum {
    PIZZA("PIZZA", "披萨"),
    CAKE("CAKE", "蛋糕"),
    ;

    private String value;

    private String desc;

    GoodsTypeEnum(String desc, String value) {
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
