package com.dkt.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.servlet.CommitServlet
 * @Date: 2022年10月13日 17:03
 * @Description:
 */
@WebServlet(name = "CommitServlet", urlPatterns = "/commit")
public class CommitServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取评论内容
        String content = req.getParameter("content");
        // 输出评论内容
        resp.setContentType("text/html; charset=utf-8");
        resp.getWriter().write("评论成功，评论内容是：" + content);
    }
}
