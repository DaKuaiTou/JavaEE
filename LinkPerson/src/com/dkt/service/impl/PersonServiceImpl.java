package com.dkt.service.impl;

import com.dkt.dao.PersonDao;
import com.dkt.dao.impl.PersonDaoImpl;
import com.dkt.entry.PageBean;
import com.dkt.entry.Person;
import com.dkt.service.PersonService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: dkt
 * @Pcakage: com.dkt.service.impl.PersonServiceImpl
 * @Date: 2022年10月16日 22:01
 * @Description:
 */
public class PersonServiceImpl implements PersonService {
    private static PersonDao personDao = new PersonDaoImpl();

    @Override
    // 查询所有联系人
    public List<Person> findAllPerson() throws SQLException {
        return personDao.findAllPerson();
    }

    @Override
    // 添加联系人
    public void addPerson(Person person) throws SQLException {
        personDao.addPerson(person);
    }

    @Override
    // 删除联系人
    public void deletePerson(Integer id) throws SQLException {
        personDao.deletePerson(id);
    }

    @Override
    // 根据id查询联系人
    public Person findPerson(Integer id) throws SQLException {
        return personDao.findPerson(id);
    }

    @Override
    // 修改联系人
    public void updatePerson(Person person) throws SQLException {
        personDao.updatePerson(person);
    }

    @Override
    // 分页查询联系人
    public PageBean findPersonByPage(Long currentPage, Integer pageSize) throws SQLException {
        PageBean pageBean = new PageBean();
        pageBean.setCurrentPage(currentPage);
        pageBean.setPageSize(pageSize);
        Long totalSize = personDao.findTotalSize();
        pageBean.setTotalSize(totalSize);
        Long totalPage = totalSize%pageSize == 0 ? totalSize/pageSize : (totalSize/pageSize) + 1;
        pageBean.setTotalPage(totalPage);
        List<Person> personList = personDao.findPersonByPage(currentPage,pageSize);
        pageBean.setPersonList(personList);
        return pageBean;
    }
}
