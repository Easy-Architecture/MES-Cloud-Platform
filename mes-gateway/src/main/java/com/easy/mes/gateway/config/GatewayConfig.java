//package com.easy.mes.gateway.config;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.cors.CorsConfiguration;
//import org.springframework.web.cors.reactive.CorsWebFilter;
//import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
//import org.springframework.web.util.pattern.PathPatternParser;
//
///**
// * 已在每个controller中加@CrossOrigin注解
// * 使用本方法需要将所有该注解取消掉，否则出现二次跨域问题
// */
//
//@Configuration
//public class GatewayConfig {
//    @Bean
//    public CorsWebFilter corsFilter() {
//        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
//        source.registerCorsConfiguration("/**", buildConfig());
//        return new CorsWebFilter(source);
//    }
//
//    private CorsConfiguration buildConfig() {
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        //在生产环境上最好指定域名，以免产生跨域安全问题
//        corsConfiguration.addAllowedOrigin("*");
//        corsConfiguration.addAllowedHeader("*");
//        corsConfiguration.addAllowedMethod("*");
//        return corsConfiguration;
//    }
//}
