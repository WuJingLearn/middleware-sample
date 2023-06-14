package org.javaboy.rpc.invoker.filter;

import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;

/**
 * @author majin.wj
 * @date 2023/6/14 11:01 AM
 * @desc filter 和 invoker 是两个完全不同的类型，如何将多个filter串联起来，是需要解决的问题
 * anyway,返回给用户使用的一定还是一个Invoker对象。
 */
public class ParameterCheckFilter implements Filter {
    @Override
    public Object invoke(Invoker invoker, Invocation invocation) {
        return invoker.invoke(invocation);
    }
}
