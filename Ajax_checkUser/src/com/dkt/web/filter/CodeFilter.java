package com.dkt.web.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.web.filter.CodeFilter
 * @Date: 2022年11月03日 08:42
 * @Description:
 */
@WebFilter(filterName = "CodeFilter",urlPatterns = "/*")
public class CodeFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将当前的ServletRequest对象强转成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html; charset=utf-8");
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
