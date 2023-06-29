package org.javaboy.chain.demo1;

/**
 * @author majin.wj
 * @date 2023/6/28 7:41 PM
 * @desc
 */
public interface Handler {

    Object handle(RequestContext request);


    void setNext(Handler handler);

}
