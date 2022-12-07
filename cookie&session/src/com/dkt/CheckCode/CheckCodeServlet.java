package com.dkt.CheckCode;

import cn.dsna.util.images.ValidateCode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.CheckCode.CheckCodeServlet
 * @Date: 2022年09月22日 08:45
 * @Description:
 */
@WebServlet(name = "CheckCodeServlet",urlPatterns = "/checkCode")
public class CheckCodeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ValidateCode validateCode = new ValidateCode();
        String code = validateCode.getCode();
        req.getSession().setAttribute("code",code);
        validateCode.write(resp.getOutputStream());
    }
}






















