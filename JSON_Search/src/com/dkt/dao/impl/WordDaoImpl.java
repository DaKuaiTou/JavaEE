package com.dkt.dao.impl;

import com.dkt.dao.WordDao;
import com.dkt.pojo.Words;
import com.dkt.util.DruidUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: dkt
 * @Pcakage: com.dkt.dao.impl.WordDaoImpl
 * @Date: 2022年11月05日 09:15
 * @Description:
 */
public class WordDaoImpl implements WordDao {

    QueryRunner queryRunner = new QueryRunner(DruidUtil.getDataSource());

    @Override
    // 搜索
    public List<Words> search(String keyWord) throws SQLException {
        String sql = "select * from words where word like ? limit 0,10";
        return queryRunner.query(sql,new BeanListHandler<>(Words.class),"%"+keyWord+"%");
    }
}
