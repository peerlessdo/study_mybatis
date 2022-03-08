package com.atgg.mybatis.test;

import com.atgg.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;

public class MybatisTest {

    @Test
    public void testMybatis() throws IOException {
        //加载核心配置文件
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        //获取SqlSessionFactoryBuilder
        SqlSessionFactoryBuilder sqlSessionFactoryBuilder = new SqlSessionFactoryBuilder();
        //获取SqlSessionFactory（是生产SqlSession的工厂）
        SqlSessionFactory sqlSessionFactory = sqlSessionFactoryBuilder.build(inputStream);
        //获取SqlSession（代表Java程序与数据库之间的会话，HttpSession是Java程序与浏览器之间的会话）
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        //获取mapper接口对象
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        //测试功能
        int result = userMapper.insertUser();
        //事务提交
//        sqlSession.commit();
        System.out.println("result: " + result);
    }
}
