package com.nchu.weixin.subscription.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;

/**
 * 商品图片
 * Created by fujianjian on 2016/12/11.
 */
public class GoodsImages implements Serializable {

    @Setter
    @Getter
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

}
