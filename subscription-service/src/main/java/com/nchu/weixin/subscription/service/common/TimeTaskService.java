package com.nchu.weixin.subscription.service.common;

import com.nchu.weixin.subscription.domain.component.TimeTask;

import java.util.List;
import java.util.Map;

/**
 * 定时任务服务
 * Created by fujianjian on 2016/12/18.
 */
public interface TimeTaskService extends BaseService<TimeTask, Integer> {

    /**
     * 检索符合条件的定时任务
     * @param paramMap
     * @return
     */
    List<TimeTask> searcher(Map paramMap);
}
