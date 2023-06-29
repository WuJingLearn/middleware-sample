package org.javaboy.chain.demo1;

/**
 * @author majin.wj
 * @date 2023/6/28 7:45 PM
 * @desc
 */
public class RequestContext {

    Object request;

    Object response;


    public Object getRequest() {
        return request;
    }

    public void setRequest(Object request) {
        this.request = request;
    }

    public Object getResponse() {
        return response;
    }

    public void setResponse(Object response) {
        this.response = response;
    }
}
