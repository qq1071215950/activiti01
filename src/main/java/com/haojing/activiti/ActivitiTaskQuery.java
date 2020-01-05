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
 * 任务查询
 */
public class ActivitiTaskQuery {
    public static void main(String[] args) {
        // 得到PE对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到TS对象
        TaskService taskService = processEngine.getTaskService();
        // 根据流程定义的Key,负责人来实现当亲用户的任务查询
        List<Task> list = taskService.createTaskQuery()
                .processDefinitionKey("holiday_1")
                .taskAssignee("zhangsna")
                .list();
        // 任务列表的展示
        for (Task task : list) {
            System.out.println(" 流 程 实 例 id ： " +
                    task.getProcessInstanceId());
            System.out.println("任务id：" + task.getId());
            System.out.println("任务负责人：" + task.getAssignee());
            System.out.println("任务名称：" + task.getName());
        }

        // 李四任务查询
        Task task = taskService.createTaskQuery()
                .processDefinitionKey("holiday_1")
                .taskAssignee("lisi")
                .singleResult();
        System.out.println(" 流 程 实 例 id ： " +
                task.getProcessInstanceId());
        System.out.println("任务id：" + task.getId());
        System.out.println("任务负责人：" + task.getAssignee());
        System.out.println("任务名称：" + task.getName());

    }
}
