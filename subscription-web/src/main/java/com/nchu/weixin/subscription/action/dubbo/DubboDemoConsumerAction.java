package com.nchu.weixin.subscription.action.dubbo;

import com.nchu.tech.course.service.dubbo.DubbeDemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * dubbo 小样服务消费者
 * Created by fujianjian on 2017/2/27.
 */
@RestController
public class DubboDemoConsumerAction {

    @Autowired
    private DubbeDemoService dubbeDemoService;

    @RequestMapping(value = "/dubbo/geet", method = RequestMethod.GET)
    public String dubboGeet(){
        return dubbeDemoService.geet("allen");
    }
}
