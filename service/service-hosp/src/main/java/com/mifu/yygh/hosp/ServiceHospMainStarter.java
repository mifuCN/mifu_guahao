package com.mifu.yygh.hosp;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(value = "com.mifu.yygh")
@MapperScan(value = "com.mifu.yygh.hosp.mapper")
@EnableDiscoveryClient //@EnableEurekaClient
@EnableFeignClients(basePackages = "com.mifu.yygh")
public class ServiceHospMainStarter {

    public static void main(String[] args) {
        SpringApplication.run(ServiceHospMainStarter.class, args);
    }
}
