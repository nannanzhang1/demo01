package com.itheima;

import com.itheima.domain.User;
import com.itheima.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class MybatisTest2 {
    private SqlSession sqlSession;
    private InputStream inputStream;
   private UserMapper userMapper;

    @Before
    public void before() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        userMapper = sqlSession.getMapper(UserMapper.class);
    }
    @After
    public void after(){
        sqlSession.close();
    }
    @Test
    public void addtest(){
        User user = new User();
        user.setUsername("zhangsan");
        user.setPassword("123");

        userMapper.add(user);


    }
    @Test
    public void deletetest() {
       userMapper.delete(5);

    }
        @Test
    public void findAllTest(){
        List<User> all = userMapper.findAll();
        for (User user : all) {
            System.out.println(user);
        }
    }

    @Test
    public void findByIdTest(){
        User byId = userMapper.findById(2);
        System.out.println(byId);
    }
    @Test
    public void updateTest(){
        User user = new User();
        user.setId(1);
        user.setUsername("zhangsan");
        user.setPassword("123");

        userMapper.add(user);
    }
}
