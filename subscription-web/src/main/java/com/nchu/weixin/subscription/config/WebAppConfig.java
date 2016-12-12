package com.nchu.weixin.subscription.config;

import com.nchu.weixin.subscription.interceptor.SubscriptionInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by fujianjian on 2016/12/12.
 */
@Configuration
public class WebAppConfig extends WebMvcConfigurerAdapter {

    @Autowired
    SubscriptionInterceptor subscriptionInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        InterceptorRegistration subscriptionRegistration = registry.addInterceptor(subscriptionInterceptor);
        subscriptionRegistration.addPathPatterns("/**").excludePathPatterns("/error", "/error/**");
    }
}
