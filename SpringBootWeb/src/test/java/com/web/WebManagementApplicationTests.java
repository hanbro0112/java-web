package com.web;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

// @SpringBootTest
public class WebManagementApplicationTests {
    // Raw 密鑰
    private static final String SIGNING_KEY_STR = "webSignKey/sfjhoqp3948927uihrkr13nj23b43k1jr";
    // 新版 密鑰
    private static final SecretKey SIGNING_KEY = Keys.hmacShaKeyFor(SIGNING_KEY_STR.getBytes(StandardCharsets.UTF_8));

    /**
     * 生成JWT
     */
    @Test
    public void testGenJwt() {
        Map<String, Object> claims = new HashMap<>();
        claims.put("id", 1);
        claims.put("name", "tom");

        String jwt = Jwts.builder()
                .header().add("typ", "JWT").add("alg", "HS256").and()
                .claims(claims)
                .expiration(new Date(System.currentTimeMillis() + 3600 * 1000))
                .signWith(SIGNING_KEY)
                .compact();
        System.out.println(jwt);

        testParseJwt(jwt);
    }

    /**
     * 解析JWT
     */
    public void testParseJwt(String token) {
        Claims claims = Jwts.parser()
               .verifyWith(SIGNING_KEY)
               .build()
               .parseSignedClaims(token)
               .getPayload();

       System.out.println("id: " + claims.get("id"));
       System.out.println("name: " + claims.get("name"));
    }
}
