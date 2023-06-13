package com.zeta2.springcoredemo.common;


import org.springframework.stereotype.Component;

@Component
public class BaseballCoach implements Coach{
    @Override
    public String getDailyWorkout() {
        return "Spend 30 minutes in batting practice";
    }
}
