package com.nchu.weixin.subscription.domain;

import com.nchu.weixin.subscription.enums.GoodsStatusEnum;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品模型
 * Created by fujianjian on 2016/12/10.
 */
public class Goods implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String goodsName;

    @Getter
    @Setter
    private String goodsDesc;

    @Getter
    @Setter
    private double goodsPrice;

    @Getter
    @Setter
    private Integer saleCount;

    @Getter
    @Setter
    private String goodsImgPath;

    @Getter
    @Setter
    private GoodsStatusEnum status;

    @Getter
    @Setter
    private Date createdTime;

    @Getter
    @Setter
    private Date modifiedTime;
}
