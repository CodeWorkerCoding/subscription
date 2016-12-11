package com.nchu.weixin.subscription.domain;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 邮件模板 模型
 * Created by fujian on 2016/12/11.
 */
public class MailTemplate implements Serializable {

    @Getter
    @Setter
    private String id;

    @Getter
    @Setter
    private String sender;
    @Getter
    @Setter
    private String senderPassword;

    @Getter
    @Setter
    private String senderHost;

    @Getter
    @Setter
    private String[] receivers;

    @Getter
    @Setter
    private String subject;

    @Getter
    @Setter
    private String content;
}
