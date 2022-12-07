package com.dkt.service.impl;

import com.dkt.dao.PersonDao;
import com.dkt.dao.impl.PersonDaoImpl;
import com.dkt.pojo.PageBean;
import com.dkt.pojo.Person;
import com.dkt.service.PersonService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: dkt
 * @Pcakage: com.dkt.service.impl.PersonServiceImpl
 * @Date: 2022年11月05日 13:56
 * @Description:
 */
public class PersonServiceImpl implements PersonService {
    private PersonDao personDao = new PersonDaoImpl();

    @Override
    public List<Person> findAllPerson() throws SQLException {
        return personDao.findAllPerson();
    }

    @Override
    public void deletePerson(String id) throws SQLException {
        personDao.deletePerson(id);
    }

    @Override
    public Person findPerson(String id) throws SQLException {
        return personDao.findPerson(id);
    }

    @Override
    public void updatePerson(Person person) throws SQLException {
        personDao.updatePerson(person);
    }

    @Override
    public void addPerson(Person person) throws SQLException {
        personDao.addPerson(person);
    }

    @Override
    public PageBean findPersonByPage(Long currentPage, Integer pageSize) throws SQLException {
        PageBean pageBean = new PageBean();
        // 查询总条数
        Long totalSize = personDao.findTotalSize();
        pageBean.setTotalSize(totalSize);
        // 查询总页数
        Long totalPage = totalSize%pageSize==0 ? totalSize/pageSize : (totalSize/pageSize)+1;
        pageBean.setTotalPage(totalPage);
        // 当前页
        pageBean.setCurrentPage(currentPage);
        // 每页条数
        pageBean.setPageSize(pageSize);
        // 查询每页显示数据
        List<Person> personList = personDao.findPersonByPage(currentPage,pageSize);
        pageBean.setList(personList);
        return pageBean;
    }

}
