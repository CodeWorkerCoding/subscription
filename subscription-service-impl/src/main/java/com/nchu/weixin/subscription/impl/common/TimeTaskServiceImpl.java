package com.nchu.weixin.subscription.impl.common;

import com.nchu.weixin.subscription.domain.component.TimeTask;
import com.nchu.weixin.subscription.repo.common.TimeTaskRepo;
import com.nchu.weixin.subscription.service.common.TimeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 定时任务服务实现类
 * Created by fujianjian on 2016/12/18.
 */
@Service
public class TimeTaskServiceImpl implements TimeTaskService {

    @Autowired
    TimeTaskRepo timeTaskRepo;

    @Override
    public TimeTask get(Integer integer) {
        return null;
    }

    @Override
    public TimeTask create(TimeTask object) {
        return null;
    }

    @Override
    public TimeTask modify(TimeTask object) {
        return null;
    }

    @Override
    public void delete(Integer integer) {

    }

    @Override
    public Map searcher(Map paramMap, Pageable pageRequest) {
        return null;
    }

    /**
     * 检索符合条件的定时任务
     * @param paramMap
     * @return
     */
    @Override
    public List<TimeTask> searcher(Map paramMap) {
        return null;
    }
}
