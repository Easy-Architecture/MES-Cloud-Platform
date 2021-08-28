package com.easy.mes.banner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.easy"})
public class BannerApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(BannerApplicationMain.class,args);
    }
}
