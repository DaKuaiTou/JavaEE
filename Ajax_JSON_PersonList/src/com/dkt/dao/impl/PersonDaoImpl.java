package com.dkt.dao.impl;

import com.dkt.dao.PersonDao;
import com.dkt.pojo.Person;
import com.dkt.utils.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: dkt
 * @Pcakage: com.dkt.dao.impl.PersonDaoImpl
 * @Date: 2022年11月05日 13:56
 * @Description:
 */
public class PersonDaoImpl implements PersonDao {
    QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());

    @Override
    // 查询所有联系人
    public List<Person> findAllPerson() throws SQLException {
        String sql = "select * from person";
        return queryRunner.query(sql,new BeanListHandler<>(Person.class));
    }

    @Override
    // 删除联系人
    public void deletePerson(String id) throws SQLException {
        String sql = "delete from person where id=?";
        queryRunner.update(sql,id);
    }

    @Override
    // 根据id查找联系人
    public Person findPerson(String id) throws SQLException {
        String sql = "select * from person where id=?";
        return queryRunner.query(sql,new BeanHandler<>(Person.class), id);
    }

    @Override
    // 修改联系人信息
    public void updatePerson(Person person) throws SQLException {
        String sql = "update person set name=?,sex=?,age=?,address=?,qq=?,email=? where id=?";
        queryRunner.update(sql,person.getName(),person.getSex(),person.getAge(),person.getAddress(),person.getQq(),person.getEmail(),person.getId());
    }

    @Override
    // 添加联系人信息
    public void addPerson(Person person) throws SQLException {
        String sql = "insert into person values(null,?,?,?,?,?,?)";
        queryRunner.update(sql,person.getName(),person.getSex(),person.getAge(),person.getAddress(),person.getQq(),person.getEmail());
    }

    @Override
    // 查询联系人总条数
    public Long findTotalSize() throws SQLException {
        String sql = "select count(*) from person";
        return (Long) queryRunner.query(sql,new ScalarHandler());
    }

    @Override
    // 查询每页显示数据
    public List<Person> findPersonByPage(Long currentPage, Integer pageSize) throws SQLException {
        String sql = "select * from person limit ?,?";
        return queryRunner.query(sql,new BeanListHandler<>(Person.class),(currentPage-1)*5,pageSize);
    }
}











