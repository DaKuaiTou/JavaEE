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
@WebServlet(name = "Test02",urlPatterns = "/cook_02")
public class Test02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 从请求中获取cookie
        Cookie[] cookies = req.getCookies();
        // 遍历cookie
        for (Cookie cookie : cookies) {
            if(cookie.getName().equalsIgnoreCase("username")){
                String value = cookie.getValue();
                System.out.println("从test01中获取的cookie的值：" + value);
            }
        }
    }
}
