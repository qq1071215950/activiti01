package com.haojing.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;
import org.activiti.engine.repository.ProcessDefinitionQuery;

import java.util.List;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/5 12:08
 * 删除定义查询
 */
public class deleteProceccDefinition {
    public static void main(String[] args) {
        String deploymentId = "1";
        // 得到PE对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 得到PS对象
        RepositoryService repositoryService = processEngine
                .getRepositoryService();
        repositoryService.deleteDeployment(deploymentId);
    }
}
