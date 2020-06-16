package com.fzh.sshop.config.jwt;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

/**
 * 2019年5月17日17:43:06
 * by: 巴西人
 */
@Slf4j
public class JWTUtil {
    private static String key = "123456789";

    /**
     * @param expireMillis     JWT的过期时间
     * @param username 用户名
     * @return 用户登录成功后生成的 JWT 使用的Hs256算法 私钥使用 用户密码
     */
    public static String createJWT(long expireMillis, String username) {
        //指定签名的时候使用的签名算法，也就是header中的 算法
        SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
        //生成JWT的时间
        long createMillis = System.currentTimeMillis();
        Date createTime = new Date(createMillis);

        //创建payload的私有声明(根据特定的业务需要添加，如果要拿这个做验证,一般是需要和JWT的接受方提前沟通)
        Map<String, Object> claims = new HashMap<String, Object>();
        claims.put("userName", username);
        //生成签发人
        String subject = username;
        //下面就是在为payload添加各种标准声明和私有声明了
        //这里其实就是new一个JWTBuild，设置jwt的body
        JwtBuilder jwtBuilder = Jwts.builder()
                //插入 私有声明
                .setClaims(claims)
                //设置JWT的唯一标识
                .setId(UUID.randomUUID().toString())
                //设置 创建时间
                .setIssuedAt(createTime)
                //设置 唯一所有人 可以存放主键之类的不重复字段作为唯一标识
                .setSubject(subject)
                //设置算法 和 密钥
                .signWith(signatureAlgorithm, key);
        //判断过期时间 如果大于0 则设置过期时间
        if (expireMillis >= 0) {
            long expMillis = createMillis + expireMillis;
            Date exp = new Date(expMillis);
            //设置过期时间
            jwtBuilder.setExpiration(exp);
        }
        return jwtBuilder.compact();
    }

    /**
     * Token解析
     * @param token 被解析 JWT
     * @return 返回payload中存的数据
     */
    public static String  parseJWT(String token){
        Claims claims = Jwts.parser()
                //设置 密钥
                .setSigningKey(key)
                //设置需要解析的 token
                .parseClaimsJws(token).getBody();
        return claims.get("userName").toString();
    }

    /**
     * 验证 token信息 是否正确
     * @param token 被解析 JWT
     * @return 是否正确
     */
    public static Boolean verify(String token){
        try{
            if(StringUtils.isEmpty(token)){
                return false;
            }
            Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            return true;
        }catch (Exception e){
            return false;
        }
    }


}