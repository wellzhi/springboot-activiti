package com.dapeng.flow.activiti6.handler;

import com.dapeng.flow.activiti6.ActHistTaskQuery;
import com.dapeng.flow.activiti6.ServiceFactory;

import org.activiti.engine.history.HistoricTaskInstance;
import org.activiti.engine.history.HistoricTaskInstanceQuery;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 历史任务
 *
 * @author liuxz
 * @date 2019/08/30
 */
@Component
public class HistTaskQueryHandler extends ServiceFactory implements ActHistTaskQuery {

    protected static Logger logger = LoggerFactory.getLogger(HistTaskQueryHandler.class);


    @Override
    public HistoricTaskInstanceQuery createHistoricTaskInstanceQuery() {
        return historyService.createHistoricTaskInstanceQuery();
    }

    @Override
    public HistoricTaskInstance activeTask(String instanceId) {
        return createHistoricTaskInstanceQuery().processInstanceId(instanceId).unfinished().singleResult();
    }

    @Override
    public HistoricTaskInstance finishedTask(String taskId) {
        return createHistoricTaskInstanceQuery().taskId(taskId).singleResult();
    }

    @Override
    public List<HistoricTaskInstance> listByInstanceId(String instanceId) {
        return createHistoricTaskInstanceQuery().processInstanceId(instanceId).orderByTaskCreateTime().desc().list();

    }

    @Override
    public List<HistoricTaskInstance> pageListByInstanceId(String instanceId, int start, int limit) {
        return createHistoricTaskInstanceQuery()
                .processInstanceId(instanceId)
                .orderByTaskCreateTime()
                .desc().listPage(start, limit);

    }

}