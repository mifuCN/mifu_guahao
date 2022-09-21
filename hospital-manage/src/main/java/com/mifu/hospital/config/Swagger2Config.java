package com.mifu.hospital.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * Swagger2配置信息
 * @author mifu
 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket webApiConfig(){

        return new Docket(DocumentationType.OAS_30)
                .apiInfo(webApiInfo())
                .select()
                .paths(PathSelectors.regex("/error").negate())//swagger3中去掉base-error-controller的方法
                .build();

    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("第三方医院系统-API文档")
                .description("本文档描述了网站微服务接口定义")
                .version("1.0")
                .contact(new Contact("mifu", "https://201314.tk/", "1755786251@qq.com"))
                .build();
    }
}
