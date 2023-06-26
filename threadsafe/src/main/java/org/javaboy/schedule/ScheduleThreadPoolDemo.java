package org.javaboy.schedule;

import java.util.Date;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author majin.wj
 * @date 2023/6/19 3:12 PM
 * @desc
 */
public class ScheduleThreadPoolDemo {

    public static void main(String[] args) {
        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(10);

        // 固定频率
        executor.scheduleAtFixedRate(()->{

            System.out.println("当前任务开始时间"+new Date());
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },0,3, TimeUnit.SECONDS);



        executor.scheduleWithFixedDelay(()->{

            System.out.println("当前任务开始时间"+new Date());
            try {
                Thread.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }

        },0,3, TimeUnit.SECONDS);

    }

}
