package org.javaboy.chain.demo1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author majin.wj
 * @date 2023/6/28 7:41 PM
 * @desc
 * 明确这个责任链是干吗的。
 * 这里的业务逻辑是，每个handler出去不同的业务类型
 */
public class Chain {

    public List<Handler> chain = new ArrayList<>();


    public Object handle(RequestContext request) {

        for (Handler handler : chain) {
            handler.handle(request);
        }

        return request;

    }
}
