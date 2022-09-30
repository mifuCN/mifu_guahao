package com.mifu.yygh.common.utils;

import io.jsonwebtoken.*;
import org.springframework.util.StringUtils;

import java.util.Date;

public class JwtHelper {
    private static long tokenExpiration = 24 * 60 * 60 * 1000; // 一天
    private static String tokenSignKey = "mifu";

    public static String createToken(Long userId, String userName) {
        String token = Jwts.builder()
                .setSubject("YYGH-USER") //设置主题
                .setExpiration(new Date(System.currentTimeMillis() + tokenExpiration)) //设置token的过期时间
                .claim("userId", userId)
                .claim("userName", userName)
                .signWith(SignatureAlgorithm.HS512, tokenSignKey)//使用HS512这个算法,加上盐值
                .compressWith(CompressionCodecs.GZIP)
                .compact();
        return token;
    }

    // 解析用户id
    public static Long getUserId(String token) {
        if (StringUtils.isEmpty(token)) return null;

        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        Integer userId = (Integer) claims.get("userId");
        return userId.longValue();
    }

    // 解析用户名
    public static String getUserName(String token) {
        if (StringUtils.isEmpty(token)) return "";
        Jws<Claims> claimsJws
                = Jwts.parser().setSigningKey(tokenSignKey).parseClaimsJws(token);
        Claims claims = claimsJws.getBody();
        return (String) claims.get("userName");
    }

    public static void main(String[] args) {
        //模拟生成token
        String token = JwtHelper.createToken(1755786251L, "mifu");
        System.out.println("模拟生成的token是: " + token);

        //模拟解析token
        System.out.println("解析到的id是: " + JwtHelper.getUserId("eyJhbGciOiJIUzUxMiIsInppcCI6IkdaSVAifQ.H4sIAAAAAAAAAKtWKi5NUrJSiox099ANDXYNUtJRSq0oULIyNDMzMTU0NDEz0VEqLU4t8kwBipmbmppbmBmZGkLE_BJzU4F6czPTSpVqAabO1V9KAAAA.pXAHqEnGB3oUbI9dZrsiYpU3G0BmFopeLaeb5oyYdRxgtB5bmHQ-elegQo3iGUbIPh-Vi4goo2lZeU9h-QhVRg"));
        System.out.println("解析到的用户名是: " + JwtHelper.getUserName(token));
    }
}