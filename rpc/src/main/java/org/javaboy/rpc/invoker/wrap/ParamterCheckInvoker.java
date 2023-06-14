package org.javaboy.rpc.invoker.wrap;

import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;

/**
 * @author majin.wj
 * @date 2023/6/14 10:46 AM
 * @desc
 */
public class ParamterCheckInvoker extends AbstractInvoker{

    public ParamterCheckInvoker(Invoker delegate) {
        super(delegate);
    }

    @Override
    public Object invoke(Invocation invocation) {
        Object[] args = invocation.getArgs();

        if(args.length < 3) {
            System.out.println("参数长度小于");
        }

        return super.invoke(invocation);
    }
}
