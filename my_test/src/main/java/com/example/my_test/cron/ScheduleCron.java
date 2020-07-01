package com.example.my_test.cron;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class ScheduleCron {
    private static SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    //每三秒执行一次
    @Scheduled(fixedDelay = 300)
    public void scheduleTimer() {
        System.out.println("time--" + sf.format(new Date()));
    }



}
