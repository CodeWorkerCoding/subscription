package com.nchu.weixin.subscription.action.manage;

import com.nchu.weixin.subscription.domain.Goods;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * 商品管理 控制器
 * Created by fujianjian on 2016/12/12.
 */
@Controller
@RequestMapping("/manage/goods")
@Slf4j
public class GoodsManageAction {

    @RequestMapping(value = "/list",
            method = {RequestMethod.GET})
    public String manageList(@RequestParam Map paramMap,
                             @RequestParam(name = "pageNo",required = false) Integer pageNo,
                             @RequestParam(name = "pageSize", required = false) Integer pageSize){
        log.info("hint this goods manage list method");
        return "manage/goods/list";
    }


    @RequestMapping(value = "/create", method = {RequestMethod.GET})
    public String create(){
        log.info("hint this goods create get method");
        return "manager/goods/create";
    }

    @RequestMapping(value = "/create", method = {RequestMethod.POST})
    public String handleAdd(Goods goods){
        log.info("hint this goods create Post method");
        return "redirect:manager/goods/list";
    }

}
