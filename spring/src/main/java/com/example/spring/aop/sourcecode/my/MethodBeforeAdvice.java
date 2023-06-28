package com.example.spring.aop.sourcecode.my;

import java.lang.reflect.Method;

/**
 * @author majin.wj
 * @date 2023/6/28 3:03 PM
 * @desc
 */
public class MethodBeforeAdvice {

    private Object target;
    private Method method;

    public MethodBeforeAdvice(Object target,Method method) {
        this.method = method;
        this.target = target;
    }

    void before() {
        try {
            method.invoke(target);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

}
