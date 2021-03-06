package com.haojing.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.HashMap;
import java.util.Map;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/4 20:47
 * 启动流程实例
 */
public class ActivitiStartInstance {
    public static void main(String[] args) {
        //定义流程变量
        Map<String, Object> variables = new HashMap<String, Object>();
        //设置流程变量assignee
        variables.put("assignee", "张三");
        // 得到PE对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到RS对象
        RuntimeService runtimeService = processEngine.getRuntimeService();
        // 创建流程实例
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("holiday_1",variables);
        // 输出实例相关信息
        System.out.println(" 流程定义 id ： " + processInstance.getProcessDefinitionId());
        System.out.println("流程实例id：" + processInstance.getId());
        System.out.println(" 当前活动 Id ： " + processInstance.getActivityId());
    }
}
