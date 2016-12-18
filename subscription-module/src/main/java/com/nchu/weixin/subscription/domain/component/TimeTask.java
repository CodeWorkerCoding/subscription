package com.nchu.weixin.subscription.domain.component;

import com.nchu.weixin.subscription.enums.component.TimeTaskConditionEnum;
import com.nchu.weixin.subscription.enums.component.TimeTaskStatusEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * 定时任务模型
 * Created by fujianjian on 2016/12/18.
 */
@Entity
@Table(name = "subscription_time_task")
public class TimeTask implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Getter
    @Setter
    private String taskName;
    @Getter
    @Setter
    private String cronRule;
    @Getter
    @Setter
    private String executeContext;
    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private TimeTaskStatusEnum status;

    @Getter
    @Setter
    @Enumerated(EnumType.STRING)
    private TimeTaskConditionEnum condition;
    @Getter
    @Setter
    private Date createdTime;
    @Getter
    @Setter
    private Date modifiedTime;



}
