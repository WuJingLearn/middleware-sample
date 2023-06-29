package com.example.spring.boot.autoconfig;

import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

/**
 * @author majin.wj
 * @date 2023/6/29 10:02 AM
 * @desc
 */

@AutoConfigureAfter(value = Config2.class)
@Configuration
public class Config1 {

    @PostConstruct
    public void init(){
        System.out.println("Config1 init");
    }
}
