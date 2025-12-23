package com.web.utils;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.security.Keys;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Map;

public class JwtUtils {

    private static SecretKey signKey = Keys.hmacShaKeyFor("webSignKey/sfjhoqp3948927uihrkr13nj23b43k1jr".getBytes(StandardCharsets.UTF_8));
    private static Long expiration = 12 * 3600 * 1000L;

    /**
     * 生成JWT
     * @param claims payload data
     * @return
     */
    public static String generateJwt(Map<String, Object> claims) {
        return Jwts.builder()
                .header().add("typ", "JWT").add("alg", "HS256").and()
                .claims(claims)
                .expiration(new java.util.Date(System.currentTimeMillis() + expiration))
                .signWith(signKey)
                .compact();
    }

    /**
     * 解析JWT
     * @param jwt
     * @return
     */
    public static Claims parseJwt(String jwt) throws ExpiredJwtException, JwtException {
        return Jwts.parser()
                .verifyWith(signKey)
                .build()
                .parseSignedClaims(jwt)
                .getPayload();
    }

}
