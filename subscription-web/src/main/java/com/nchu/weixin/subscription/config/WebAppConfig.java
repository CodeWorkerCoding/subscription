package com.nchu.weixin.subscription.config;

import com.nchu.weixin.subscription.interceptor.LoginInterceptor;
import com.nchu.weixin.subscription.interceptor.SubscriptionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * 系统拦截器配置
 * Created by fujianjian on 2016/12/12.
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    SubscriptionInterceptor subscriptionInterceptor;

    @Autowired
    LoginInterceptor loginInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*系统全局拦截器 连接全局的操作*/
        InterceptorRegistration subscriptionRegistration = registry.addInterceptor(subscriptionInterceptor);
        subscriptionRegistration.addPathPatterns("/**").excludePathPatterns("/error", "/error/**");

        /*登入拦截器只拦截管理页面的操作*/
        InterceptorRegistration loginRegistration = registry.addInterceptor(loginInterceptor);
        loginRegistration.addPathPatterns("/manage/**");
    }
}
