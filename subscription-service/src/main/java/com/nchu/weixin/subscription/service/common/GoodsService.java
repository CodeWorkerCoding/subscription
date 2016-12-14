package com.nchu.weixin.subscription.service.common;

import com.nchu.weixin.subscription.domain.Goods;
import org.springframework.data.domain.Pageable;

import java.util.Map;

/**
 * 订单服务
 * Created by fujianjian on 2016/12/10.
 */
public interface GoodsService extends BaseService<Goods, String> {

    Map searcher(Map paramMap, Pageable pageRequest);
}
