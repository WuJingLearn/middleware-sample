package org.javaboy.rpc.invoker.filter;

import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;

/**
 * @author majin.wj
 * @date 2023/6/14 10:59 AM
 * @desc
 *
 * 使用额外的Filter来进行增强和使用Invoker包装增强的区别是
 */
public interface Filter {

    Object invoke(Invoker invoker, Invocation invocation);

}
