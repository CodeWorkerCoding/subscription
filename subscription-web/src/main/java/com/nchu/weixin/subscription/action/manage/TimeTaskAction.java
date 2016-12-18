package com.nchu.weixin.subscription.action.manage;

import com.nchu.weixin.subscription.service.common.TimeTaskService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

    @Autowired
    TimeTaskService  timeTaskService;

    @RequestMapping(value = "/list",
            method = {RequestMethod.GET})
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

}
