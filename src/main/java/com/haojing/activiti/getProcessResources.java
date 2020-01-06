package com.haojing.activiti;

import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.ProcessDefinition;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/6 9:34
 * 获取定义资源
 */
public class getProcessResources {
    public static void main(String[] args) throws IOException {
        // 得到PE对象
        ProcessEngine processEngine = ProcessEngines.getDefaultProcessEngine();
        // 流程定义id
        String processDefinitionId = "";
        // 获取repositoryService
        RepositoryService repositoryService = processEngine
                .getRepositoryService();

        // 流程定义对象
        ProcessDefinition processDefinition = repositoryService
                .createProcessDefinitionQuery().processDefinitionId(processDefinitionId).singleResult();
        //获取bpmn
        String resource_bpmn = processDefinition.getResourceName();
        //获取png
        String resource_png =
                processDefinition.getDiagramResourceName();
        // 资源信息
        System.out.println("bpmn：" + resource_bpmn);
        System.out.println("png：" + resource_png);
        File file_png = new File("c:/purchasingflow01.png");
        File file_bpmn = new File("c:/purchasingflow01.bpmn");
        // 输出bpmn
        InputStream resourceAsStream = null;
        resourceAsStream = repositoryService.getResourceAsStream(
                processDefinition.getDeploymentId(), resource_bpmn);

        FileOutputStream fileOutputStream = new
                FileOutputStream(file_bpmn);
        byte[] b = new byte[1024];
        int len = -1;
        while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
            fileOutputStream.write(b, 0, len);
        }
        // 输出图片
        resourceAsStream = repositoryService.getResourceAsStream(
                processDefinition.getDeploymentId(), resource_png);
        fileOutputStream = new FileOutputStream(file_png);
        // byte[] b = new byte[1024];
        // int len = -1;
        while ((len = resourceAsStream.read(b, 0, 1024)) != -1) {
            fileOutputStream.write(b, 0, len);
        }
    }
}
