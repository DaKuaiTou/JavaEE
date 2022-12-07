package com.dkt.web.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.web.filter.AjaxEncodingFilter
 * @Date: 2022年10月30日 16:09
 * @Description:
 */
@WebFilter("/*")
public class AjaxEncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        // 将当前的servletRequest对象强转成HttpServletRequest
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        request.setCharacterEncoding("utf-8");
        filterChain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
