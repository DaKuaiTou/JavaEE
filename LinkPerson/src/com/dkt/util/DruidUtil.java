package com.dkt.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author: dkt
 * @Pcakage: com.dkt.util.DruidUtil
 * @Date: 2022年10月16日 22:06
 * @Description:
 */
public class DruidUtil {
    private static DataSource dataSource;
    static {
        try {
            // 1.创建properties对象
            Properties properties = new Properties();
            // 2.将配置文件转化成字节输入流
            InputStream inputStream = DruidUtil.class.getClassLoader().getResourceAsStream("db.properties");
            // 3.使用properties对象加载inputStream
            properties.load(inputStream);
            // 4.dataSource，底层使用的是工厂模式，去加载配置文件，创建dataSource;
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return dataSource;
    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    public static void release(ResultSet resultSet, Connection connection, Statement statement){
        if(resultSet != null){
            try {
                resultSet.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(connection != null){
            try {
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }
}
