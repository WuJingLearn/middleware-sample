package org.javaboy.threadpool;


import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Demo1 {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 10, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1));

        executor.execute(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        });


        Future<String> submit = executor.submit(() -> {
            return "zs";
        });


        final char[] a = new char[]{'a', 'b'};

//        a = new char[]{'1', '2'};
        a[1] = '2';
        System.out.println(a);

    }
}
