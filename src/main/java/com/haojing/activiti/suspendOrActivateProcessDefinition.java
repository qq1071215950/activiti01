package com.haojing.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.runtime.ProcessInstance;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/6 10:29
 * 流程实例的挂起
 */
public class suspendOrActivateProcessDefinition {
    public static void main(String[] args) {
        // 流程定义id
        String processDefinitionId = "";
        // 得到PE对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        RepositoryService repositoryService = processEngine
                .getRepositoryService();

        // 获得流程定义
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery()
                .processDefinitionId(processDefinitionId).singleResult();
        //是否暂停
        boolean suspend = processDefinition.isSuspended();
        if (suspend) {
            //如果暂停则激活，这里将流程定义下的所有流程实例全部激活
            repositoryService.activateProcessDefinitionById(processDefinitionId,
                    true, null);
            System.out.println("流程定义：" + processDefinitionId + "激活");
        } else {
            //如果激活则挂起，这里将流程定义下的所有流程实例全部挂起
            repositoryService.suspendProcessDefinitionById(processDefinitionId,
                    true, null);
            System.out.println("流程定义：" + processDefinitionId + "挂起");
        }
    }

    /**
     * 单个实例的挂起RS对象
     */
    public void suspendOrActiveProcessInstance(){
        String processInstanceId = "";
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 获取RunTimeService
        RuntimeService runtimeService = processEngine.getRuntimeService();
        //根据流程实例id查询流程实例
        ProcessInstance processInstance =
                runtimeService.createProcessInstanceQuery()
                        .processInstanceId(processInstanceId).singleResult();
        boolean suspend = processInstance.isSuspended();
        if(suspend){
        //如果暂停则激活
            runtimeService.activateProcessInstanceById(processInstanceId);
            System.out.println("流程实例："+processInstanceId+"激活");
        }else{
        //如果激活则挂起
            runtimeService.suspendProcessInstanceById(processInstanceId);
            System.out.println("流程实例："+processInstanceId+"挂起");
        }
    }
}
