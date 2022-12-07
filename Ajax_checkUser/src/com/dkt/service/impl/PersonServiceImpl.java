package com.dkt.service.impl;

import com.dkt.dao.PersonDao;
import com.dkt.dao.impl.PersonDaoImpl;
import com.dkt.pojo.Person;
import com.dkt.service.PersonService;

import java.sql.SQLException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.service.impl.PersonServiceImpl
 * @Date: 2022年11月03日 08:13
 * @Description:
 */
public class PersonServiceImpl implements PersonService {
    // 声明Dao层成
    private PersonDao personDao = new PersonDaoImpl();

    @Override
    // 查询用户
    public Person findPerson(String username) throws SQLException {
        return personDao.findPerson(username);
    }
}
