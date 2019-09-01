package com.dapeng.flow;

import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.VariableInstance;
import org.activiti.engine.task.Task;
import org.activiti.engine.test.ActivitiRule;
import org.activiti.engine.test.ActivitiTestCase;
import org.activiti.engine.test.Deployment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Map;

import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes=FlowApplication.class)
public class MyBusinessProcessTest {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
//    @Rule
//    public ActivitiRule activitiSpringRule;

    @Test
//    @Deployment
//    public void simpleProcessTest() {
//        runtimeService.startProcessInstanceByKey("simpleProcess");
//        Task task = taskService.createTaskQuery().singleResult();
//        assertEquals("My Task", task.getName());
//
//        taskService.complete(task.getId());
//        assertEquals(0, runtimeService.createProcessInstanceQuery().count());
//
//    }

    @Deployment
    public void testSimpleProcess() {
        Map<String, Object> variables = taskService.getVariables("130013");
        System.out.println(variables.toString());
        //assertEquals(0, runtimeService.createProcessInstanceQuery().count());
    }
}