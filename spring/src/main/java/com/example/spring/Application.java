package com.example.spring;

import com.example.spring.aop.OrderService;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

import javax.annotation.PostConstruct;

@SpringBootApplication
public class Application {

    @Autowired
    OrderService orderService;

    @PostConstruct
    public void execute() {
        orderService.create();
        System.out.println("-------------分------------");
//        orderService.payed();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        ApplicationContext parent = context.getParent();
        System.out.println("爸爸容器:" + parent);


    }

}
