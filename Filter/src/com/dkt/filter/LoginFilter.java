package com.dkt.filter;


import com.dkt.pojo.User;
import com.sun.deploy.net.HttpRequest;
import com.sun.deploy.net.HttpResponse;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.filter.LoginFilter
 * @Date: 2022年12月07日 11:41
 * @Description:
 */
@WebFilter(filterName = "LoginFilter",urlPatterns = "/*")
public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String uri = request.getRequestURI();
        if(uri.contains("login.jsp") || uri.contains("/login")){
            filterChain.doFilter(request,response);
        } else {
            User user = (User) request.getSession().getAttribute("user");
            if(user == null){
                response.sendRedirect("login.jsp");
            } else {
                filterChain.doFilter(request,response);
            }
        }
    }

    @Override
    public void destroy() {

    }
}
