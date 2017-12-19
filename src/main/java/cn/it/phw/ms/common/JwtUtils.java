package cn.it.phw.ms.common;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.Date;

public class JwtUtils {

    private static Key apiKey = MacProvider.generateKey(SignatureAlgorithm.HS256);

    /**
     * 创建JWT字符串
     * @param id 用户id
     * @param iss 发布者
     * @param ttlMillis 有效时间
     * @return 经过签名的jwt字符串
     */
    public static String createJWT(Integer id, String iss, long ttlMillis) {

        long nowMillis = System.currentTimeMillis();

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .setId(String.valueOf(id))
                .setIssuer(iss)
                .setIssuedAt(new Date(nowMillis))
                .signWith(SignatureAlgorithm.HS256, apiKey);

        /*if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            builder.setExpiration(new Date(expMillis));
        }*/

        //builder.signWith(SignatureAlgorithm.HS512, apiKey);

        //Builds the JWT and serializes it to a compact, URL-safe string  
        return builder.compact();
    }

    /**
     * 解析jwt字符串
     * @param jwt 要解析的字符串
     */
    public static Claims parseJWT(String jwt) throws ExpiredJwtException, MalformedJwtException, PrematureJwtException, SignatureException, UnsupportedJwtException {

        //This line will throw an exception if it is not a signed JWS (as expected)
        return Jwts.parser()
                .setSigningKey(apiKey)
                .parseClaimsJws(jwt).getBody();
    }

}
