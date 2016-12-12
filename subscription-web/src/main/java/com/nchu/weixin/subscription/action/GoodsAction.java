package com.nchu.weixin.subscription.action;

import com.nchu.weixin.subscription.service.common.GoodsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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

    @Autowired
    GoodsService goodsService;

    @RequestMapping(value = "/list",
     method = {RequestMethod.GET})
    public String list(@RequestParam Map paramMap,
         @RequestParam(name = "pageNo",required = false) Integer pageNo,
         @RequestParam(name = "pageSize", required = false) Integer pageSize){
        log.info("hint this goods list method");
//        goodsService.create(null);
        return "facade/goods/list";
    }

    @RequestMapping(value = "/{id}/info",
            method = {RequestMethod.GET, RequestMethod.POST})
    public String goodsDetail(@PathVariable String id,
                              Model model){
        return "/facade/goods/info";
    }
}
