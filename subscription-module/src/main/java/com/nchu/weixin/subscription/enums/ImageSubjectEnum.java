package com.nchu.weixin.subscription.enums;

import lombok.Getter;
import lombok.Setter;

/**
 * 图片类型枚举
 * Created by fujianjian on 2016/12/18.
 */
public enum  ImageSubjectEnum {
    ICON("图标"),
    ILLUSTRATE("说明图"),
    ;

    @Getter
    @Setter
    private String desc;

    ImageSubjectEnum(String desc) {
        this.desc = desc;
    }
}
