package com.amadeus.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 多个过滤器按照名称排序顺序进行执行
// 执行顺序： AbcFilter 放行前 -> AbcFilter 放行 -> DemoFilter 放行前 -> DemoFilter 放行 -> Web资源处理 -> DemoFilter 放行后 -> AbcFilter 放行后
//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("abc 拦截到了请求 ... 执行放行前逻辑");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("abc 执行放行后逻辑");
    }
}
