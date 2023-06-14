package org.javaboy.rpc.invoker.filter;

import org.javaboy.rpc.invoker.Invoker;

import java.util.ArrayList;
import java.util.List;

/**
 * @author majin.wj
 * @date 2023/6/14 11:15 AM
 * @desc
 */
public class InvokerBuilder {


    private List<Filter> buildFilterChain() {
        List<Filter> filters = new ArrayList<>();
        filters.add(new LogFilter());
        filters.add(new ParameterCheckFilter());
        return filters;
    }

    public Invoker buildInvokerDelegate(Invoker defaultInvker) {
        List<Filter> filters = buildFilterChain();
        Invoker next = defaultInvker;
        for (int i = filters.size() - 1; i >= 0; i--) {
            Filter filter = filters.get(i);
            //构造一层代理
            FilterInvokerDelegate invoker = new FilterInvokerDelegate(filter, next);
            next = invoker;
        }
        return next;

    }

}
