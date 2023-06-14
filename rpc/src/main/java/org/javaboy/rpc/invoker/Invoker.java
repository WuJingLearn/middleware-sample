package org.javaboy.rpc.invoker;

/**
 * @author majin.wj
 * @date 2023/6/14 10:30 AM
 * @desc
 */
public interface Invoker {


    Object invoke(Invocation invocation);

    Class<?> getType();

}
