package com.dkt.cookie;

import com.dkt.util.CookieUtil;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author: dkt
 * @Pcakage: com.dkt.cookie.Test01
 * @Date: 2022年09月21日 10:00
 * @Description:
 */
@WebServlet(name = "CookieRemember",urlPatterns = "/CookieRemember")
public class CookieRemember extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html; charset=utf-8");

        Cookie[] cookies = req.getCookies();
        String lastTime = CookieUtil.getCookieValue(cookies, "lastTime");
        if(lastTime == null){
            resp.getWriter().write("这是你第一次访问");
        } else {
            resp.getWriter().write("你上次访问的时间是：" + lastTime);
        }

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/hh:mm:ss");
        lastTime = sdf.format(date);
        Cookie cookie = CookieUtil.createAndSetCookie("lastTime", lastTime, 7 * 24 * 60 * 60, req.getContextPath());
        resp.addCookie(cookie);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}
