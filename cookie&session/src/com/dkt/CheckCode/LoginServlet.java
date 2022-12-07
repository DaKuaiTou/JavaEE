package com.dkt.CheckCode;

import cn.dsna.util.images.ValidateCode;
import com.dkt.domain.User;
import com.dkt.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.CheckCode.LoginServlet
 * @Date: 2022年09月22日 08:51
 * @Description:
 */
@WebServlet(name = "LoginServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            String checkCode = req.getParameter("checkCode");

            HttpSession session = req.getSession();
            String code = (String) session.getAttribute("code");

            if(checkCode=="" || checkCode==null){
                String errorMsg = "验证码不能为空";
                req.setAttribute("errorMsg",errorMsg);
                req.getRequestDispatcher("checkLogin.jsp").forward(req,resp);
            }
            if(checkCode.equalsIgnoreCase(code)){
                QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());
                String sql = "select * from user where username=? and password=?";
                User user = queryRunner.query(sql, new BeanHandler<>(User.class), username, password);
                if(user != null){
                    session.setAttribute("user",user);
                    resp.sendRedirect("success.jsp");
                } else {
                    String errorMsg = "用户名或密码失败";
                    req.setAttribute("errorMsg",errorMsg);
                    req.getRequestDispatcher("checkLogin.jsp").forward(req,resp);
                }
            } else {
                String errorMsg = "验证码输入错误";
                req.setAttribute("errorMsg",errorMsg);
                req.getRequestDispatcher("checkLogin.jsp").forward(req,resp);
            }
        } catch (SQLException throwables) {
            String errorMsg = "登录失败";
            req.setAttribute("errorMsg",errorMsg);
            req.getRequestDispatcher("checkLogin.jsp").forward(req,resp);
        }
    }
}
