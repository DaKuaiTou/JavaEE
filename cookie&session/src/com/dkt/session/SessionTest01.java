package com.dkt.session;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.session.Test01
 * @Date: 2022年09月21日 11:25
 * @Description:
 */
@WebServlet(name = "SessionTest01",urlPatterns = "/session_01")
public class SessionTest01 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 设置一个参数
        String name = "大块头";
        HttpSession session = req.getSession();

        Cookie cookie = new Cookie("JESSIONID",session.getId());
        cookie.setMaxAge(60);
        cookie.setPath(req.getContextPath());

        resp.addCookie(cookie);
        session.setAttribute("username",name);
    }
}
