package com.nchu.weixin.subscription.repo.primary.common;

import com.nchu.weixin.subscription.domain.component.TimeTask;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * 定时任务 repo
 * Created by fujianjian on 2016/12/18.
 */
public interface TimeTaskRepo extends JpaRepository<TimeTask, Integer> {
}
