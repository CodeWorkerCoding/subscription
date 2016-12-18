package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.OrderDetail;
import com.nchu.weixin.subscription.service.common.OrderDetailService;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * Created by fujianjian on 2016/12/10.
 */
@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    public OrderDetail get(String s) {
        return null;
    }

    public OrderDetail create(OrderDetail object) {
        return null;
    }

    public OrderDetail modify(OrderDetail object) {
        return null;
    }

    public void delete(String s) {

    }

    @Override
    public Map searcher(Map paramMap, Pageable pageRequest) {
        return null;
    }
}
