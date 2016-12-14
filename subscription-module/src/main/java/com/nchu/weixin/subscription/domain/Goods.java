package com.nchu.weixin.subscription.domain;

import com.nchu.weixin.subscription.enums.GoodsStatusEnum;
import com.nchu.weixin.subscription.enums.GoodsTypeEnum;
import com.nchu.weixin.subscription.tools.UUidUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品模型
 * Created by fujianjian on 2016/12/10.
 */
@Entity
@Table(name = "subscription_goods")
public class Goods implements Serializable {

    @Getter
    @Setter
    @Id
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
    @Enumerated(EnumType.STRING)
    private GoodsTypeEnum goodsType;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private GoodsStatusEnum status;

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
