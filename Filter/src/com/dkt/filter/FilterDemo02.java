package com.dkt.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: dkt
 * @Pcakage: com.dkt.filter.FilterDemo02
 * @Date: 2022年10月13日 16:03
 * @Description:
 */
@WebFilter(filterName = "FilterDemo02", urlPatterns = "/*")
public class FilterDemo02 implements Filter {

    private List<String> list = new ArrayList<>();

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        InputStream inputStream = FilterDemo02.class.getClassLoader().getResourceAsStream("illegal.txt");
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));
            String str = null;
            while ((str=bufferedReader.readLine()) != null){
                list.add(str);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                bufferedReader.close();
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String content = servletRequest.getParameter("content");
        for (String s : list) {
            if(s.equals(content)){
                servletResponse.getWriter().write("评论中有敏感字符，请重新评论");
                return;
            }
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }

    @Override
    public void destroy() {

    }
}
