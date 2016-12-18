package com.nchu.weixin.subscription.enums.component;

import lombok.Getter;
import lombok.Setter;

/**
 * 任务整体状态 枚举
 * Created by fujianjian on 2016/12/18.
 */
public enum TimeTaskStatusEnum {

    ENABLE("ENABLE", "启用"),
    DISABLE("DISABLE", "禁用"),
    ;

    @Getter
    @Setter
    private String value;
    @Getter
    @Setter
    private String desc;

    TimeTaskStatusEnum(String value, String desc) {
        this.desc = desc;
        this.value = value;
    }
}
