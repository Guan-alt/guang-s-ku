package com.nd.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * 封装Druid连接池的工具类
 */
public class JDBCUtils {
    //1.定义静态变量 DataSource（连接池对象）
    private static DataSource ds ;
    //静态代码快，程序运行时自动加载，且只加载一次，这里是程序一运行就生成一个连接池对象
    static{
        try {
            //1.加载配置文件
            Properties pro = new Properties();
            pro.load(JDBCUtils.class.getClassLoader()
            		.getResourceAsStream("druid.properties"));
            //2.获取DataSource，即连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    /**
     * 获取连接，这里是返回一个连接对象
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

    /**
     * 释放资源
     */
    public static void close(Statement stmt,Connection conn){
        close(null,stmt,conn);//复用下面的close方法
    }

    /**
     * ResultSet rs 执行查询后返回的结果集对象,
     * Statement stmt 用于执行静态SQL语句的对象
     * Connection conn 数据库连接的抽象，负责建立和管理与数据库的连接
     */

    public static void close(ResultSet rs , Statement stmt, Connection conn){
        //分开释放，避免出现资源泄露
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if(conn != null){
            try {
                conn.close();//归还连接
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 获取连接池方法，返回一个连接池对象
     */
    public static DataSource getDataSource(){
        return  ds;
    }

}
