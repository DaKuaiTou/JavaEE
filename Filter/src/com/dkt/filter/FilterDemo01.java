package com.dkt.filter;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.filter.FilterDemo01
 * @Date: 2022年10月12日 18:41
 * @Description:
 */
public class FilterDemo01 implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("FilterDemo01完成初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*servletRequest.setCharacterEncoding("UTF-8");
        // 获取评论的内容
        String content = servletRequest.getParameter("content");
        if(content != null){
            if("你大爷".equals(content)){
                servletResponse.setContentType("text/html; charset=utf-8");
                // 评论内容是非法字符的话
                servletResponse.getWriter().write("评论中含有非法字符，请重新评论");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);*/
    }

    @Override
    public void destroy() {
        System.out.println("FilterDemo销毁");
    }
}
