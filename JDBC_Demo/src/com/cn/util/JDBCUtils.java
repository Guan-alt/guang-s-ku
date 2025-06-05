package com.cn.util;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 */
public class JDBCUtils {
	public static void main(String[] args) throws SQLException {
		JDBCUtils.getConnection();
	}
	
    private static String url;
    private static String user;
    private static String password;
    private static String driver;
    /**
     * 文件的读取，只读取一次。使用静态代码块。
     */
    static{
        //读取资源文件，获取值。
        try { 
            //1. 创建Properties集合类。
            Properties pro = new Properties();
            //获取src路径下的文件的方式    使用ClassLoader类加载器
            ClassLoader classLoader = JDBCUtils.class.getClassLoader();
            URL res  = classLoader.getResource("jdbc.properties");
            String path = res.getPath();
            System.out.println(path);
            //2. 加载文件
            //D:\develop\eclipse\beijingWork_servlet\JDBC\src\jdbc.properties //绝对路径，不方便
            //pro.load(new FileReader("src/jdbc.properties")); //报错，路径找不到
            pro.load(new FileReader(path));
            //3. 获取数据，赋值
            url = pro.getProperty("url");
            user = pro.getProperty("user");
            password = pro.getProperty("password");
            driver = pro.getProperty("driver");
            //4. 注册驱动
            Class.forName(driver);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }


    /**
     * 获取连接
     * @return 连接对象
     */
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    /**
     * 释放资源
     * @param stmt
     * @param conn
     */
    public static void close(Statement stmt,Connection conn){
        if( stmt != null ){
            try {
                stmt.close();
                //需要分开释放，若释放stmt时失败，后续代码不执行，conn不释放
                //conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * 释放资源
     * @param rs
     * @param stmt
     * @param conn
     */
    public static void close(ResultSet rs,Statement stmt, Connection conn){
        if( rs != null){
            try {
                rs.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if( stmt != null){
            try {
                stmt.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        if( conn != null){
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

}
