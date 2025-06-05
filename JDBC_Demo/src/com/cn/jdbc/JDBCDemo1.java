package com.cn.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * JDBC
 */
public class JDBCDemo1 {
	
    public static void main(String[] args) throws Exception {
        //1. 导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象	
    	Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbctest", "root", "2213");
        //Connection conn = DriverManager.getConnection("jdbc:mysql:///jdbctest", "root", "root");
        //4.定义sql语句
        String sql = "update account set balance = 2000";
        //5.获取执行sql的对象 Statement
        Statement stmt = conn.createStatement();
        //6.执行sql 接收返回结果
        int count = stmt.executeUpdate(sql);
        //7.处理结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}
