package com.lunchsystem.backend.services;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

/*
This class check order lifetime
*/

@Service
@Async("taskExecutor")
public class CheckOrderLifeTime implements Runnable{
    @Override
    public void run() {
        try {
            while (true) {
                System.out.println(LocalDateTime.now());
                Thread.sleep(3600 * 1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
