package com.dkt.web.servlet;

import com.dkt.entry.PageBean;
import com.dkt.entry.Person;
import com.dkt.service.PersonService;
import com.dkt.service.impl.PersonServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * @author: dkt
 * @Pcakage: com.dkt.web.servlet.PersonServlet
 * @Date: 2022年10月16日 21:58
 * @Description:
 */
@WebServlet(name = "PersonServlet",urlPatterns = "/linkPerson")
public class PersonServlet extends BaseServlet {

    private static PersonService personService = new PersonServiceImpl();

    // 分页查看联系人信息
    private void findPersonByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Long currentPage = Long.valueOf(request.getParameter("currentPage"));
            Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
            PageBean pageBean = personService.findPersonByPage(currentPage,pageSize);
            request.setAttribute("pageBean",pageBean);
            request.getRequestDispatcher("list_page.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("分页查询失败");
        }
    }

    // 根据id查询联系人
    private void findPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            Person person = personService.findPerson(id);
            request.setAttribute("person",person);
            request.getRequestDispatcher("update.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("查询失败");
        }
    }

    // 修改联系人
    private void updatePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Person person = new Person();
            BeanUtils.populate(person,parameterMap);
            personService.updatePerson(person);
            response.sendRedirect("linkPerson?action=findAllPerson");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("修改失败");
        }
    }

    // 删除联系人
    private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Integer id = Integer.valueOf(request.getParameter("id"));
            personService.deletePerson(id);
            response.sendRedirect("linkPerson?action=findAllPerson");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("删除失败");
        }
    }

    // 添加联系人
    private void addPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {

        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Person person = new Person();
            BeanUtils.populate(person,parameterMap);
            personService.addPerson(person);
            response.sendRedirect("linkPerson?action=findAllPerson");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("添加失败");
        } 

    }

    // 查询所有联系人
    private void findAllPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Person> personList = personService.findAllPerson();
            request.setAttribute("personList",personList);
            request.getRequestDispatcher("list.jsp").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().write("查询所有联系人失败");
        }
    }
}




















