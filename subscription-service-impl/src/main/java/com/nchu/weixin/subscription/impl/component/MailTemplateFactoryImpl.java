package com.nchu.weixin.subscription.impl.component;

import com.nchu.weixin.subscription.domain.MailTemplate;
import com.nchu.weixin.subscription.enums.MailTypeEnum;
import com.nchu.weixin.subscription.enums.OperateEnum;
import com.nchu.weixin.subscription.impl.component.module.GoodsMailsTemplate;
import com.nchu.weixin.subscription.impl.component.module.OrderMailsTemplate;
import com.nchu.weixin.subscription.service.component.MailTemplateFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 邮件模板工厂实现
 * Created by fujianjian on 2016/12/11.
 */
@Service
public class MailTemplateFactoryImpl implements MailTemplateFactory {

    @Autowired
    GoodsMailsTemplate goodsMailsTemplate;

    @Autowired
    OrderMailsTemplate orderMailsTemplate;

    @Override
    public MailTemplate getMailTemplate(MailTypeEnum type, OperateEnum operate) {
        if (type == MailTypeEnum.GOODS){
            if (operate == OperateEnum.ADD){
                return goodsMailsTemplate.getAddGoodsTemplate(null);
            }
        } else if (type == MailTypeEnum.ORDER) {
            if (operate == OperateEnum.ADD){
                return orderMailsTemplate.getAddOrderMailTemplate(null);
            }
        }
        return null;
    }
}
