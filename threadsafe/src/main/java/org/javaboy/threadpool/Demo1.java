package org.javaboy.threadpool;


import java.util.concurrent.*;

public class Demo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS, new SynchronousQueue<>());

        for (int i = 0; i < 2; i++) {
            executor.execute(()->{
                System.out.println("task executer");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }



    }
}
