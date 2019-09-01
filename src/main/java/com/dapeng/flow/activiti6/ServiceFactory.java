package com.dapeng.flow.activiti6;

import org.activiti.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * activiti引擎注入封装
 *
 * @author liuxz
 * @date 2019/08/30
 */
@Component
public class ServiceFactory {

    @Autowired
    protected RepositoryService repositoryService;

    @Autowired
    protected RuntimeService runtimeService;

    @Autowired
    protected IdentityService identityService;

    @Autowired
    protected TaskService taskService;

    @Autowired
    protected FormService formService;

    @Autowired
    protected HistoryService historyService;

    @Autowired
    protected ManagementService managementService;

    @Autowired
    protected ProcessEngine processEngine;

}