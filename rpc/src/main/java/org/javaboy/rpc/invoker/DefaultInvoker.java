package org.javaboy.rpc.invoker;

import java.lang.reflect.Method;

/**
 * @author majin.wj
 * @date 2023/6/14 10:30 AM
 * @desc
 */
public class DefaultInvoker implements Invoker {

    private Object target;

    public void setTarget(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Invocation invocation) {
        String methodName = invocation.getMethod();
        Class<?>[] argTypes = invocation.getArgTypes();
        Object[] args = invocation.getArgs();
        try {
            Method method = target.getClass().getDeclaredMethod(methodName, argTypes);
            method.setAccessible(true);
            return method.invoke(target, args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Class<?> getType() {
        return target.getClass();
    }
}
