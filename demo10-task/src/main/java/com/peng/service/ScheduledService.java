package com.peng.service;


import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
public class ScheduledService {
    /*
    *
    * */

    @Scheduled(cron = "0 58 20 * * ?")
    public void hello(){
        System.out.println("到点操小平");
    }
}
