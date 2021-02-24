package com.easy.mes.order;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient//开启nacos
@EnableFeignClients//开启OpenFeign
@ComponentScan(basePackages = {"com.easy"})
public class OrderApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(OrderApplicationMain.class,args);
    }
}
