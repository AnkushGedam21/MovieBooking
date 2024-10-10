package com.techverito.config;

import com.techverito.model.SeatCostTotalRevenue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Scanner;

@Configuration
public class Config {
    @Bean
    public Scanner scanner(){
        return new Scanner(System.in);
    }

    @Bean
    public SeatCostTotalRevenue seatCostTotaoRevenue(){
        return new SeatCostTotalRevenue();
    }
}
