package com.dkt.cookie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.cookie.Test01
 * @Date: 2022年09月21日 10:00
 * @Description:
 */
@WebServlet(name = "Test01",urlPatterns = "/cook_01")
public class Test01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 定义一个数据
        String name = "张颜宇";
        // 创建一个cookie，用于存放name的值
        Cookie cookie = new Cookie("username",name);
        // 将cookie添加到response中
        resp.addCookie(cookie);
    }
}
