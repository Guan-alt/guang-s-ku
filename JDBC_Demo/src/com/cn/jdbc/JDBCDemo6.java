package com.cn.jdbc;

import java.sql.*;

/**
 * 执行DQL语句 RusultSet对象
 */
public class JDBCDemo6 {
    public static void main(String[] args) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            //1. 注册驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取连接对象
            conn = DriverManager.getConnection("jdbc:mysql:///jdbctest", "root", "root");
            //3.定义sql
            String sql  = "select * from account";
            //4.获取执行sql对象
            stmt = conn.createStatement();
            //5.执行sql
            rs = stmt.executeQuery(sql);
            //6.处理结果
            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            int id = rs.getInt("id");
            String ename = rs.getString("ename");
            int salary = rs.getInt("salary");

            System.out.println(id + "---" + ename + "---" + salary);


            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            int id2 = rs.getInt("id");
            String ename2 = rs.getString("ename");
            int salary2 = rs.getInt("salary");

            System.out.println(id2 + "---" + ename2 + "---" + salary2);

            //6.1 让游标向下移动一行
            rs.next();
            //6.2 获取数据
            int id3 = rs.getInt("id");
            String ename3 = rs.getString("ename");
            int salary3 = rs.getInt("salary");

            System.out.println(id3 + "---" + ename3 + "---" + salary3);


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            //7.释放资源
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
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }

}
