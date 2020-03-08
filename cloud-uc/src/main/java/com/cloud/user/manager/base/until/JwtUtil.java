package com.cloud.user.manager.base.until;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import net.sf.json.JSONObject;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Map;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/8 12:57
 * @description：jwt工具类
 * @modified By：
 * @version: 1$
 */
@Component
public class JwtUtil {
    private static Long EXPIRATION_TIME;
    private static String SECRET;
    private static final String TOKEN_PREFIX = "Bearer";
    private static final String HEADER_STRING = "Authorization";

    public JwtUtil(String SECRET, Long EXPIRATION_TIME) {
        this.EXPIRATION_TIME = EXPIRATION_TIME;
        this.SECRET = SECRET;
        System.out.println("正在初始化Jwthelper，expire="+EXPIRATION_TIME);
    }
    public JwtUtil() {
    }
    public static JSONObject generateToken(Map<String, Object> claims) {
        Calendar c = Calendar.getInstance();
        c.setTime(new Date());
        c.add(Calendar.SECOND, EXPIRATION_TIME.intValue());
        Date d = c.getTime();
        String jwt = Jwts.builder()
                .setClaims(claims)
                .setExpiration(d)
                .signWith(SignatureAlgorithm.HS512, SECRET)
                .compact();
        JSONObject json = new JSONObject();
        json.put("token",TOKEN_PREFIX + " " + jwt);
        json.put("token-type", TOKEN_PREFIX);
        json.put("expire-time",new SimpleDateFormat("yyyy-MM-dd HH:ss:mm").format(d) );
        return json;
    }

    public static Map<String, Object> validateTokenAndGetClaims(HttpServletRequest request) {
        String token = request.getHeader(HEADER_STRING);
        System.out.println("token is:"+token);
        if (token == null) {
            return null;
        }
        Map<String, Object> body = Jwts.parser()
                .setSigningKey(SECRET)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody();
        return body;
    }
}
