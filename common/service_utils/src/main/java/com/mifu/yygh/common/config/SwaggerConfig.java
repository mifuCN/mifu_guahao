package com.mifu.yygh.common.config;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

@SpringBootConfiguration
public class SwaggerConfig {

    @Bean
    public Docket getAdminDocket() {
        return new Docket(DocumentationType.OAS_30)
                .groupName("admin")
                .apiInfo(webApiInfo())
                .select()
                .paths(PathSelectors.regex("/error").negate())//swagger3中去掉base-error-controller的方法
                .build();
    }

    public ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("芾医疗-API文档")
                .description("芾医疗预约挂号平台系统之管理员系统")
                .version("1.0")
                .contact(new Contact("mifu", "https://201314.tk/", "1755786251@qq.com"))
                .build();
    }
}
