package org.javaboy.rpc.invoker.test;

import org.javaboy.rpc.invoker.DefaultInvoker;
import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;
import org.javaboy.rpc.invoker.wrap.LogInvoker;
import org.javaboy.rpc.invoker.wrap.ParamterCheckInvoker;

/**
 * @author majin.wj
 * @date 2023/6/14 11:22 AM
 * @desc
 */
public class TestWrapper {

    public static void main(String[] args) {
        HelloService helloService = new HelloService();
        DefaultInvoker defaultInvoker = new DefaultInvoker();
        defaultInvoker.setTarget(helloService);

        Invocation invocation = new Invocation();
        invocation.setMethod("hello");
        invocation.setArgTypes(new Class<?>[]{String.class, Integer.class});
        invocation.setArgs(new Object[]{"码劲", 25});
        Object result = defaultInvoker.invoke(invocation);


        // 可以使用Invoker包装的方式进行增强
        Invoker invoker = new LogInvoker(new ParamterCheckInvoker(defaultInvoker));

        Object invoke = invoker.invoke(invocation);
        System.out.println(invoke);


    }
}
