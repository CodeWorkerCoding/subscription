package com.nchu.weixin.subscription.component.context;

import com.nchu.weixin.subscription.component.RootScheduleService;
import com.nchu.weixin.subscription.domain.component.TimeTask;
import com.nchu.weixin.subscription.enums.component.TimeTaskConditionEnum;
import com.nchu.weixin.subscription.service.common.TimeTaskService;
import lombok.extern.slf4j.Slf4j;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import javax.persistence.Table;

/**
 * 自定义定时认为执行器
 * Created by fujianjian on 2016/12/18.
 */
@Slf4j
public class ScheduleExecuter implements Job {

    public ScheduleExecuter() {
    }

    /**
     * <p>
     * Called by the <code>{@link Scheduler}</code> when a <code>{@link Trigger}</code>
     * fires that is associated with the <code>Job</code>.
     * </p>
     * <p>
     * <p>
     * The implementation may wish to set a
     * {@link JobExecutionContext#setResult(Object) result} object on the
     * {@link JobExecutionContext} before this method exits.  The result itself
     * is meaningless to Quartz, but may be informative to
     * <code>{@link JobListener}s</code> or
     * <code>{@link TriggerListener}s</code> that are watching the job's
     * execution.
     * </p>
     *
     * @param context
     * @throws JobExecutionException if there is an exception while executing the job.
     */
    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {
        TimeTask task = (TimeTask) context.getMergedJobDataMap().get("module");

        TimeTaskService taskService = (TimeTaskService) context.getMergedJobDataMap().get("timePlanService");

        if (TimeTaskConditionEnum.EXECUTING != task.getCondition()){
            try {
                RootScheduleService rootScheduleService = (RootScheduleService) context.getMergedJobDataMap().get("rootScheduleService");
                task.setCondition(TimeTaskConditionEnum.EXECUTING);
                taskService.modify(task);
                rootScheduleService.execute();
                task.setCondition(TimeTaskConditionEnum.COMPLETED);
                taskService.modify(task);
            } catch (Exception e){
                log.error("任务【{}】执行异常", task.getTaskName(), e);
                task.setCondition(TimeTaskConditionEnum.EXCEPTION);
                taskService.modify(task);
            }
        }
    }
}
