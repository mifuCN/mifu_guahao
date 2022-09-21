package com.mifu.yygh.user;

import com.mifu.yygh.user.prop.WeixinProperties;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.mifu")
@EnableDiscoveryClient
@EnableFeignClients(basePackages = "com.mifu")
@MapperScan("com.mifu.yygh.user.mapper")
@EnableConfigurationProperties(value = WeixinProperties.class)
public class ServiceUserApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceUserApplication.class, args);
    }
}