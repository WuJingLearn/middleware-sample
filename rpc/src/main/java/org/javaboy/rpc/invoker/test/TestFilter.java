package org.javaboy.rpc.invoker.test;

import org.javaboy.rpc.invoker.DefaultInvoker;
import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;
import org.javaboy.rpc.invoker.filter.InvokerBuilder;

/**
 * @author majin.wj
 * @date 2023/6/14 11:22 AM
 * @desc
 */
public class TestFilter {

    public static void main(String[] args) {
        HelloService helloService = new HelloService();
        DefaultInvoker defaultInvoker = new DefaultInvoker();
        defaultInvoker.setTarget(helloService);

        Invocation invocation = new Invocation();
        invocation.setMethod("hello");
        invocation.setArgTypes(new Class<?>[]{String.class, Integer.class});
        invocation.setArgs(new Object[]{"码劲", 25});

        InvokerBuilder builder = new InvokerBuilder();
        Invoker invoker = builder.buildInvokerDelegate(defaultInvoker);

        Object invoke = invoker.invoke(invocation);
        System.out.println(invoke);

    }

}
