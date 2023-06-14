package org.javaboy.rpc.invoker.filter;

import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;

/**
 * @author majin.wj
 * @date 2023/6/14 11:09 AM
 * @desc 按照需要什么，创建什么的待定思想，创建一个带有Filter和Invoker的包装类。
 *
 * 遍历所有Filter，为每个filter创建一个FilterInvokerDelegate. 最后一个Filter的invoker属性，是我们
 * 最后执行目标方法的DefaultInvoker对象。
 *
 * 第一个Filter创建一个FilterInvokerDelegate，第一个Filter的invoker属性是第二个filter创建的FilterInvokerDelegate
 * 所以
 */
public class FilterInvokerDelegate implements Invoker {

    private Filter filter;
    private Invoker invoker;

    public FilterInvokerDelegate(Filter filter, Invoker invoker) {
        this.filter = filter;
        this.invoker = invoker;
    }

    @Override
    public Object invoke(Invocation invocation) {
        return filter.invoke(invoker, invocation);
    }

    @Override
    public Class<?> getType() {
        return invoker.getType();
    }
}
