package com.dkt.util;



import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: dkt
 * @Date: 2021/11/5 18:09
 */
public class DruidUtil {
    private static DataSource dataSource;
    static{
        try {
            // 1.创建properties对象
            Properties properties = new Properties();
            // 2.将配置文件转换成字节输入流
            InputStream input = DruidUtil.class.getClassLoader().getResourceAsStream("db.properties");
            // 3.使用properties对象加载inputStream
            properties.load(input);
            // 4.druid 底层是使用的工厂模式，去加载配置文件，创建DruidDataSource对象
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
}
