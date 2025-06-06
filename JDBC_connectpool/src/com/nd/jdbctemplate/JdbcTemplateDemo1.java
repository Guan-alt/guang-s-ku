package com.nd.jdbctemplate;

import org.springframework.jdbc.core.JdbcTemplate;

import com.nd.utils.JDBCUtils;

/**
 * JdbcTemplate演示
 */
public class JdbcTemplateDemo1 {

    public static void main(String[] args) {
        //1.导入jar包
        //2.创建JDBCTemplate对象
        JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        //3.调用方法
        String sql = "update account set salary = ? where ename = ? ";
        int count = template.update(sql, 20000,"张三");
        System.out.println(count);
    }
}
