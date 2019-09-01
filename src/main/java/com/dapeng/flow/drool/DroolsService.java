package com.dapeng.flow.drool;

import org.activiti.engine.delegate.DelegateExecution;
import org.activiti.engine.delegate.JavaDelegate;

/**
 * @author Administrator
 */
public class DroolsService implements JavaDelegate {
    @Override
    public void execute(DelegateExecution execution) {
        System.out.println("++++++++++++++++++++++++++++++++++++++");
        System.out.println(execution.getVariable("reason"));
        System.out.println("++++++++++++++++++++++++++++++++++++++");
    }
}
