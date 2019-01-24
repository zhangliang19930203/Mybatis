package com.itcast.test;

import com.itcast.dao.UserDao;
import com.itcast.domin.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/*Mybatis入门*/
public class MybatisTest {
    public static void main(String[] args) throws IOException {
        //1.读取配置文件
        InputStream stream = Resources.getResourceAsStream("SqlMapper.xml");
        //2.创建SqlSessionFactory工厂
        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
        SqlSessionFactory factory = builder.build(stream);
        //3.使用工厂生产Session对象
        SqlSession session = factory.openSession();
        //使用SqlSession创建dao接口的代理对象
        UserDao mapper = session.getMapper(UserDao.class);
        //使用代理对象执行方法
        List<User> all = mapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
        //释放资源
        session.close();
        stream.close();
    }
}
