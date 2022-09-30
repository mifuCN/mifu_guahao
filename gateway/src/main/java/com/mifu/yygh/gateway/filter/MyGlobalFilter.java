package com.mifu.yygh.gateway.filter;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import java.util.List;

/**
 * 全局Filter，用来做芾医疗后台管理系用的权限认证
 */
//@Component
public class MyGlobalFilter implements GlobalFilter, Ordered {

    private AntPathMatcher antPathMatcher = new AntPathMatcher();

    //执行过滤功能
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {// exchange就是网关的路由
        ServerHttpRequest request = exchange.getRequest();
        String path = request.getURI().getPath(); //从路由中获取请求路径

        //对于登录接口的请求就不拦截
        if (antPathMatcher.match("/admin/user/**", path)) {
            return chain.filter(exchange);
        } else { //对于非登录接口，验证：必须登录之后才能通过

            List<String> strings = request.getHeaders().get("X-Token");
            if (strings == null) {
                ServerHttpResponse response = exchange.getResponse();
                response.setStatusCode(HttpStatus.SEE_OTHER);
                //路由跳转：
                response.getHeaders().set(HttpHeaders.LOCATION, "http://localhost:9528");
                return response.setComplete();//结束请求

            } else { //放行
                return chain.filter(exchange);
            }

        }
    }

    //影响的是全局过滤器的执行顺序:值越小优先级越高。
    @Override
    public int getOrder() {
        return 0;
    }
}
