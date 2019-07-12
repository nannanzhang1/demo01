package com.itheima;

import com.itheima.domain.Order;
import com.itheima.mapper.OrderMapper;
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

public class MybatisTest {
    private SqlSession sqlSession;
    private InputStream inputStream;
    private OrderMapper orderMapper;

    @Before
    public void before() throws IOException {
        inputStream = Resources.getResourceAsStream("sqlMapperConfig.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        sqlSession = sqlSessionFactory.openSession(true);
        orderMapper = sqlSession.getMapper(OrderMapper.class);
    }
    @After
    public void after(){
        sqlSession.close();
    }
    @Test
    public void findAllTest(){
        List<Order> all = orderMapper.findAll();
        for (Order order : all) {
            System.out.println(order);

        }
    }
    @Test
    public void findAllTest2(){
        List<Order> all = orderMapper.findAll();
        for (Order order : all) {
            System.out.println(order);

        }
    }
}
