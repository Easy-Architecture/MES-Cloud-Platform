package com.easy.mes.file;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.ComponentScan;
/**
 *
 * @author LiZiHan
 * @since 2021-02-14
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
@EnableDiscoveryClient
@ComponentScan(basePackages = {"com.easy"})
public class FileReceiveApplicationMain {
    public static void main(String[] args) {
        SpringApplication.run(FileReceiveApplicationMain.class,args);
    }
}
