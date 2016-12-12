package com.nchu.weixin.subscription.domain;

import com.nchu.weixin.subscription.enums.OrderStatusEnum;
import com.nchu.weixin.subscription.tools.UUidUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单模型
 * Created by fujianjian on 2016/12/10.
 */
@Entity
@Table(name = "subscription_order")
public class Order implements Serializable {

    @Getter
    @Setter
    @Id
    private String id;

    @Getter
    @Setter
    private String custId;

    @Getter
    @Setter
    private Integer goodsCount;

    @Getter
    @Setter
    private Double orderCost;

    @Getter
    @Setter
    private OrderStatusEnum status;

    @Getter
    @Setter
    private Date createdTime;

    @PrePersist
    public void onCreate(){
        this.id = UUidUtil.getUUid();
        this.createdTime = new Date();
    }
}
