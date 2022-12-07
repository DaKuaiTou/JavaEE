package com.dkt.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author: dkt
 * @Pcakage: com.dkt.utils.DruidUtils
 * @Date: 2022年11月05日 13:52
 * @Description:
 */
public class DruidUtil {
    private static DataSource dataSource;

    static {
        try {
            // 1.创建properties对象
            Properties properties = new Properties();
            // 2.将配置文件转换成字节输入流
            InputStream input = DruidUtil.class.getClassLoader().getResourceAsStream("db.properties");
            // 3.使用properties对象加载inputStream
            properties.load(input);
            // 4.druid 底层是使用的工厂模式，去加载配置文件，创建DruidDataSource对象
            dataSource = DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 获取连接的方法
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    // 获取连接池的方法
    public static DataSource getDataSource(){
        return dataSource;
    }

    // 关闭资源
    public static void release(ResultSet resultSet, Statement statement, Connection connection){
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
