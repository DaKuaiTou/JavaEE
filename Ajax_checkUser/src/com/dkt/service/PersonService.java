package com.dkt.service;

import com.dkt.pojo.Person;

import java.sql.SQLException;

public interface PersonService {
    // 查询用户名
    Person findPerson(String username) throws SQLException;
}
