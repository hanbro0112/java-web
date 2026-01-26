package com.sky.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.nio.charset.StandardCharsets;
import java.util.Date;
import java.util.Map;

public class JwtUtil {
    /**
     * 創建JWT, HS256
     * @param secretKey 密鑰
     * @param ttlMillis 有效期 毫秒
     * @param claims 自定義聲明
     * @return
     */
    public static String createJWT(String secretKey, long ttlMillis, Map<String, Object> claims) {
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;

        long expMillis = System.currentTimeMillis() + ttlMillis;
        Date exp = new Date(expMillis);

        JwtBuilder builder = Jwts.builder()
                // 如果有私有声明，一定要先设置这个自己创建的私有的声明，这个是给builder的claim赋值，一旦写在标准的声明赋值之后，就是覆盖了那些标准的声明的
                .setClaims(claims)
                .signWith(signatureAlgorithm, secretKey.getBytes(StandardCharsets.UTF_8))
                .setExpiration(exp);

        return builder.compact();
    }

    /**
     * 解析JWT
     * @param secretKey 密鑰
     * @param token JWT字符串
     * @return
     */
    public static Claims parseJWT(String secretKey, String token) {
       Claims claims = Jwts.parser()
               .setSigningKey(secretKey.getBytes(StandardCharsets.UTF_8))
               .parseClaimsJws(token).getBody();
       return claims;
    }
}
