package com.cloud.user.manager.base.filter;

import com.cloud.user.manager.base.until.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.util.AntPathMatcher;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/8 13:22
 * @description：jwt过滤器 实现filter接口
 * @modified By：
 * @version: 1$
 */
public class JwtFilter implements Filter {
    private JwtUtil JwtUtil;
    private List<String> urls = null;
    private static final org.springframework.util.PathMatcher pathMatcher = new AntPathMatcher();
    public JwtFilter(JwtUtil JwtUtil, String[] authorisedUrls) {
        this.JwtUtil = JwtUtil;
        urls = Arrays.asList(authorisedUrls);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        //SpringBeanAutowiringSupport.processInjectionBasedOnServletContext(this, filterConfig.getServletContext());
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        httpResponse.setCharacterEncoding("UTF-8");
        httpResponse.setContentType("application/json; charset=utf-8");
        httpResponse.setHeader("Access-Control-Allow-Origin", "*");
        if ("OPTIONS".equals(httpRequest.getMethod())) {
            httpResponse.setStatus(HttpStatus.NO_CONTENT.value()); // HttpStatus.SC_NO_CONTENT = 204
            httpResponse.setHeader("Access-Control-Allow-Credentials", "true");
            httpResponse.setHeader("Access-Control-Allow-Headers", "Content-Type, x-requested-with, Token");
            httpResponse.setHeader("Access-Control-Allow-Methods", "OPTIONS,GET,POST,DELETE,PUT");
        }
        String spath = httpRequest.getServletPath();
        try {
            // 验证受保护的接口
            for (String url : urls) {
                if (pathMatcher.match(url, spath)) {
                    Object token = JwtUtil.validateTokenAndGetClaims(httpRequest);
                    if (token != null) {
                        chain.doFilter(request, response);
                        return;
                    }else{
                        httpResponse.sendError(HttpServletResponse.SC_UNAUTHORIZED, "未授权或者授权已经过期");
                        return;
                    }
                }else{
                    chain.doFilter(request, response);
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        chain.doFilter(request, response);
        return;
    }

    @Override
    public void destroy() {

    }
}
