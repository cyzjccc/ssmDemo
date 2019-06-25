package com.cy.dao;

import com.cy.entity.TbUser;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TbUserMapperTest {

    private ApplicationContext applicationContext;
    @Autowired
    private TbUserMapper tbUserMapper;
    @Autowired
    private TbUser tbUser;

    @Before
    public void setUp() throws Exception {
        // 加载spring配置文件
        applicationContext = new ClassPathXmlApplicationContext("classpath:spring/applicationContext.xml");
        // 导入需要测试的
        tbUserMapper = applicationContext.getBean(TbUserMapper.class);
    }

    @After
    public void tearDown() throws Exception {

    }
//@Autowired:它可以对类成员变量、方法及构造函数进行标注，完成自动装配的工作。
// 通过 @Autowired的使用来消除 set ，get方法。
    @Test
    public void insert(){
        tbUser = new TbUser();
//        tbUser.setId(1);
        tbUser.setUserName("ldh");
        tbUser.setSex("男");
        tbUser.setName("刘德华");
        tbUser.setAge(50);
        tbUser.setPassword("111111");
        System.out.println(tbUserMapper.insert(tbUser));

    }
}