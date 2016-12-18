package com.nchu.weixin.subscription.component.impl;

import com.nchu.weixin.subscription.component.RootScheduleService;
import org.springframework.stereotype.Service;

/**
 * 定时发送邮件服务
 * Created by fujianjian on 2016/12/18.
 */
@Service("emailScheduleService")
public class EmailScheduleService implements RootScheduleService {

    @Override
    public void execute() {

    }
}
