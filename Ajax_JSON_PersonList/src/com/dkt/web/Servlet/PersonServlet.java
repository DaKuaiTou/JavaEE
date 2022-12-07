package com.dkt.web.Servlet;

import com.alibaba.fastjson.JSON;
import com.dkt.pojo.PageBean;
import com.dkt.pojo.Person;
import com.dkt.pojo.ResultBean;
import com.dkt.service.PersonService;
import com.dkt.service.impl.PersonServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

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
 * @Pcakage: com.dkt.web.Servlet.PersonServlet
 * @Date: 2022年11月05日 14:21
 * @Description:
 */
@WebServlet("/linkPerson")
public class PersonServlet extends BaseServlet {

    private PersonService personService = new PersonServiceImpl();
    private ResultBean resultBean = new ResultBean(true);

    // 查询所有联系人
    private void findAllPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            List<Person> personList = personService.findAllPerson();
            resultBean.setDate(personList);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            // 查询失败
            resultBean.setFlag(false);
            resultBean.setErrorMsg("查询失败");
        }
        String s = JSON.toJSONString(resultBean);
        response.getWriter().write(s);
    }

    // 删除联系人
    private void deletePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String id = request.getParameter("id");
            personService.deletePerson(id);
        } catch (Exception throwables) {
            throwables.printStackTrace();
            resultBean.setFlag(false);
            resultBean.setErrorMsg("删除失败！");
        }
        String result = JSON.toJSONString(this.resultBean);
        response.getWriter().write(result);
    }

    // 根据id查询联系人
    private void findPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            String id = request.getParameter("id");
            Person person = personService.findPerson(id);
            resultBean.setDate(person);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean.setFlag(false);
            resultBean.setErrorMsg("查询联系人失败");
        }
        String jsonString = JSON.toJSONString(resultBean);
        response.getWriter().write(jsonString);
    }

    // 修改联系人信息
    private void updatePerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Person person = new Person();
            BeanUtils.populate(person,parameterMap);
            personService.updatePerson(person);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean.setFlag(false);
            resultBean.setErrorMsg("修改失败");
        }
        String jsonString = JSON.toJSONString(resultBean);
        response.getWriter().write(jsonString);
    }

    // 添加联系人
    private void addPerson(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Map<String, String[]> parameterMap = request.getParameterMap();
            Person person = new Person();
            BeanUtils.populate(person,parameterMap);
            personService.addPerson(person);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean.setFlag(false);
            resultBean.setErrorMsg("添加失败");
        }
        String jsonString = JSON.toJSONString(resultBean);
        response.getWriter().write(jsonString);
    }

    // 分页查询联系人
    private void findPersonByPage(HttpServletRequest request, HttpServletResponse response) throws IOException {
        try {
            Long currentPage = Long.valueOf(request.getParameter("currentPage"));
            Integer pageSize = Integer.valueOf(request.getParameter("pageSize"));
            PageBean pageBean = personService.findPersonByPage(currentPage,pageSize);
            resultBean.setDate(pageBean);
        } catch (Exception e) {
            e.printStackTrace();
            resultBean.setFlag(false);
            resultBean.setErrorMsg("分页查询失败");
        }
        String jsonString = JSON.toJSONString(resultBean);
        response.getWriter().write(jsonString);
    }
}


















