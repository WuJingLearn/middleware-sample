package com.example.spring.aop.sourcecode.sample;

import java.lang.reflect.Method;

/**
 * @author majin.wj
 * @date 2023/6/28 5:01 PM
 * @desc
 */
public class MethodAfterReturningInterceptor extends AbstractAdvice implements MethodInterceptor {

    public MethodAfterReturningInterceptor(Method adviceMethod, Object aspectBean) {
        super(adviceMethod, aspectBean);
    }

    @Override
    public Object invoke(Invocation invocation) {
        Object retValue = invocation.proceed();
        //正常返回后执行
        invokeAdviceMethod();
        return retValue;

    }
}
