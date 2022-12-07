package com.dkt;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.DemoTest
 * @Date: 2022年10月08日 10:16
 * @Description:
 */
@WebServlet( name = "DemoTest", urlPatterns = "/demoTest")
public class DemoTest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write(req.getContextPath());
        System.out.println(req.getContextPath());
        System.out.println("张颜宇");
    }
}
