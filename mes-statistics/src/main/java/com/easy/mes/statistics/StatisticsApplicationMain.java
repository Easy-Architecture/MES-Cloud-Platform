package com.easy.mes.statistics;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableDiscoveryClient
@EnableFeignClients
@EnableScheduling//开启定时任务
@ComponentScan(basePackages = {"com.easy"})
public class StatisticsApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(StatisticsApplicationMain.class,args);
    }
}
