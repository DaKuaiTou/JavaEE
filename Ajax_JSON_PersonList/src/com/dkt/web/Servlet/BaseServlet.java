package com.dkt.web.Servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Method;

/**
 * @author: dkt
 * @Pcakage: com.dkt.web.Servlet.BaseServlet
 * @Date: 2022年11月05日 14:21
 * @Description:
 */
public class BaseServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String action = req.getParameter("action");
            Class aClass = this.getClass();
            Method method = aClass.getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
            method.setAccessible(true);
            method.invoke(this,req,resp);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
