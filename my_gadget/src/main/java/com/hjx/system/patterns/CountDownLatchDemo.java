package com.hjx.system.patterns;

import java.util.concurrent.CountDownLatch;

/**
 * 这里使用 Wiki 的例子
 * 以下是一个一般的，简单的阻碍模式的实现。正如前文所述，注意 “synchronzied” 关键字是如何使用的。如果有
 * 多个线程调用 job 方法，只有一个可以操作，同时其他的调用将会什么都不返回。另一个需要注意的是
 * jobCompleted() 方法。它被设置为线程安全是因为唯一能保证另一个线程能看到一个属性改变的唯一方法就是对所有
 * 能进入它的入口线程安全话或者将它设为 volatile。
 **/
public class CountDownLatchDemo {

    public static void main(String[] args) throws InterruptedException {
        Job job = new Job();
        CountDownLatch countDownLatch = new CountDownLatch(10); //定义倒计时
        for (int i = 0; i < 10; i++) {
            startThread(job, countDownLatch);
        }
        countDownLatch.await(); //阻塞，直到countDown结束
        System.out.println("执行完毕");
    }

    private static void startThread(Job job, CountDownLatch countDownLatch) {
        new Thread(() -> { //递减
            try {
                job.job();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            countDownLatch.countDown();
        }).start();
    }


    static class Job {
        private boolean jobInProgress = false; //job 方法正在操作标志位

        /**
         * job 方法
         **/
        public void job() throws InterruptedException {
            System.out.println(Thread.currentThread() + " 线程进入 job 方法");
            synchronized (this) { //获取调用 job() 方法对象的锁，将其他线程想要获取这个对象的锁时，将会被阻塞
                if (jobInProgress) { //如果 job 方法正在操作标志位为 true
                    System.out.println("job 方法正在被调用，" + Thread.currentThread() + " 线程虽然获取了锁，但是不能进行操作");
                    return; //直接返回
                }
                jobInProgress = true; //否则置为 true
            }
            //执行 job 方法的代码，当进行这段代码时，其他获取该对象的线程可以获取到锁，但是调用 job 方法时都将直接返回
            //...
            System.out.println(Thread.currentThread() + " 线程可以操作 job 方法，开始操作");
            Thread.sleep(10000);
            jobCompleted();
        }

        /**
         * jobComplete 方法
         **/
        void jobCompleted() {
            synchronized (this) { //获取调用 jobCompleted() 方法对象的锁，将其他线程想要获取这个对象的锁时，将会被阻塞
                System.out.println("job 方法操作结束，" + Thread.currentThread() + " 结束操作");
                jobInProgress = false; //重置方法正在操作标志位为 false，直到这时其他线程调用 job 方法才有可能进入 job 真正的操作部分
            }
        }
    }

}
