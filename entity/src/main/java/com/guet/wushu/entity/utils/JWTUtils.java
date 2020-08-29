package com.guet.wushu.entity.utils;

import com.guet.wushu.entity.pojo.Administrator;
import com.guet.wushu.entity.pojo.User;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

/**
 * @ClassName JWTUtils
 * @Author asus
 * @Version 1.0
 * Jwt工具类
 */
public class JWTUtils {

    /**
     * 过期时间，一周
     */
    private  static final long EXPIRE = 60000 * 60 * 24 * 7;
    //private  static final long EXPIRE = 1;


    /**
     * 加密秘钥
     */
    private  static final String SECRET = "guetwushu.com";


    /**
     * 令牌前缀
     */
    private  static final String TOKEN_PREFIX = "guetwushu";


    /**
     * subject
     */
    private  static final String SUBJECT = "guetwushu";

    /**
     * 根据用户信息，生成令牌
     * @param user
     * @return
     */
    public static String geneJsonWebUserToken(User user){
        /**
         * signWith为签名，签名算法的描述和所带信息进行加密
         * 防止别人拿到token信息后进行base解密后篡改token
         */
        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("phoneNumber",user.getPhoneNumber())
                .claim("id",user.getId())
                .claim("name",user.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() +
                        EXPIRE))
                .signWith(SignatureAlgorithm.HS256,SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    public static String geneJsonWebAdministratorToken(Administrator administrator) {

        String token = Jwts.builder().setSubject(SUBJECT)
                .claim("id", administrator.getId())
                .claim("name", administrator.getName())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
                .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        token = TOKEN_PREFIX + token;
        return token;
    }

    /**
     * 校验token的方法,Jwts.parser解析token的方法
     * @param token
     * @return
     */
    public static Claims checkJWT(String token){
        try{
            final Claims claims = Jwts.parser().setSigningKey(SECRET)
                    .parseClaimsJws(token.replace(TOKEN_PREFIX,"")).getBody();
            return claims;
        }catch (Exception e){
            return null;
        }
    }
}
