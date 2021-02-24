package com.easy.commonutils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

/**
 * @author LiZiHan
 * @since 2021-02-12
 */
public class JwtConfig {
    public static final String secret = "123asdf";//私钥
    public static final long expire = 1000 * 60 * 60 * 24;//过期时间

    public static String getJwtToken(Long id, String name) {
        String JwtToken = Jwts.builder()
                //设置头信息
                .setHeaderParam("typ", "JWT")
                .setHeaderParam("alg", "HS256")
                //设置过期时间
                .setSubject("mes-customer")
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expire))
                //token存储用户信息
                .claim("id", id)
                .claim("name", name)
                //加密方法，生成
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
        return JwtToken;
    }

    /**
     * 校验信息
     *
     * @param jwtToken
     * @return
     */
    public static boolean checkToken(String jwtToken) {
        if (StringUtils.isEmpty(jwtToken)) {
            return false;
        }
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken);//根据密钥验证token
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public static boolean checkToken(HttpServletRequest request) {
        try {
            String jwtToken = request.getHeader("token");
            if (StringUtils.isEmpty(jwtToken)) return false;
            Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * 获取用户信息
     *
     * @param request
     * @return
     */
    public static String getIdByJwtToken(HttpServletRequest request) {
        String jwtToken = request.getHeader("Access-Token");
        if (StringUtils.isEmpty(jwtToken)) {
            return "未接到数据";
        }
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(secret).parseClaimsJws(jwtToken);
        Claims body = claimsJws.getBody();
        return String.valueOf(body.get("id"));
    }

}
