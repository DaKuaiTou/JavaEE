package com.dkt.dao.impl;

import com.dkt.dao.PersonDao;
import com.dkt.pojo.Person;
import com.dkt.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import java.sql.SQLException;

/**
 * @author: dkt
 * @Pcakage: com.dkt.dao.impl.PersonDaoImpl
 * @Date: 2022年11月03日 08:12
 * @Description:
 */
public class PersonDaoImpl implements PersonDao {
    // 声明
    QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());

    @Override
    public Person findPerson(String username) throws SQLException {
        return queryRunner.query("select * from person where name=?",new BeanHandler<>(Person.class),username);
    }
}
