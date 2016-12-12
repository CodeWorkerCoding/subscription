package com.nchu.weixin.subscription.domain;

import com.nchu.weixin.subscription.utils.UUidUtil;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 商品图片
 * Created by fujianjian on 2016/12/11.
 */
@Entity
@Table(name = "subscription_goods_img")
public class GoodsImages implements Serializable {

    @Setter
    @Getter
    @Id
    private String id;

    @Setter
    @Getter
    private String goodsId;

    @Setter
    @Getter
    private String imageDesc;

    @Setter
    @Getter
    private String imagePath;

    @Setter
    @Getter
    private Date createdTime;

    @PrePersist
    public void onCreate(){
        this.id = UUidUtil.getUUid();
        this.createdTime = new Date();
    }

}
