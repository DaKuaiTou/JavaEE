package com.dkt.web.servlet;

import com.dkt.pojo.Person;
import com.dkt.service.PersonService;
import com.dkt.service.impl.PersonServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.web.servlet.PersonServlet
 * @Date: 2022年11月03日 12:49
 * @Description:
 */
@WebServlet("/person")
public class PersonServlet extends BaseDao {
    // 声明业务层成员变量
    private PersonService personService = new PersonServiceImpl();

    // 校验用户名
    private void checkUsername(HttpServletRequest request, HttpServletResponse response){
        try {
            String username = request.getParameter("username");
            Person person = personService.findPerson(username);
            if(person == null){
                // 用户名可以注册
                response.getWriter().write("用户名可用");
            } else {
                // 用户名已被注册
                response.getWriter().write("用户名已被注册");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
