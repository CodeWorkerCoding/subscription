package com.nchu.weixin.subscription.service.component;

import com.nchu.weixin.subscription.domain.MailTemplate;
import com.nchu.weixin.subscription.enums.MailTypeEnum;
import com.nchu.weixin.subscription.enums.OperateEnum;

/**
 * 邮件模板工厂
 * Created by fujianjian on 2016/12/11.
 */
public interface MailTemplateFactory {

    MailTemplate getMailTemplate(MailTypeEnum type, OperateEnum operate);
}
