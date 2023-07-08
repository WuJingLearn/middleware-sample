package org.javaboy.lock.readwritelock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Demo2 {


    /***
     *
     *
     *
     *  static final class ThreadLocalHoldCounter
     *             extends ThreadLocal<HoldCounter> {
     *             public HoldCounter initialValue() {
     *                 return new HoldCounter();
     *             }
     *         }
     *
     *  private transient ThreadLocalHoldCounter readHolds;
     *
     *           rh = readHolds.get();
     *
     *   读锁是线程共享的，读锁也支持重入，读锁的释放的原理是怎样的呢
     *   通过一个ThreadLocalHoldCounter,这是一个ThreadLocal类型，用来记录一个线程，读锁的重入次数。
     *
     * @param args
     */
    public static void main(String[] args) {
        ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();

        ReentrantReadWriteLock.ReadLock readLock = reentrantReadWriteLock.readLock();


        readLock.unlock();;
    }

}
