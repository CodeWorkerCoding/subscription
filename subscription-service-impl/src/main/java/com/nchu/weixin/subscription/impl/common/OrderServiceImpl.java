package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.Order;
import com.nchu.weixin.subscription.enums.MailTypeEnum;
import com.nchu.weixin.subscription.enums.OperateEnum;
import com.nchu.weixin.subscription.repo.primary.common.OrderRepo;
import com.nchu.weixin.subscription.service.common.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by fujianjian on 2016/12/10.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    BaseService baseService;

    @Autowired
    private OrderRepo orderRepo;

    public Order get(String s) {
        return orderRepo.getOne(s);
    }

    public Order create(Order object) {
        baseService.sendMail(MailTypeEnum.ORDER, OperateEnum.ADD);
        return orderRepo.save(object);
    }

    public Order modify(Order object) {
        return orderRepo.saveAndFlush(object);
    }

    public void delete(String s) {
        orderRepo.delete(s);

    }

    @Override
    public Map searcher(Map paramMap, Pageable pageRequest) {
        Map retMap = new HashMap();
        Page<Order> pages = this.orderRepo.findAll(pageRequest);

        retMap.put("pages", pages);
        retMap.put("ords", pages.getContent());

        return retMap;
    }
}
