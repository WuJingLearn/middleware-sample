package org.javaboy.rpc.invoker.test;

import org.javaboy.rpc.invoker.DefaultInvoker;
import org.javaboy.rpc.invoker.Invocation;
import org.javaboy.rpc.invoker.Invoker;
import org.javaboy.rpc.invoker.wrap.LogInvoker;
import org.javaboy.rpc.invoker.wrap.ParamterCheckInvoker;

/**
 * @author majin.wj
 * @date 2023/6/14 10:35 AM
 * @desc
 */
public class HelloService {


     String hello(String name, Integer age) {
        System.out.println("execute hello method receive name:" + name + ", age:" + age);
        return "success invoke";
    }

}
