package com.nchu.weixin.subscription.module;

import lombok.Getter;
import lombok.Setter;

/**
 * 梯形模型
 * Created by fujianjian on 2017/1/24.
 */
public class Lader {

    /*上底*/
    @Getter
    @Setter
    private Double above;
    /*下底*/
    @Getter
    @Setter
    private Double bottom;
    /*高*/
    @Getter
    @Setter
    private Double height;
    /*面积*/
    @Getter
    @Setter
    private Double area;

    public Double calcArea(){
        this.area = (above + bottom) * height / 2;
        return area;
    }
}
