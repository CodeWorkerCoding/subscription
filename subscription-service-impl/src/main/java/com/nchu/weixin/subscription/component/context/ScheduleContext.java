package com.nchu.weixin.subscription.component.context;

import com.nchu.weixin.subscription.component.RootScheduleService;
import com.nchu.weixin.subscription.domain.component.TimeTask;
import com.nchu.weixin.subscription.enums.component.TimeTaskConditionEnum;
import com.nchu.weixin.subscription.enums.component.TimeTaskStatusEnum;
import com.nchu.weixin.subscription.service.common.TimeTaskService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 定时任务 上下文
 * Created by fujianjian on 2016/12/18.
 */
@Component
@Slf4j
public class ScheduleContext {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TimeTaskService timeTaskService;

    private static final String SCHEDULE_GROUP = "SCHEDULE_GROUP";

    private Scheduler scheduler = null;

    private Map historyJobKey = new HashMap();

    @PostConstruct
    public void init(){
        if (scheduler == null){
            try {
                SchedulerFactory schedulerFactory = new StdSchedulerFactory();
                scheduler = schedulerFactory.getScheduler();
                scheduler.clear();
                scheduler.start();
            } catch (SchedulerException e) {
                log.error("初始化系统定时任务上下文失败", e);
            }
            Map param = new HashMap();
            param.put("status", TimeTaskStatusEnum.ENABLE);
            List<TimeTask> taskList = timeTaskService.searcher(param);
            taskList.forEach(task -> {
                if (task.getCondition() == null || task.getCondition() == TimeTaskConditionEnum.EXECUTING){
                    task.setCondition(TimeTaskConditionEnum.INIT);
                    timeTaskService.modify(task);
                }
                register(task);
            });
        }


    }

    /**
     * 注册一个定时任务
     * @param task 任务
     */
    public void register(TimeTask task){
        if (TimeTaskStatusEnum.ENABLE != task.getStatus()){
            log.info("任务【{}】 不是启用的状态，不注册！！！", task.getTaskName());
        }
        unRegister(task);
        String executeContext = task.getExecuteContext();
        try {
            RootScheduleService rootService = (RootScheduleService) applicationContext.getBean(executeContext);

            JobDataMap jobDataMap = new JobDataMap();
            jobDataMap.put("module", task);
            jobDataMap.put("rootScheduleService", rootService);
            jobDataMap.put("timeTaskService", timeTaskService);
            JobBuilder builder = JobBuilder.newJob(ScheduleExecuter.class);
            builder.usingJobData(jobDataMap);
            String jobKey = "job_" + task.getId();
            JobDetail job = builder.withIdentity(jobKey, SCHEDULE_GROUP).requestRecovery()
                    .build();
            historyJobKey.put(jobKey, job);
            CronTrigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("trigger_" + task.getId(), SCHEDULE_GROUP)
                    .withSchedule(CronScheduleBuilder.cronSchedule(task.getCronRule())).build();
            scheduler.scheduleJob(job, trigger);
        } catch (Exception e){
            log.error("定时任务【{}[{}]】注册失败", task.getTaskName(), task.getId(), e);
        }

    }

    public void unRegister(TimeTask task){
        try {
            String jobKey = "Job_" + task.getId();
            JobDetail job = (JobDetail) historyJobKey.get(jobKey);
            if (job == null){
                job = scheduler.getJobDetail(JobKey.jobKey(jobKey, SCHEDULE_GROUP));
            }
            if (job != null) {
                scheduler.deleteJob(job.getKey());
            }
            if (historyJobKey.containsKey(jobKey)){
                historyJobKey.remove(jobKey);
            }
        } catch (Exception e){
            log.error("定时任务【{}[{}]】注销失败， 可能是定时任务未注册的缘故", task.getTaskName(), task.getId(), e);
        }
    }
}
