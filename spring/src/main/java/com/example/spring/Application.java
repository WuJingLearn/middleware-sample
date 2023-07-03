package com.example.spring;

import com.example.spring.aop.OrderService;
import com.example.spring.boot.autoconfig.Config1;
import com.example.spring.event.listener.CustomEvent;
import com.example.spring.event.listener.HelloAsync;
import org.aspectj.lang.annotation.Pointcut;
import org.javaboy.boot.autoconfig.Config1AutoConfiguration;
import org.javaboy.boot.autoconfig.HelloService;
import org.javaboy.boot.runlistener.RunListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.SimpleApplicationEventMulticaster;
import org.springframework.scheduling.annotation.EnableAsync;

import javax.annotation.PostConstruct;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@SpringBootApplication
/**
 * 注入了一个后置处理器，用来增强代理。
 */
@EnableAsync
public class Application {


/*    @Autowired
    Config1AutoConfiguration config1AutoConfiguration;*/

    @Autowired
    HelloService helloService;

    @Autowired
    OrderService orderService;


    @PostConstruct
    public void execute() {
        testAsync();
    }


    @Autowired
    HelloAsync async;

    void testAsync(){
        async.test();;
    }

    void aopTest(){
        orderService.create();
        System.out.println("-------------分------------");
        orderService.payed();
    }

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

        context.publishEvent(new CustomEvent(context));


    /*    SimpleApplicationEventMulticaster multicaster = new SimpleApplicationEventMulticaster();
        multicaster.setBeanFactory(context.getBeanFactory());
        multicaster.multicastEvent(new CustomEvent(context));*/

    }

  /*  @Bean
    public SimpleApplicationEventMulticaster applicationEventMulticaster() {
        SimpleApplicationEventMulticaster simpleApplicationEventMulticaster = new SimpleApplicationEventMulticaster();
        BlockingQueue<Runnable> blockingQueue = new LinkedBlockingDeque<>(1000);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(5, 5, 10, TimeUnit.SECONDS, blockingQueue);
        simpleApplicationEventMulticaster.setTaskExecutor(threadPoolExecutor);
        return simpleApplicationEventMulticaster;
    }
*/
}
