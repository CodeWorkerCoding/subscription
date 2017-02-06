package com.nchu.weixin.subscription.action.manage;

import com.nchu.weixin.subscription.component.RootScheduleService;
import com.nchu.weixin.subscription.component.context.ScheduleContext;
import com.nchu.weixin.subscription.domain.component.TimeTask;
import com.nchu.weixin.subscription.enums.component.TimeTaskConditionEnum;
import com.nchu.weixin.subscription.enums.component.TimeTaskStatusEnum;
import com.nchu.weixin.subscription.service.common.TimeTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 系统任务控制器
 * Created by fujianjian on 2016/12/18.
 */
@Controller
@RequestMapping("/manage/task")
@Slf4j
public class TimeTaskAction {

    private static final Integer PAGE_MIN = 1;
    private static final Integer PAGE_MAX = 20;

    /*定时器上下文*/
    @Autowired
    private ScheduleContext scheduleContext;

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private TimeTaskService timeTaskService;

    @RequestMapping(value = "/list",
            method = {RequestMethod.GET, RequestMethod.POST})
    public String manageList(@RequestParam Map paramMap,
                             @RequestParam(name = "pageNo", defaultValue = "1", required = false) Integer pageNo,
                             @RequestParam(name = "pageSize",defaultValue = "20", required = false) Integer pageSize,
                             Map model){
        log.info("hint this goods manage list method");
        Map retMap = this.timeTaskService.searcher(paramMap,
                new PageRequest(pageNo < PAGE_MIN ? 0 : pageNo -1 ,
                        pageSize > PAGE_MAX ? PAGE_MAX : pageSize ,
                        new Sort(Sort.Direction.DESC, "createdTime")));
        model.putAll(retMap);
        model.putAll(paramMap);
        return "manage/task/list";
    }

    @RequestMapping(value = "/create",method = RequestMethod.GET)
    public String createTaskPage(){
        return "manage/task/create";
    }

    @RequestMapping(value = "/{taskId}/modify",method = RequestMethod.GET)
    public String modifyTaskPage(@PathVariable Integer taskId, Map model){
        TimeTask tt = this.timeTaskService.get(taskId);
        model.put("ts",tt);
        return "manage/task/create";
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public String createTask(TimeTask timeTask){
        timeTaskService.create(timeTask);
        return "redirect:/manage/task/list";
    }

    @RequestMapping(value = "/modify",method = RequestMethod.POST)
    public String modifyTask(TimeTask timeTask){
        timeTaskService.modify(timeTask);
        return "redirect:/manage/task/list";
    }

    /**
     * 开通一个定时任务
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/enable", method = RequestMethod.GET)
    public String enable(@RequestParam Integer taskId){
        TimeTask tt = this.timeTaskService.get(taskId);
        scheduleContext.unRegister(tt);
        tt.setStatus(TimeTaskStatusEnum.ENABLE);
        this.timeTaskService.modify(tt);
        this.scheduleContext.register(tt);
        return "redirect:/manage/task/list";
    }

    /**
     * 关闭一个定时任务
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/disable", method = RequestMethod.GET)
    public String disable(@RequestParam Integer taskId){
        TimeTask tt = this.timeTaskService.get(taskId);
        scheduleContext.unRegister(tt);
        tt.setStatus(TimeTaskStatusEnum.DISABLE);
        this.timeTaskService.modify(tt);
        return "redirect:/manage/task/list";
    }

    /***
     * 执行一次定时任务
     * @param taskId
     * @return
     */
    @RequestMapping(value = "/execute", method = RequestMethod.GET)
    public @ResponseBody Map execute(@RequestParam Integer taskId){
        Map ret = new HashMap();
        TimeTask tt = this.timeTaskService.get(taskId);
        if (tt != null && tt.getTaskCondition() == TimeTaskConditionEnum.INIT){
            tt.setTaskCondition(TimeTaskConditionEnum.PREPARE);
            timeTaskService.modify(tt);
            RootScheduleService service = (RootScheduleService) this.applicationContext.getBean(tt.getExecuteContext());
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        tt.setTaskCondition(TimeTaskConditionEnum.EXECUTING);
                        timeTaskService.modify(tt);
                        service.execute();
                        tt.setTaskCondition(TimeTaskConditionEnum.COMPLETED);
                        timeTaskService.modify(tt);
                    } catch (Exception e){
                        log.warn("【{}】定时任务执行异常, 异常信息：", tt.getExecuteContext(), e);
                        tt.setTaskCondition(TimeTaskConditionEnum.EXCEPTION);
                        timeTaskService.modify(tt);
                    }
                }
            }).start();
            ret.put("code", 401); // 准备执行
            ret.put("msg", tt.getTaskCondition().getDesc());
            return ret;
        } else {
            if (tt.getTaskCondition() == TimeTaskConditionEnum.COMPLETED) {
                ret.put("code", 402); // 执行完成
            } else if (tt.getTaskCondition() == TimeTaskConditionEnum.EXCEPTION) {
                ret.put("code", 403); // 执行异常
            }
            ret.put("msg", tt.getTaskCondition().getDesc());
            return ret;
        }
    }

}
