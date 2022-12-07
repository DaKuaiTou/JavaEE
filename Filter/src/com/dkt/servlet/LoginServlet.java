package com.dkt.servlet;

import com.dkt.pojo.User;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           String name = request.getParameter("name");
           String pwd = request.getParameter("pwd");
           if(name.equals("admin") &&pwd.equals("admin")){
               //保存用户对象到session
               User user = new User();
               user.setName(name);
               user.setPwd(pwd);
               request.getSession().setAttribute("user",user);
               response.sendRedirect("index.jsp");
           }else{
               //保存错误消息
               request.setAttribute("error_msg","用户名或密码错误");
               request.getRequestDispatcher("login.jsp").forward(request,response);
           }
    }
}
