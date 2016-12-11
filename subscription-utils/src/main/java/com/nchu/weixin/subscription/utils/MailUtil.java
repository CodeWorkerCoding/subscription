package com.nchu.weixin.subscription.utils;

import com.nchu.weixin.subscription.domain.MailTemplate;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.mail.HtmlEmail;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/**
 * 邮件发送工具
 * Created by fujianjian on 2016/12/11.
 */
@Component
@Slf4j
public class MailUtil {

    private static final String ENCODEING = "UTF-8";

    public boolean send(MailTemplate template) {
        // 发送email
        HtmlEmail email = new HtmlEmail();
        try {
            // 这里是SMTP发送服务器的名字：163的如下："smtp.163.com"
            email.setHostName(template.getSenderHost());
            // 字符编码集的设置
            email.setCharset(ENCODEING);
            // 收件人的邮箱
            email.addTo(template.getReceivers());
            // 发送人的邮箱
            email.setFrom(template.getSender());
            // 如果需要认证信息的话，设置认证：用户名-密码。分别为发件人在邮件服务器上的注册名称和密码
            email.setAuthentication(template.getSender(), template.getSenderPassword());
            // 要发送的邮件主题
            email.setSubject(template.getSubject());
            // 要发送的信息，由于使用了HtmlEmail，可以在邮件内容中使用HTML标签
            email.setMsg(template.getContent());
            // 发送
            email.send();

            log.info(template.getSender() + " 发送邮件到 " + Arrays.asList(template.getReceivers()) + "成功");
            return true;
        } catch (Exception e) {
            log.info(template.getSender() + " 发送邮件到 " + Arrays.asList(template.getReceivers()) + "失败", e);
            return false;
        }
    }
}
