package com.dkt.dao;

import com.dkt.pojo.Words;

import java.sql.SQLException;
import java.util.List;

public interface WordDao {

    // 搜索
    List<Words> search(String keyWord) throws SQLException;
}
