package com.nchu.weixin.subscription.impl.component.module;

import com.nchu.weixin.subscription.domain.MailTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 基础邮件模板
 * Created by fujianjian on 2016/12/11.
 */
@Service
public abstract class BaseMailTemplate {

    @Value("${subscription.mail.sender.account}")
    private String senderAccount;

    @Value("${subscription.mail.sender.pwd}")
    private String accountPwd;

    @Value("${subscription.mail.sender.host}")
    private String senderHost;

    @Value("${subscription.mail.receivers}")
    private String recevicers;

    MailTemplate initTemplate() {
        MailTemplate template = new MailTemplate();
        template.setSender(this.senderAccount);
        template.setSenderPassword(this.accountPwd);
        template.setReceivers(this.recevicers.split("\\,"));
        template.setSenderHost(this.senderHost);
        return template;
    }
}
