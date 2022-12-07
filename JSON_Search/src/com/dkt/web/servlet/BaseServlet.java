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
 * @Date: 2022年11月05日 08:24
 * @Description:
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取请求参数中的action值
        String action = req.getParameter("action");
        // 使用反射，获取当前类的字节码对象
        try {
            Class aClass = this.getClass();
            Method method = aClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
