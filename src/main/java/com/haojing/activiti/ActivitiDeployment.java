package com.haojing.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/4 20:07
 * 流程定义部署
 */
public class ActivitiDeployment {
    public static void main(String[] args) {
        // 1 创建ProcessEngine对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 2.获取RepositoryService实例
        RepositoryService repositoryService = processEngine.getRepositoryService();
        // 3.进行部署
        Deployment deployment = repositoryService.createDeployment()
                .addClasspathResource("diagarm/holiday.xml")
                .addClasspathResource("diagarm/holiday.png")
                .name("请假申请流程")
                .deploy();
        // 4.输出一些部署的信息
        System.out.println("流程部署id:" + deployment.getId());
        System.out.println("流程部署名称:" + deployment.getName());

    }
}
