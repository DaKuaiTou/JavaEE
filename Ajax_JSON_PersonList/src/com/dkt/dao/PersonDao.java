package com.dkt.dao;

import com.dkt.pojo.Person;

import java.sql.SQLException;
import java.util.List;

public interface PersonDao {
    // 查询所有联系人
    List<Person> findAllPerson() throws SQLException;
    // 删除联系人
    void deletePerson(String id) throws SQLException;
    // 根据id查找联系人
    Person findPerson(String id) throws SQLException;
    // 修改联系人信息
    void updatePerson(Person person) throws SQLException;
    // 添加联系人
    void addPerson(Person person) throws SQLException;
    // 查询总条数
    Long findTotalSize() throws SQLException;
    // 查询每页显示数据
    List<Person> findPersonByPage(Long currentPage, Integer pageSize) throws SQLException;
}
