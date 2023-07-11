package org.javaboy.redis.redisson;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RReadWriteLock;
import org.redisson.api.RedissonClient;

public class ReadWriteLockDemo {
    public static void main(String[] args) {
        RedissonClient client = Redisson.create();
        RReadWriteLock lock = client.getReadWriteLock("readWriteLock1");


        RLock rLock = lock.readLock();


        /**
         * 1.如果mode为null，当前没有上任何锁，直接读锁上锁成功
         * 2.如果当前是读锁。直接上，获取如果当前是写锁，但是是当前线程。也可以上。设置各种key，蒙蔽了。
         * commandExecutor.syncedEval(getRawName(), LongCodec.INSTANCE, command,
         *       "local mode = redis.call('hget', KEYS[1], 'mode'); " +
         *       "if (mode == false) then " +
         *       "redis.call('hset', KEYS[1], 'mode', 'read'); " +
         *       "redis.call('hset', KEYS[1], ARGV[2], 1); " +
         *       "redis.call('set', KEYS[2] .. ':1', 1); " +
         *       "redis.call('pexpire', KEYS[2] .. ':1', ARGV[1]); " +
         *       "redis.call('pexpire', KEYS[1], ARGV[1]); " +
         *       "return nil; " +
         *       "end; " +
         *       "if (mode == 'read') or (mode == 'write' and redis.call('hexists', KEYS[1], ARGV[3]) == 1) then " +
         *       "local ind = redis.call('hincrby', KEYS[1], ARGV[2], 1); " +
         *       "local key = KEYS[2] .. ':' .. ind;" +
         *       "redis.call('set', key, 1); " +
         *       "redis.call('pexpire', key, ARGV[1]); " +
         *       "local remainTime = redis.call('pttl', KEYS[1]); " +
         *       "redis.call('pexpire', KEYS[1], math.max(remainTime, ARGV[1])); " +
         *       "return nil; " +
         *       "end;" +
         *       "return redis.call('pttl', KEYS[1]);",
         *       Arrays.<Object>asList(getRawName(), getReadWriteTimeoutNamePrefix(threadId)),
         *       unit.toMillis(leaseTime), getLockName(threadId), getWriteLockName(threadId));
         */
        rLock.tryLock();


        RLock wLock = lock.writeLock();

        /**
         * 通过hash结构实现的读写锁；filed: mode 用来标识当前是读锁还是写锁。
         * 1.如果当前没有锁，写锁上错成功，将mode设置为write，并设置filed：线程id
         * 2.当前已经有写锁，并且是当前自己上的，进行重入次数++
         * 3.当有是读锁模式，或者其他线程获取的写锁，则获取锁失败
         *
         *  commandExecutor.syncedEval(getRawName(), LongCodec.INSTANCE, command,
         *                 "local mode = redis.call('hget', KEYS[1], 'mode'); " +
         *                         "if (mode == false) then " +
         *                         "redis.call('hset', KEYS[1], 'mode', 'write'); " +
         *                         "redis.call('hset', KEYS[1], ARGV[2], 1); " +
         *                         "redis.call('pexpire', KEYS[1], ARGV[1]); " +
         *                         "return nil; " +
         *                         "end; " +
         *                         "if (mode == 'write') then " +
         *                         "if (redis.call('hexists', KEYS[1], ARGV[2]) == 1) then " +
         *                         "redis.call('hincrby', KEYS[1], ARGV[2], 1); " +
         *                         "local currentExpire = redis.call('pttl', KEYS[1]); " +
         *                         "redis.call('pexpire', KEYS[1], currentExpire + ARGV[1]); " +
         *                         "return nil; " +
         *                         "end; " +
         *                         "end;" +
         *                         "return redis.call('pttl', KEYS[1]);",
         *                 Arrays.<Object>asList(getRawName()),
         *                 unit.toMillis(leaseTime), getLockName(threadId));
         *
         */
       /**/
        wLock.tryLock();


    }
}
