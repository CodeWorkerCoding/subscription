package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.Goods;
import com.nchu.weixin.subscription.enums.MailTypeEnum;
import com.nchu.weixin.subscription.enums.OperateEnum;
import com.nchu.weixin.subscription.repo.common.GoodsRepo;
import com.nchu.weixin.subscription.service.common.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Id;
import org.springframework.stereotype.Service;

/**
 * 商品服务实现类
 * Created by fujianjian on 2016/12/10.
 */
@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    BaseService baseService;

    @Autowired
    GoodsRepo goodsRepo;

    public Goods get(String id) {
        return goodsRepo.getOne(id);
    }

    public Goods create(Goods object) {
        object = this.goodsRepo.save(object);
        baseService.sendMail(MailTypeEnum.GOODS, OperateEnum.ADD);
        return object;
    }

    public Goods modify(Goods object) {
        return this.goodsRepo.saveAndFlush(object);
    }

    public void delete(String id) {
        this.goodsRepo.delete(id);
    }
}
