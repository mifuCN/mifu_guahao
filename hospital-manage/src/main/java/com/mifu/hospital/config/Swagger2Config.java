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
 *
 * @author mifu
 */
@Configuration
public class Swagger2Config {

    @Bean
    public Docket webApiConfig() {

        return new Docket(DocumentationType.OAS_30)
                .groupName("fu")
                .apiInfo(webApiInfo())
                .select()
                .paths(PathSelectors.regex("/error").negate())//swagger3中去掉base-error-controller的方法
                .build();

    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("第三方医院资料导入系统-API文档")
                .description("长风破浪会有时,直挂云帆济沧海")
                .version("1.0")
                .contact(new Contact("MiFu的Blog", "https://201314.tk/", "1755786251@qq.com"))
                .build();
    }
}
