package com.dkt.session;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.session.Test01
 * @Date: 2022年09月21日 11:25
 * @Description:
 */
@WebServlet(name = "SessionTest02",urlPatterns = "/session_02")
public class SessionTest02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String name = (String) session.getAttribute("username");
        System.out.println("从test01中获取的值：" + name);
    }
}
