package com.nchu.weixin.subscription.action.manage;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 订单管理控制器
 * Created by fujianjian on 2016/12/11.
 */
@Controller
@RequestMapping("/manage/order")
@Slf4j
public class OrderAction {


    @RequestMapping(value = "/list",
            method = {RequestMethod.GET})
    public String list(@RequestParam Map paramMap,
          @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
          @RequestParam(name = "pagerSize", defaultValue = "20") Integer pageSize){
        log.info("hit this order manger list method");
        return "manage/order/list";
    }

}
