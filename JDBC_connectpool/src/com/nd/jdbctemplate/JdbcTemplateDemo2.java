package com.nd.jdbctemplate;

import org.junit.Test;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import com.nd.domain.Emp;
import com.nd.utils.JDBCUtils;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * JdbcTemplate对数据库的crud操作演示
 * @author Administrator
 *
 */
public class JdbcTemplateDemo2 {

    //Junit单元测试测试方法

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
    
    /**
     * 1. 添加一条记录
     */
    @Test
    public void testUpdate_insert(){
    	//JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());
        String sql = "insert into emp(id,ename,dept_id) values(?,?,?)";
        int count = template.update(sql, 1015, "郭靖", 10);
        System.out.println(count);
    }
    /**
     * 2.删除一条记录
     */
    @Test
    public void testUpdate_delete(){
        String sql = "delete from emp where id = ?";
        int count = template.update(sql, 1015);
        System.out.println(count);
    }
    /**
     * 3. 修改1001号数据的 salary 为 10000
     */
    @Test
    public void testUpdate_update(){
        String sql = "update emp set salary = ? where id = ?";
        int count = template.update(sql,20000,1001);
        System.out.println(count);
    }

    /**
     * 4.查询id为1001的记录，将其封装为Map集合
     * 注意：这个方法查询的结果集只能有1行数据
     */
    @Test
    public void testQueryForMap(){
        String sql = "select * from emp where id = ? ";
        Map<String, Object> map = template.queryForMap(sql, 1001);
        System.out.println(map);
    }

    /**
     * 5. 查询所有记录，将其封装为List
     */
    @Test
    public void testQueryForList(){
        String sql = "select * from emp where mgr = ?";
        List<Map<String, Object>> list = template.queryForList(sql,1004);

        for (Map<String, Object> item : list) {
            System.out.println(item);
        }
    }

    /**
     * 6_1. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void testQuery_1(){
        String sql = "select * from emp";
        List<Emp> list = template.query(sql, new RowMapper<Emp>() {
            @Override
            public Emp mapRow(ResultSet rs, int i) throws SQLException {
                Emp emp = new Emp();
                int id = rs.getInt("id");
                String ename = rs.getString("ename");
                int job_id = rs.getInt("job_id");
                int mgr = rs.getInt("mgr");
                Date joindate = rs.getDate("joindate");
                double salary = rs.getDouble("salary");
                double bonus = rs.getDouble("bonus");
                int dept_id = rs.getInt("dept_id");

                emp.setId(id);
                emp.setEname(ename);
                emp.setJob_id(job_id);
                emp.setMgr(mgr);
                emp.setJoindate(joindate);
                emp.setSalary(salary);
                emp.setBonus(bonus);
                emp.setDept_id(dept_id);

                return emp;
            }
        });

        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 6_2. 查询所有记录，将其封装为Emp对象的List集合
     */
    @Test
    public void testQuery_2(){
        String sql = "select * from emp";
        List<Emp> list = 
        		template.query(sql, new BeanPropertyRowMapper<Emp>(Emp.class));
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    /**
     * 7. 查询总记录数(获取单个列的值或做统计查询 )
     */
    @Test
    public void testQueryForObject(){
        String sql = "select count(id) from emp";
        //Long total = template.queryForObject(sql, Long.class);
        Integer total = template.queryForObject(sql, Integer.class);
        System.out.println(total);
    }

}
