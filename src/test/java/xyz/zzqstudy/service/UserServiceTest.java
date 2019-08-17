package xyz.zzqstudy.service;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})

public class UserServiceTest {


    @Autowired
    private UserService userService;

//    @Before
//    public void before(){
//        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//        userService = context.getBean("userService", UserService.class);
//    }
//
//    @Test
//    public void checkUserTest(){
//        userService.checkUser("1234567");
//    }
}
