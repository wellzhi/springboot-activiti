package com.dapeng.flow;

import org.activiti.spring.boot.SecurityAutoConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//解决：Caused by: java.lang.ArrayStoreException: sun.reflect.annotation.TypeNotPresentExceptionProxy
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
@EnableSwagger2
@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class,
        org.activiti.spring.boot.SecurityAutoConfiguration.class
})
@ComponentScan(basePackages = {"org.activiti.rest"}, includeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = {
                RestController.class})}, useDefaultFilters = false, lazyInit = false)
public class FlowApplication {
    public static void main(String[] args) {
        SpringApplication.run(FlowApplication.class, args);
    }

}
