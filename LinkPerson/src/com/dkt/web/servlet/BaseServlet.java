package com.dkt.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author: dkt
 * @Pcakage: com.dkt.web.servlet.BaseServlet
 * @Date: 2022年10月16日 20:30
 * @Description:
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 第一步，获取请求参数中的action的值
        String action = req.getParameter("action");

        // Servlet优化，通过反射的方式处理请求方法的调用
        // 已经知道方法名称，找到调用方法，使用反射，获取当前类的字节码对象
        Class aClass = this.getClass();
        try {
            Method method = aClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this, req, resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
