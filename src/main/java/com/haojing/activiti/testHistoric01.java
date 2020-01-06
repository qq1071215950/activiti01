package com.haojing.activiti;

import org.activiti.engine.HistoryService;
import org.activiti.engine.ProcessEngine;
import org.activiti.engine.ProcessEngines;
import org.activiti.engine.history.HistoricActivityInstance;
import org.activiti.engine.history.HistoricActivityInstanceQuery;

import java.util.List;

/**
 * @author jiange
 * @version 1.0
 * @date 2020/1/6 9:54
 * 历史记录的查询
 */
public class testHistoric01 {
    public static void main(String[] args) {
        // 得到PE对象
        ProcessEngine pe = ProcessEngines.getDefaultProcessEngine();
        HistoryService historyService = pe.getHistoryService();
        HistoricActivityInstanceQuery query =
                historyService.createHistoricActivityInstanceQuery();
        // 流程实例id
        query.processInstanceId("2501");
        List<HistoricActivityInstance> list = query.list();
        for(HistoricActivityInstance ai :list){
            System.out.println(ai.getActivityId());
            System.out.println(ai.getActivityName());
            System.out.println(ai.getProcessDefinitionId());
            System.out.println(ai.getProcessInstanceId());
            System.out.println("==============================");
        }
    }
}
