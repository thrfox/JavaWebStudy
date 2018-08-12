package com.study.springAop.demo2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import javax.annotation.PostConstruct;

/**
 * @author xiongyongshun
 * @version 1.0
 * @created 2016/11/11 22:41
 */
@EnableAspectJAutoProxy
@SpringBootApplication
public class LogAopDemo {
    @Autowired
    NeedLogService needLogService;
    @Autowired
    NormalService normalService;

    public static void main(String[] args) {
        SpringApplication.run(LogAopDemo.class, args);
    }

    //该注解会在类构造时执行
    @PostConstruct
    public void test() {
        needLogService.logMethod("com/study/springAop");
        try {
            needLogService.exceptionMethod();
        } catch (Exception e) {
            // Ignore
        }
        normalService.someMethod();
    }
}
