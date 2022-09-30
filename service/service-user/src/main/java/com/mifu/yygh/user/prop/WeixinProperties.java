package com.mifu.yygh.user.prop;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 该类用来获取配置文件中的键对应的值
 */
@ConfigurationProperties(prefix = "weixin") //去application文件中加载以微信开通的键,属性名得一致
@Data
//读取配置文件的三种方式
//1.@Component+@Value
//2.@Component+@ConfigurationProperties(prefix = "weixin")
//3.@ConfigurationProperties(prefix = "weixin") + 主启动类@EnableConfigurationProperties(value = WeixinProperties.class)
public class WeixinProperties {


    private String appid;
    private String appsecret;
    private String redirecturl;


}
