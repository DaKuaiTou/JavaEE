package com.dkt.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Set;

/**
 * @author: dkt
 * @Pcakage: com.dkt.request.Test01
 * @Date: 2022年09月20日 09:12
 * @Description:
 */
@WebServlet(name = "Test02",urlPatterns = "/req_02")
public class Test02 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        System.out.println("username: " + username);
        System.out.println("password: " + password);

        String[] fruits = req.getParameterValues("Fruit");
        System.out.println(Arrays.toString(fruits));

        // 获取所有的请求参数，返回Map<String,String[]> 中
        Map<String, String[]> parameterMap = req.getParameterMap();
        // 对Map进行遍历
        Set<Map.Entry<String, String[]>> entries = parameterMap.entrySet();
        for (Map.Entry<String, String[]> entry : entries) {
            String parameterName = entry.getKey();
            String[] values = entry.getValue();
            for (String value : values) {
                System.out.println("参数名称：" + parameterName + "，参数值：" + value);
            }
        }
    }
}
