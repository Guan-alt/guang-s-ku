package com.cn.jdbc;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.cn.util.JDBCUtils;

/**
 * 事务操作 转账
 */
public class JDBCDemo10 {


    public static void main(String[] args) {
        Connection conn = null;
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            //1.获取连接
            conn = JDBCUtils.getConnection();
            
            //开启事务
            conn.setAutoCommit(false);

            //2.定义sql
            int count = 500;//转账金额
            //2.1 张三  - count
            String sql1 = "update account set salary = salary - ? where ename = ?";
            //2.2 李四  + count
            String sql2 = "update account set salary = salary + ? where ename = ?";
            //3.获取执行sql对象
            pstmt1 = conn.prepareStatement(sql1);
            pstmt2 = conn.prepareStatement(sql2);
            //4. 设置参数
            pstmt1.setDouble(1,count);
            pstmt1.setString(2, "张三");

            pstmt2.setDouble(1,count);
            pstmt2.setString(2, "李四");
            //5.执行sql
            pstmt1.executeUpdate();
            
            // 手动制造异常
            //int i = 3/0;
            
            pstmt2.executeUpdate();
            
            //提交事务
            conn.commit();
            System.out.println("执行成功!");
            
        } catch (Exception e) {
            //事务回滚
            if(conn != null) {
                try {
					conn.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pstmt1,conn);
            JDBCUtils.close(pstmt2,null);
        }


    }

}
