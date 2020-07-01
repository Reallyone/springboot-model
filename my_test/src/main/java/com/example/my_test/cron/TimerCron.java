package com.example.my_test.cron;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.SimpleFormatter;

public class TimerCron {

    private static SimpleDateFormat sf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //延迟几秒执行

    public void delayTimer() {
        for (int i = 0; i < 10; i++) {
           /* Timer timer = new Timer("timer - " + i);
            timer.schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println((Thread.currentThread().getName() + " run --> time--" + sf.format(new Date())));
                    timer.cancel();
                }
            }, 1000);*/
             new Timer("timer - "+i).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println((Thread.currentThread().getName() + " run --> time--"+sf.format(new Date()) ));
                    //执行完了以后对timer进行释放
                    cancel();
                }
            },1000);
        }
        //执行案
        System.gc();
    }

    //指定时常运行
    public void appointTimer() {

        for (int i = 0; i < 10; i++) {
            new Timer("timer - " + i).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println((Thread.currentThread().getName() + " run --> time--"+sf.format(new Date()) ));
                    //执行完了以后对timer进行释放
                    cancel();
                }
            }, new Date(System.currentTimeMillis() + 2000));
        }
        //执行案
        System.gc();
    }

    //延迟后多少s后 每隔多少时间执行
    public void dalayAppointTimer() {
        for (int i = 0; i < 10; i++) {
            new Timer("timer - " + i).schedule(new TimerTask() {
                @Override
                public void run() {
                    System.out.println((Thread.currentThread().getName() + " run --> time--"+sf.format(new Date()) ));
                    //执行完了以后对timer进行释放
                    cancel();
                }
            }, 2000, 3000);
        }
        //执行案
        System.gc();
    }

    public static void main(String[] args) {
        TimerCron timerCron = new TimerCron();
       // timerCron.delayTimer();
        timerCron.dalayAppointTimer();

    }


}
