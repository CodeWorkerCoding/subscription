package com.nchu.weixin.subscription;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * 设置项目可以配置部署到自定义的servlet容器中
 * Created by fujianjian on 2017/2/20.
 */
public class ServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(SubscriptionWebApplication.class);
    }
}
