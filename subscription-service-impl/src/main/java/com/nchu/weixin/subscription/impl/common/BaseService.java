package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.MailTemplate;
import com.nchu.weixin.subscription.enums.MailTypeEnum;
import com.nchu.weixin.subscription.enums.OperateEnum;
import com.nchu.weixin.subscription.service.component.MailTemplateFactory;
import com.nchu.weixin.subscription.utils.MailUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 基础服务
 * Created by fujianjian on 2016/12/11.
 */
@Service
public class BaseService {
    @Autowired
    MailTemplateFactory factory;

    @Autowired
    MailUtil mailUtil;

    void sendMail(MailTypeEnum type, OperateEnum operate){
        MailTemplate template = factory.getMailTemplate(type, operate);
        mailUtil.send(template);
    }
}
