package com.dkt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.filter.FilterEncoding
 * @Date: 2022年10月13日 17:27
 * @Description:
 */
@WebFilter(filterName = "FilterEncoding", urlPatterns = "/*")
public class Encoding implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterEncoding初始化完成");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        servletResponse.setContentType("text/html; charset=utf-8");
        request.setCharacterEncoding("UTF-8");
        filterChain.doFilter(request, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
