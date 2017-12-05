package cn.it.phw.ms.common;

import cn.it.phw.ms.pojo.User;
import cn.it.phw.ms.service.UserService;
import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.springframework.beans.factory.annotation.Autowired;

import java.security.Key;
import java.util.Date;

public class JwtUtils {

    private static Key apiKey = MacProvider.generateKey();

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
                .setIssuedAt(new Date(nowMillis));

        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            builder.setExpiration(new Date(expMillis));
        }

        builder.signWith(SignatureAlgorithm.HS256, apiKey);

        //Builds the JWT and serializes it to a compact, URL-safe string
        return builder.compact();
    }

    /**
     * 解析jwt字符串
     * @param jwt 要解析的字符串
     */
    public static Object parseJWT(String jwt) throws ClaimJwtException, ExpiredJwtException, MalformedJwtException, PrematureJwtException, SignatureException, UnsupportedJwtException {

        //This line will throw an exception if it is not a signed JWS (as expected)
        Claims claims = Jwts.parser()
                .setSigningKey(apiKey)
                .parseClaimsJws(jwt).getBody();
        System.out.println("ID: " + claims.getId());
        System.out.println("Issuer: " + claims.getIssuer());
        System.out.println("IssuedAt: " + claims.getIssuedAt());
        System.out.println("Expiration: " + claims.getExpiration());
        return claims.getId();
    }

    /**
     * 从JWT获取到userID
     * @param jwt 要解析的字符串
     * @return 用户userID
     * @throws ClaimJwtException
     * @throws MalformedJwtException
     * @throws SignatureException
     * @throws UnsupportedJwtException
     */
    public static Integer parseJWT2Uid(String jwt) throws ClaimJwtException, MalformedJwtException,
                                                            SignatureException, UnsupportedJwtException {
        Claims claims = Jwts.parser()
                .setSigningKey(apiKey)
                .parseClaimsJws(jwt).getBody();

        return Integer.valueOf(claims.getId());
    }


}
