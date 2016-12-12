package com.nchu.weixin.subscription.utils;

import com.nchu.weixin.subscription.domain.MailTemplate;
import org.junit.Before;
import org.junit.Test;

/**
 * 邮件工具测试
 * Created by fujianjian on 2016/12/12.
 */
public class MailUtilTest {

    private MailTemplate template;

    @Before
    public void init(){
        this.template = new MailTemplate();
        this.template.setSender("nchufujianjian@sina.cn");
        this.template.setSenderPassword("fujianjian007");
        this.template.setSenderHost("smtp.sina.cn");
        this.template.setReceivers(new String[]{"nchufujianjian@sina.cn"});
        this.template.setSubject("测试邮件");
        this.template.setContent("这是一个测试邮件");
    }

    @Test
    public void testSendMail(){
        MailUtil mailUtil = new MailUtil();
        mailUtil.send(this.template);
    }

}
