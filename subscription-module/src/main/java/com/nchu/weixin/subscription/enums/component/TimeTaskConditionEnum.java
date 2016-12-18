package com.nchu.weixin.subscription.enums.component;

import lombok.Getter;
import lombok.Setter;

/**
 * 定时认为执行状态
 * Created by fujianjian on 2016/12/18.
 */
public enum TimeTaskConditionEnum {

    INIT("INIT", "初始"),
    EXECUTING("EXECUTING", "执行中"),
    EXCEPTION("EXCEPTION", "执行异常"),
    COMPLETED("COMPLETED", "执行完成"),
    ;

    @Getter
    @Setter
    private String value;
    @Getter
    @Setter
    private String desc;

    TimeTaskConditionEnum(String value, String desc) {
        this.desc = desc;
        this.value = value;
    }
}
