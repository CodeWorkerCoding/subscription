package com.nchu.weixin.subscription.impl.component.module;

import com.nchu.weixin.subscription.domain.MailTemplate;
import com.nchu.weixin.subscription.domain.Order;
import org.springframework.stereotype.Service;

/**
 * 订单邮件模板
 * Created by fujianjian on 2016/12/11.
 */
@Service
public class OrderMailsTemplate extends BaseMailTemplate {

    public MailTemplate getAddOrderMailTemplate(Order order){
        MailTemplate template = this.initTemplate();
        template.setSubject("生成一个订单了");
        template.setContent("这是一个生成新订单的通知类邮件");
        return template;
    }
}
