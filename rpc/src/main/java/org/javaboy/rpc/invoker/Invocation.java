package org.javaboy.rpc.invoker;

/**
 * @author majin.wj
 * @date 2023/6/14 10:30 AM
 * @desc
 */
public class Invocation {


    String method;
    Class<?>[] argTypes;
    Object[] args;


    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public Class<?>[] getArgTypes() {
        return argTypes;
    }

    public void setArgTypes(Class<?>[] argTypes) {
        this.argTypes = argTypes;
    }

    public Object[] getArgs() {
        return args;
    }

    public void setArgs(Object[] args) {
        this.args = args;
    }
}
