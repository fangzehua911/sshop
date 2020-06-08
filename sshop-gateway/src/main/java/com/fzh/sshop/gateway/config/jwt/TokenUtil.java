package com.fzh.sshop.gateway.config.jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fzh.sshop.gateway.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Date;

/**
 * @author fang
 * @version 1.0
 * @date 2020-5-16 20:09
 */
@Slf4j
public class TokenUtil {
    private static final Logger logger = LoggerFactory.getLogger(TokenUtil.class);
    private static final long EXPIRE_TIME= 15*60*1000;
    private static final String TOKEN_SECRET="dffghgjhjfgherregrgsfgsdfsdgrtgrgtherherghergregergergre";  //密钥盐

    /**
     * 签名生成
     * 使用了HMAC256加密算法。
     * @param user
     * @return
     */
    public static String sign(User user){
        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username", user.getName())
                    .withExpiresAt(expiresAt)
                    .sign(Algorithm.HMAC256(user.getPasswd()+TOKEN_SECRET));
        } catch (Exception e){
            logger.error("jwt_sign：",e.getMessage());
        }
        return token;
    }

    /**
     * 签名验证
     * @param token
     * @return
     */
        public static boolean verify(String token){
        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("issuer: " + jwt.getIssuer());
            System.out.println("username: " + jwt.getClaim("username").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
            return true;
        } catch (Exception e){
            logger.error("jwt_verify：",e.getMessage());
            return false;
        }

    }


}