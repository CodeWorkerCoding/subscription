package com.nchu.weixin.subscription.enums;

/**
 * 操作类型 枚举
 * Created by fujianjian on 2016/12/11.
 */
public enum OperateEnum {
    ADD("ADD", "添加操作"),
    MODIFY("MODIFY", "更新操作"),
    DEL("DEL", "删除操作"),
    RELEASE("RELEASE", "上架"),
    REBACK("REBACK", "召回"),
    UNSHELVE("UNSHELVE", "下架"),

    ;
    private String value;

    private String desc;

    OperateEnum(String value, String desc) {
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
