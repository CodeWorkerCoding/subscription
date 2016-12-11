package com.nchu.weixin.subscription.service.common;

import com.nchu.weixin.subscription.service.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by Alen on 2016/12/11.
 */
public class GoodsServiceTest extends BaseTest {

    @Autowired
    GoodsService goodsService;


    @Test
    public void testCreateGoods(){
        goodsService.create(null);
    }
}
