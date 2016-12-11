package com.nchu.weixin.subscription.impl.component.module;

import com.nchu.weixin.subscription.domain.Goods;
import com.nchu.weixin.subscription.domain.MailTemplate;
import org.springframework.stereotype.Service;

/**
 * 商品相关邮件模板
 *  添加 一个商品通知邮件模板
 *  修改 一个商品通知邮件模板
 *  删除 一个商品通知邮件模板
 * Created by Alen on 2016/12/11.
 */
@Service
public class GoodsMailsTemplate extends BaseMailTemplate {

    public MailTemplate getAddGoodsTemplate(Goods goods){
        MailTemplate template = this.initTemplate();
        template.setSubject("已经添加一个商品信息");
        String content = "这个是一个添加商品信息的通知类邮件";
        template.setContent(content);
        return template;
    }
}
