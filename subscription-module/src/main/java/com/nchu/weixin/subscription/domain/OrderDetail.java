package com.nchu.weixin.subscription.domain;

import com.nchu.weixin.subscription.tools.UUidUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情模型
 * Created by Alen on 2016/12/10.
 */
@Entity
@Table(name = "subscription_order_detail")
public class OrderDetail implements Serializable{

    @Getter
    @Setter
    @Id
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

    @PrePersist
    public void onCreate(){
        this.id = UUidUtil.getUUid();
        this.createdTime = new Date();
    }

    @PreUpdate
    public void onUpdate(){
        this.modifiedTime = new Date();
    }
}
