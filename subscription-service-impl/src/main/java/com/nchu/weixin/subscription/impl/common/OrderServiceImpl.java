package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.Order;
import com.nchu.weixin.subscription.enums.MailTypeEnum;
import com.nchu.weixin.subscription.enums.OperateEnum;
import com.nchu.weixin.subscription.service.common.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Alen on 2016/12/10.
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    BaseService baseService;

    public Order get(String s) {
        return null;
    }

    public Order create(Order object) {
        baseService.sendMail(MailTypeEnum.ORDER, OperateEnum.ADD);
        return null;
    }

    public Order modify(Order object) {
        return null;
    }

    public void delete(String s) {

    }
}
