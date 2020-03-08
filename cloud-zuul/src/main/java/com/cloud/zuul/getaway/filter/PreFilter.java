package com.cloud.zuul.getaway.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

import javax.servlet.http.HttpServletRequest;

/**
 * @author ：mmzs
 * @date ：Created in 2020/3/8 12:47
 * @description：
 * @modified By：
 * @version: 1$
 */
public class PreFilter extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        System.out.println(
                "Pre Filter: Request Method : " + request.getMethod() + " " +
                        "Request URL : " + request.getRequestURL().toString());

        return null;
    }
}
