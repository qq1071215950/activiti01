package com.haojing.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.TaskService;
import org.activiti.engine.task.Task;

import java.util.List;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/4 21:08
 * 任务处理
 */
public class ActivitiTaskComplete {
    public static void main(String[] args) {
        // 得到PE对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到TS对象
        TaskService taskService = processEngine.getTaskService();
        // 根据流程定义的Key,负责人来实现当亲用户的任务查询
        taskService.complete("2505");
        System.out.println("完成任务id="+2505);
    }
}
