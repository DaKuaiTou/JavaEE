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
@WebServlet(name = "Test03", urlPatterns = "/cook_03")
public class Test03 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置一个参数
        String name = "大块头";
        // 将参数存到cookie中
        Cookie cookie = new Cookie("username", name);
        // 设置cookie的有效期
        cookie.setMaxAge(5);
        // 设置cookie的路径，路径一般为当前项目的路径
        cookie.setPath(req.getContextPath());
        System.out.println(req.getContextPath());
        // 将cookie存到response域对象中
        resp.addCookie(cookie);


    }
}
