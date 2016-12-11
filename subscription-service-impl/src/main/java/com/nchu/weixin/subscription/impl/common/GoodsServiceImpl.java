package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.Goods;
import com.nchu.weixin.subscription.enums.MailTypeEnum;
import com.nchu.weixin.subscription.enums.OperateEnum;
import com.nchu.weixin.subscription.service.common.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 商品服务实现类
 * Created by fujianjian on 2016/12/10.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    BaseService baseService;

    public Goods get(String s) {
        return null;
    }

    public Goods create(Goods object) {
        baseService.sendMail(MailTypeEnum.GOODS, OperateEnum.ADD);
        return null;
    }

    public Goods modify(Goods object) {
        return null;
    }

    public void delete(String s) {

    }
}
