package com.example.spring.aop.sourcecode.my;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

/**
 * @author majin.wj
 * @date 2023/6/28 3:03 PM
 * @desc
 */
public class JdkAopProxy implements InvocationHandler {

    private Object target;

    Map<Method,MethodBeforeAdvice> adviceMap = new HashMap<>();


    public JdkAopProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        MethodBeforeAdvice before = new MethodBeforeAdvice(new Aspect(), Aspect.class.getMethod("before"));
        before.before();
        Object result = method.invoke(args);

        return null;
    }
}
