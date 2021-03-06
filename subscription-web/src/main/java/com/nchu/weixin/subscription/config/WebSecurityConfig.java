package com.nchu.weixin.subscription.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.header.writers.frameoptions.XFrameOptionsHeaderWriter;

/**
 * web 项目安全配置
 *  暂时未生效 在配置文件中 [<sec:csrf disabled="true"/>] 代替之
 * Created by Alen on 2016/12/13.
 */
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable(); //关闭csrf Token
        http.headers().addHeaderWriter(new XFrameOptionsHeaderWriter(
                XFrameOptionsHeaderWriter.XFrameOptionsMode.SAMEORIGIN)); // 解决iframe显示不了页面问题
    }
}
