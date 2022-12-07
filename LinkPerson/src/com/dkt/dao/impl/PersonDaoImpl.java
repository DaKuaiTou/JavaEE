package com.dkt.dao.impl;

import com.dkt.dao.PersonDao;
import com.dkt.entry.PageBean;
import com.dkt.entry.Person;
import com.dkt.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: dkt
 * @Pcakage: com.dkt.dao.impl.PersonDaoImpl
 * @Date: 2022年10月16日 22:03
 * @Description:
 */
public class PersonDaoImpl implements PersonDao {

    private QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());

    @Override
    // 查询所有联系人
    public List<Person> findAllPerson() throws SQLException {
        String sql = "select * from person";
        List<Person> personList = queryRunner.query(sql, new BeanListHandler<>(Person.class));
        return personList;
    }

    @Override
    // 添加联系人
    public void addPerson(Person person) throws SQLException {
        String sql = "insert into person values(null,name=?,?,?,?,?,?);";
        queryRunner.update(sql,person.getName(),person.getSex(),person.getAge(),person.getAddress(),person.getQq(),person.getEmail());
    }

    @Override
    // 删除联系人
    public void deletePerson(Integer id) throws SQLException {
        String sql = "delete from person where id=?";
        queryRunner.update(sql,id);
    }

    @Override
    // 根据id查询联系人
    public Person findPerson(Integer id) throws SQLException {
        String sql = "select * from person where id=?";
        return queryRunner.query(sql,new BeanHandler<>(Person.class),id);
    }

    @Override
    // 修改联系人信息
    public void updatePerson(Person person) throws SQLException {
        String sql = "update person set name=?,sex=?,age=?,address=?,qq=?,email=? where id=?";
        queryRunner.update(sql,person.getName(),person.getSex(),person.getAge(),person.getAddress(),person.getQq(),person.getEmail(),person.getId());
    }

    @Override
    // 查询总条数
    public Long findTotalSize() throws SQLException {
        String sql = "select count(*) from person";
        Long totalSize = (Long) queryRunner.query(sql, new ScalarHandler());
        return totalSize;
    }

    @Override
    // 查询总页数
    public List<Person> findPersonByPage(Long currentPage, Integer pageSize) throws SQLException {
        String sql = "select * from person limit ?,?";
        List<Person> personList = queryRunner.query(sql, new BeanListHandler<>(Person.class), (currentPage -1) * pageSize, pageSize);
        return personList;
    }
}

