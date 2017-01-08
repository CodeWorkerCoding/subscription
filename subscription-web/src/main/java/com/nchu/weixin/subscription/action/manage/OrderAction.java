package com.nchu.weixin.subscription.action.manage;

import com.nchu.weixin.subscription.service.common.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
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

    private final static Integer PAGE_MIN = 1;
    private final static Integer PAGE_MAX = 20;

    @Autowired
    private OrderService orderService;


    @RequestMapping(value = "/list",
            method = {RequestMethod.GET, RequestMethod.POST})
    public String list(@RequestParam Map paramMap,
          @RequestParam(name = "pageNo", defaultValue = "1") Integer pageNo,
          @RequestParam(name = "pagerSize", defaultValue = "20") Integer pageSize,
                       Map model){
        log.info("hit this order manger list method");
        Map retMap = this.orderService.searcher(paramMap,
                new PageRequest(pageNo < PAGE_MIN ? 0 : pageNo -1 ,
                        pageSize > PAGE_MAX ? PAGE_MAX : pageSize ,
                        new Sort(Sort.Direction.DESC, "createdTime")));
        model.putAll(paramMap);
        model.putAll(retMap);
        return "manage/order/list";
    }

}
