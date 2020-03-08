package com.cloud.user.manager.base.config;

import com.cloud.user.manager.base.filter.JwtFilter;
import com.cloud.user.manager.base.until.JwtUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/8 13:19
 * @description：jwt
 * @modified By：
 * @version: 1$
 */
@Configuration
public class JwtConfig {
    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expire}")
    private long expire;

    @Value("${jwt.authorised-urls}")
    private String[] authorisedUrls;

    @Bean
    public JwtUtil jwtHelperBean() {
        return new JwtUtil(secret, expire);
    }

    @Bean
    public FilterRegistrationBean basicFilterRegistrationBean() {
        FilterRegistrationBean registrationBean = new FilterRegistrationBean();
        JwtFilter filter = new JwtFilter(jwtHelperBean(), authorisedUrls);
        registrationBean.setFilter(filter);
        List<String> urlPatterns = new ArrayList<String>();
        urlPatterns.add("/*");
        registrationBean.setUrlPatterns(urlPatterns);
        return registrationBean;
    }
}
