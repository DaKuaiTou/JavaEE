package com.dkt.service.impl;

import com.dkt.dao.WordDao;
import com.dkt.dao.impl.WordDaoImpl;
import com.dkt.pojo.Words;
import com.dkt.service.WordService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author: dkt
 * @Pcakage: com.dkt.service.impl.WordServiceDao
 * @Date: 2022年11月05日 09:16
 * @Description:
 */
public class WordServiceImpl implements WordService {
    private WordDao wordDao = new WordDaoImpl();
    @Override
    public List<Words> search(String keyWord) throws SQLException {
        return wordDao.search(keyWord);
    }
}
