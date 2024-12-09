package com.amadeus.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.Map;

public class JwtUtils {

    private static SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode("AmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeus"));
    private static Long expire = (long) (1000 * 60 * 60 * 24); // 设置有效期24小时

    /**
     * 生成JWT令牌
     * @param claims JWT第二部分负载 payload 中存储的内容
     * @return
     */
    public static String generateJwt(Map<String, Object> claims){
        String jwt = Jwts.builder()
                .claims(claims) // 自定义内容（载荷）
                .expiration(new Date(System.currentTimeMillis() + expire))
                .signWith(secretKey, SignatureAlgorithm.HS256) // 签名算法
                .compact();
        return jwt;
    }

    /**
     * 解析JWT令牌
     * @param jwt JWT令牌
     * @return JWT第二部分负载 payload 中存储的内容
     */
    public static Claims parseJWT(String jwt){
        Claims claims =Jwts.parser()
                .verifyWith(secretKey) // 传递密钥
                .build()
                .parseSignedClaims(jwt) //传递jwt令牌参数
                .getPayload(); // 获取- Payload(有效载荷）
        return claims;
    }
}
