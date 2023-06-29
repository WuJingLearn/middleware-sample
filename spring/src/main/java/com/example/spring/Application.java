package com.example.spring;

import com.example.spring.aop.OrderService;
import com.example.spring.boot.autoconfig.Config1;
import org.aspectj.lang.annotation.Pointcut;
import org.javaboy.boot.autoconfig.Config1AutoConfiguration;
import org.javaboy.boot.autoconfig.HelloService;
import org.javaboy.boot.runlistener.RunListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {


/*    @Autowired
    Config1AutoConfiguration config1AutoConfiguration;*/

    @Autowired
    HelloService helloService;

    @Autowired
    OrderService orderService;


    @PostConstruct
    public void execute() {

    }

    void aopTest(){
        orderService.create();
        System.out.println("-------------分------------");
        orderService.payed();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ApplicationContext parent = context.getParent();
        System.out.println("爸爸容器:" + parent);


    }

}
