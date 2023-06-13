package com.zeta2.springcoredemo.config;

import com.zeta2.springcoredemo.common.Coach;
import com.zeta2.springcoredemo.common.SwimCoach;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SportConfig {
    @Bean
    public Coach swimCoach() {
        return new SwimCoach();
    }
}
