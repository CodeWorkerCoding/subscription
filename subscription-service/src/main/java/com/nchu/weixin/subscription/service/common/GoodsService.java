package com.nchu.weixin.subscription.service.common;

import org.springframework.web.multipart.MultipartFile;

import com.nchu.weixin.subscription.domain.Goods;

/**
 * 订单服务
 * Created by fujianjian on 2016/12/10.
 */
public interface GoodsService extends BaseService<Goods, String> {

    /**
     * 带图表的添加一个商品
     * @param object
     * @param iconImg
     * @return
     */
    Goods create(Goods object, MultipartFile iconImg) throws Exception;
}
