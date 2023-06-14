package org.javaboy.rpc.invoker.wrap;

import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;

/**
 * @author majin.wj
 * @date 2023/6/14 10:43 AM
 * @desc
 */
public abstract class AbstractInvoker implements Invoker {

    private Invoker delegate;

    public AbstractInvoker(Invoker delegate){
        this.delegate = delegate;
    }

    @Override
    public Object invoke(Invocation invocation) {
        return delegate.invoke(invocation);
    }

    public Invoker getDelegate() {
        return delegate;
    }

    @Override
    public Class<?> getType() {
        return delegate.getType();
    }
}
