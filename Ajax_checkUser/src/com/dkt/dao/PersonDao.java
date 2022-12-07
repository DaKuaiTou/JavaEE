package com.dkt.dao;

import com.dkt.pojo.Person;

import java.sql.SQLException;

public interface PersonDao {
    // 查询用户名
    Person findPerson(String username) throws SQLException;
}
