package com.mifu.yygh.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;
import org.springframework.web.util.pattern.PathPatternParser;

@Configuration
public class CorsConfig {
    // gateway基于webflux
    // springmvc有两套体系，基于:
    // 1、servlet(现在企业大部分是servlet)
    // 2、webflux(异步编程、异步请求，就是对多线程支持比较好)
    @Bean
    public CorsWebFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();

        config.addAllowedMethod("*");//允许所有请求方式
        config.addAllowedOrigin("*");//允许所有请求源
        config.addAllowedHeader("*");//允许所有请求头

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource(new PathPatternParser());
        source.registerCorsConfiguration("/**", config);//允许所有请求路径  /** 表示可以多级


        return new CorsWebFilter(source);
    }
}