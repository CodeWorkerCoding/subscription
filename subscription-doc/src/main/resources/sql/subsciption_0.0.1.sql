INSERT INTO `subscription`.`subscription_time_task` (`id`, `created_time`, `cron_rule`, `execute_context`, `modified_time`, `status`, `task_condition`, `task_name`, `task_desc`)
VALUES ('1', NULL, '0/1 * * * * ?', 'demoScheduleService', NULL, 'ENABLE', 'COMPLETED', '定时任务Demo', '定时任务案例');
INSERT INTO `subscription`.`subscription_time_task` (`id`, `created_time`, `cron_rule`, `execute_context`, `modified_time`, `status`, `task_condition`, `task_name`, `task_desc`)
VALUES ('2', NULL, '0/1 * * * * ?', 'indexScheduleService', NULL, 'ENABLE', 'COMPLETED', '创建系统INDEX任务', '');
