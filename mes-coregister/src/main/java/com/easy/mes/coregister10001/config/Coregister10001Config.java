package com.easy.mes.coregister10001.config;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 *
 * @author LiZiHan
 * @since 2021-02-10
 */
@Configuration
@MapperScan("com.easy.mes.coregister10001.mapper")
public class Coregister10001Config {
    /**
     * 分页查询
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }
}
