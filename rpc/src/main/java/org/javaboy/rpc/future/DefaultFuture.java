package org.javaboy.rpc.future;

import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author majin.wj
 * @date 2023/6/13 3:27 PM
 * @desc
 */
public class DefaultFuture extends CompletableFuture<Object> {

    private static final Map<Long, DefaultFuture> FUTURE_MAP = new ConcurrentHashMap<>();
    private static final AtomicLong NUM = new AtomicLong();

    private Long id;

    public DefaultFuture() {
        this.id = NUM.getAndIncrement();
        FUTURE_MAP.put(this.id, this);
    }


}
