package com.easy.mes.coregister10001;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
/**
 *<P>
 *     启动类
 *</P>
 * @author LiZiHan
 * @since 2021-02-08
 */

@SpringBootApplication
@EnableDiscoveryClient  //开启nacos
@EnableFeignClients  //开启服务调用
@ComponentScan(basePackages = {"com.easy"})
public class Coregister10001ApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(Coregister10001ApplicationMain.class,args);
    }
}
