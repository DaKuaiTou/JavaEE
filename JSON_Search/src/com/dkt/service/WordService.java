package com.dkt.service;

import com.dkt.pojo.Words;

import java.sql.SQLException;
import java.util.List;

public interface WordService {
    // 搜索
    List<Words> search(String keyWord) throws SQLException;
}
