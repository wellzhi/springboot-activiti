package com.dapeng.flow.activiti6.handler;

import com.dapeng.flow.activiti6.ServiceFactory;
import com.dapeng.flow.activiti6.ActInstanceQuery;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.runtime.ProcessInstanceQuery;
import org.activiti.engine.task.Task;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 流程实例查询
 *
 * @author liuxz
 * @date 2019/08/30
 */
@Component
public class InstanceQueryHandler extends ServiceFactory implements ActInstanceQuery {

    protected static Logger logger = LoggerFactory.getLogger(InstanceQueryHandler.class);

    @Override
    public ProcessInstanceQuery createProcessInstanceQuery() {
        return runtimeService.createProcessInstanceQuery();
    }

    @Override
    public ProcessInstance processInstanceId(String processInstanceId) {

        return createProcessInstanceQuery().processInstanceId(processInstanceId).singleResult();
    }

    @Override
    public ProcessInstance processInstanceBusinessKey(String processInstanceBusinessKey) {

        return createProcessInstanceQuery().processInstanceBusinessKey(processInstanceBusinessKey).singleResult();
    }

    @Override
    public boolean hasProcessInstanceFinished(String processInstanceId) {

        ProcessInstance pi = processInstanceId(processInstanceId);

        return pi == null;
    }

    @Override
    public ProcessInstance taskId(String taskId) {

        Task task = taskService.createTaskQuery().taskId(taskId).singleResult();
        String processInstId = task.getProcessInstanceId();
        return this.processInstanceId(processInstId);
    }

}
