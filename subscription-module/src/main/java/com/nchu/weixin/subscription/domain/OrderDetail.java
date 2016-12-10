package com.nchu.weixin.subscription.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情模型
 * Created by Alen on 2016/12/10.
 */
public class OrderDetail implements Serializable{

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String orderId;

    @Getter
    @Setter
    private String goodsId;

    @Getter
    @Setter
    private Integer goodsCount;

    @Getter
    @Setter
    private Double goodsPrice;

    @Getter
    @Setter
    private Double goodsCost;

    @Getter
    @Setter
    private Date createdTime;

    @Getter
    @Setter
    private Date modifiedTime;
}
