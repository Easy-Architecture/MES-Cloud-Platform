package com.easy.mes.login;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.easy"})
public class LoginApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(LoginApplicationMain.class,args);
    }
}
