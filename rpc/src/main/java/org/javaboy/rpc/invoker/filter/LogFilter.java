package org.javaboy.rpc.invoker.filter;

import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;

/**
 * @author majin.wj
 * @date 2023/6/14 11:01 AM
 * @desc
 */
public class LogFilter implements Filter {
    @Override
    public Object invoke(Invoker invoker, Invocation invocation) {
        System.out.println("记录下日志吧: class " + invoker.getType() + ",method: " + invocation.getMethod() + "方法调用");
        return invoker.invoke(invocation);
    }
}
