package com.nchu.weixin.subscription.component.impl;

import com.nchu.weixin.subscription.component.RootScheduleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * 定时任务小样（用于测试）
 * Created by fujianjian on 2016/12/18.
 */
@Service("demoScheduleService")
@Slf4j
public class DemoScheduleService implements RootScheduleService {

    @Override
    public void execute() {
        log.info("我是一个定时任务小样, 仅用于验证定时任务是否生效");
    }
}
