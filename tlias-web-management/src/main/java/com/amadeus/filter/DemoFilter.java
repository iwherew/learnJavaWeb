package com.amadeus.filter;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

// 三种拦截路径
//@WebFilter(urlPatterns = "/login")
//@WebFilter(urlPatterns = "/depts/*")
//@WebFilter(urlPatterns = "/*")
@Slf4j
public class DemoFilter implements Filter {

    @Override // 初始化方法，只调用一次，默认有实现，可不实现
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override // 拦截到请求之后调用，调用多次
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("demo 拦截到了请求 ... 执行放行前逻辑");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("demo 执行放行后逻辑");
    }

    @Override // 销毁方法，只调用一次，默认有实现，可不实现
    public void destroy() {
        Filter.super.destroy();
    }
}
