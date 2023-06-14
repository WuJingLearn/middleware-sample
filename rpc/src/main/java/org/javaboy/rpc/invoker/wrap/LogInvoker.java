package org.javaboy.rpc.invoker.wrap;

import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;

/**
 * @author majin.wj
 * @date 2023/6/14 10:49 AM
 * @desc
 */
public class LogInvoker extends AbstractInvoker{

    public LogInvoker(Invoker delegate) {
        super(delegate);
    }

    @Override
    public Object invoke(Invocation invocation) {
        System.out.println("记录下日志吧: class "+getType()+",method: "+invocation.getMethod()+"方法调用");
        return super.invoke(invocation);
    }
}
