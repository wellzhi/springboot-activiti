package com.dapeng.flow.test.listener;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.DelegateTask;
import org.activiti.engine.delegate.ExecutionListener;
import org.activiti.engine.delegate.TaskListener;

/**
 * @author Administrator
 */
public class MyExecutionListener implements ExecutionListener, TaskListener {
    /**
     * 实现ExecutionListener中的方法
     */
    @Override
    public void notify(DelegateExecution execution) {
        String eventName = execution.getEventName();
        if ("start".equals(eventName)) {
            System.out.println("start=========流程启动了");
        } else if ("end".equals(eventName)) {
            System.out.println("end=========流程结束了");
        }else if ("take".equals(eventName)) {
            System.out.println("take=========");
        }
    }


    /**
     * 实现TaskListener中的方法
     */
    @Override
    public void notify(DelegateTask delegateTask) {
        String eventName = delegateTask.getEventName();
        if ("create".endsWith(eventName)) {
            System.out.println("create=========");
        }else if ("assignment".endsWith(eventName)) {
            System.out.println("assignment========");
        }else if ("complete".endsWith(eventName)) {
            System.out.println("complete===========");
        }else if ("delete".endsWith(eventName)) {
            System.out.println("delete=============");
        }
    }
}
