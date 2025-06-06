package com.nd.datasource.c3p0;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * c3p0配置文件参数的演示
 */
public class C3P0Demo2 {

    public static void main(String[] args) throws SQLException {
    	/*
        //1. 获取DataSource，不传参数使用默认配置
        DataSource ds  = new ComboPooledDataSource();
        //2.获取连接
        for (int i = 1; i <= 10 ; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
            
            if(i == 5){
                conn.close();//归还连接到连接池中
            }
        }
        */
        testNamedConfig();

    }


    public static void testNamedConfig() throws SQLException {
        //1. 获取DataSource，传入参数使用指定名称配置，这里otherc3p0的最大连接数为8，若超过这个数会报错（连接超时）
        DataSource ds  = new ComboPooledDataSource("otherc3p0");
        //2.获取连接
        for (int i = 1; i <= 8 ; i++) {
            Connection conn = ds.getConnection();
            System.out.println(i+":"+conn);
        }
    }

}
