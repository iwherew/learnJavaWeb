package com.amadeus;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

//@SpringBootTest
class TliasWebManagementApplicationTests {

    @Test
    public void testUuid(){
        for (int i = 0; i < 1000; i++) {
            String uuid = UUID.randomUUID().toString();
            System.out.println(uuid);
        }
    }

    @Test
    public void testGenJwt(){
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", "1");
        claims.put("name", "iwhere");

        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode("AmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeus"));

        String jwt = Jwts.builder()
                .claims(claims) // 自定义内容（载荷）
                .expiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24)) // 设置有效期24小时
                .signWith(secretKey, SignatureAlgorithm.HS256) // 签名算法
                .compact();

        System.out.println(jwt);
    }

    @Test
    public void testParseJwt(){
        CharSequence jwt = "eyJhbGciOiJIUzI1NiJ9.eyJuYW1lIjoiaXdoZXJlIiwiaWQiOiIxIiwiZXhwIjoxNzMzODExNTA2fQ.75833UxYgpH_53gj1gAUKdMrItAUkjxFcUTEK9eaeBY";
        SecretKey secretKey = Keys.hmacShaKeyFor(Decoders.BASE64.decode("AmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeusAmadeus"));
        Claims claims =Jwts.parser()
                .verifyWith(secretKey) // 传递密钥
                .build()
                .parseSignedClaims(jwt) //传递jwt令牌参数
                .getPayload(); // 获取- Payload(有效载荷）

        System.out.println(claims);//打印内容：{name=iwhere, id=1, exp=1733811506}
    }

}
