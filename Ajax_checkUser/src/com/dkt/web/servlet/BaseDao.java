package com.dkt.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author: dkt
 * @Pcakage: com.dkt.web.servlet.BaseDao
 * @Date: 2022年11月03日 12:43
 * @Description:
 */
public class BaseDao extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数中的值
        String action = req.getParameter("action");

        // Servlet 优化，通过反射的方式处理请求方法的调用
        // 已经知道了方法名称，找到且调用方法，使用反射，获取当前类的字节码对象
        Class aClass = this.getClass();
        try {
            Method method = aClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true); // 取消Java语言访问权限 暴力反射
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
