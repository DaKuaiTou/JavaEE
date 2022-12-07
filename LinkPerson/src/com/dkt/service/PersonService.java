package com.dkt.service;

import com.dkt.entry.PageBean;
import com.dkt.entry.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonService {
    // 查询所有联系人
    List<Person> findAllPerson() throws SQLException;
    // 添加联系人
    void addPerson(Person person) throws SQLException;
    // 删除联系人
    void deletePerson(Integer id) throws SQLException;
    // 根据id查询联系人
    Person findPerson(Integer id) throws SQLException;
    // 修改联系人
    void updatePerson(Person person) throws SQLException;
    // 分页查询联系人
    PageBean findPersonByPage(Long currentPage, Integer pageSize) throws SQLException;
}
