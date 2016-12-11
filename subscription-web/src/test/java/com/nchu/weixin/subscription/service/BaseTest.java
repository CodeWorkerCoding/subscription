package com.nchu.weixin.subscription.service;

import com.nchu.weixin.subscription.SubscriptionWebApplication;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * 服务测试基础类
 * <p>
 * Spring Boot的SpringApplicationConfiguration注解在Spring Boot 1.4开始，被标记为Deprecated
 *      解决：替换为SpringBootTest即可
 * Created by fujianjian on 2016/12/11.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SubscriptionWebApplication.class)
public class BaseTest {
}
