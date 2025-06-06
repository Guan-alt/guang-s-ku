package com.nd;

import com.nd.dao.IUserDao;
import com.nd.entity.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * ClassName: test
 * Package: com.nd
 * Dscription:
 *
 * @Author: gw
 * @Creat: 2025/6/6 - 18:44
 */
public class test {
    public static void main(String[] args) throws Exception {
        //1.读取配置文件
        InputStream in = Resources.getResourceAsStream("sqlMapConfig.xml");
        //2.创建 SqlSessionFactory 的构建者对象
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        //3.使用构建者对创建工厂对象
        SqlSessionFactory factory = builder.build(in);
        //4.使用 SqlSessionFactory （工厂对象）生产 sqlSession 对象
        SqlSession session = factory.openSession();
        //5.使用sqlSession 对象创建dao借口的代理对象
        IUserDao userDao = session.getMapper(IUserDao.class);

        //6.使用代理对象执行查询所有方法，并把查询内容放进集合
        List<User> users = userDao.findAll();
        //遍历集合的每个数据
        for (User user : users) {
            System.out.println(user);
        }

        //7.释放资源，先开后关，后开先关
        session.close();
        in.close();
    }
}
