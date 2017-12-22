package cn.it.phw.ms.common;

import io.jsonwebtoken.*;
import io.jsonwebtoken.impl.crypto.MacProvider;
import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.security.Key;
import java.util.Date;

public class JwtUtils {

    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private static final String _dir = System.getProperty("user.dir");
    private static byte[] encode_secret = null;

    private static void saveApiKey2LocalPath() throws IOException {
        Key apiKey = MacProvider.generateKey(SignatureAlgorithm.HS256);
        encode_secret = apiKey.getEncoded();
        File file = new File(_dir + "private.key");
        if (!file.exists()) {
            file.createNewFile();
            logger.error("success create new file 'private.key' in " + file.getAbsolutePath());
        }
        FileUtils.writeByteArrayToFile(file, encode_secret);

    }

    private static void isSecretEmpty() {
        try {
            File file = new File(_dir + "private.key");
            if (file.exists()) {
                encode_secret = FileUtils.readFileToByteArray(file);
            } else {
                saveApiKey2LocalPath();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 创建JWT字符串
     *
     * @param id        用户id
     * @param iss       发布者
     * @param ttlMillis 有效时间
     * @return 经过签名的jwt字符串
     */
    public static String createJWT(Integer id, String iss, long ttlMillis) {

        isSecretEmpty();

        long nowMillis = System.currentTimeMillis();

        //Let's set the JWT Claims
        JwtBuilder builder = Jwts.builder()
                .setId(String.valueOf(id))
                .setIssuer(iss)
                .setIssuedAt(new Date(nowMillis))
                .signWith(SignatureAlgorithm.HS256, encode_secret);

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
     *
     * @param jwt 要解析的字符串
     */
    public static Claims parseJWT(String jwt) throws ExpiredJwtException, MalformedJwtException, PrematureJwtException, SignatureException, UnsupportedJwtException {

        isSecretEmpty();

        //This line will throw an exception if it is not a signed JWS (as expected)
        return Jwts.parser()
                .setSigningKey(encode_secret)
                .parseClaimsJws(jwt).getBody();
    }

}
