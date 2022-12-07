package com.dkt.CheckCode;

import com.dkt.domain.User;
import com.dkt.util.CookieUtil;
import com.dkt.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.CheckCode.LoginRemberServlet
 * @Date: 2022年10月09日 11:10
 * @Description:
 */
@WebServlet("/rememberLogin")
public class LoginRememberServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");
        String remember = req.getParameter("remember");

        // 将用户存储到cookie中
        Cookie cookie = new Cookie("username",username);
        cookie.setPath(req.getContextPath());

        // 设置cookie的有效期
        if(remember != null){
            cookie.setMaxAge(24*60*60);
        } else {
            cookie.setMaxAge(0);
        }
        // 响应到客户端
        resp.addCookie(cookie);
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute("code");
        if(checkCode==null || checkCode==""){
            String errorMsg = "验证码不能为空";
            req.setAttribute("errorMsg",errorMsg);
            req.getRequestDispatcher("rememberLogin.jsp").forward(req,resp);
        }
        if(checkCode.equalsIgnoreCase(code)){
            try {
                QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
                String sql = "select * from user where username=? and password=?";
                User user = queryRunner.query(sql, new BeanHandler<>(User.class), username, password);
                if(user != null){
                     session.setAttribute("user",user);
                     req.getRequestDispatcher("success.jsp").forward(req,resp);
                } else {
                    String errorMsg = "用户名或密码错误";
                    req.setAttribute("errorMsg",errorMsg);
                    req.getRequestDispatcher("rememberLogin.jsp").forward(req,resp);
                }
            } catch (SQLException throwables) {
                String errorMsg = "登录失败";
                req.setAttribute("errorMsg",errorMsg);
                req.getRequestDispatcher("rememberLogin.jsp").forward(req,resp);
            }
        } else {
            String errorMsg = "验证码输入错误";
            req.setAttribute("errorMsg",errorMsg);
            req.getRequestDispatcher("rememberLogin.jsp").forward(req,resp);
        }

    }
}
