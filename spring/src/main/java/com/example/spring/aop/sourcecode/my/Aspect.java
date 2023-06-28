package com.example.spring.aop.sourcecode.my;

import org.springframework.stereotype.Component;

/**
 * @author majin.wj
 * @date 2023/6/28 3:02 PM
 * @desc
 */

public class Aspect {


    public void before(){
        System.out.println("前置通知");
    }

    public void after(){
        System.out.println("后置通知");
    }

}
