package com.zeta2.springcoredemo.rest;

import com.zeta2.springcoredemo.common.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    //define a private field for the dependency
    private Coach myCoach;

 @Autowired
 public DemoController(@Qualifier("baseballCoach") Coach theCoach) {
     myCoach = theCoach;
 }
 @GetMapping("/dailyworkout")
 public String getDailyWorkout() {
        return myCoach.getDailyWorkout();
    }
}
