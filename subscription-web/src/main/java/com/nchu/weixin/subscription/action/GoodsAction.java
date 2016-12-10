package com.nchu.weixin.subscription.action;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 商品 Action
 * Created by fujianjian on 2016/12/10.
 */
@Controller
@RequestMapping("/goods")
@Slf4j
public class GoodsAction {

    @RequestMapping(value = "/list",
     method = {RequestMethod.GET})
    public String list(@RequestParam Map paramMap,
          Integer pageNo, Integer pageSize){
        log.info("hint this goods list method");
        return "facade/goods/list";
    }
}
