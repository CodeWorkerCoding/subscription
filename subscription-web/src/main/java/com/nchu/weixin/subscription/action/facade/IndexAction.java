package com.nchu.weixin.subscription.action.facade;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 门面模式的主控制器
 * Created by fujianjian on 2016/12/31.
 */
@Controller
@RequestMapping("/facade")
@Slf4j
public class IndexAction {

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public String index(){
        return "facade/index/home";
    }
}
