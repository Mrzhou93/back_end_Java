package xyz.zzqstudy.dao;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xyz.zzqstudy.entity.User;

import java.io.IOException;

@RunWith(SpringJUnit4ClassRunner.class)     //表示继承了SpringJUnit4ClassRunner类
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml",
        "classpath:dispatcher-servlet.xml"})

public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Before
    public void init() throws IOException {
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        userMapper = (UserMapper) context.getBean("userMapper");
    }

    @After
    public void destory() throws IOException {

    }

    @Test
    public void findByIdTest(){
        User user = (User) userMapper.getUserById("1234567");
        System.out.println(user);
        User user1 = (User) userMapper.getUserById("1234568");
        System.out.println(user1);
    }

//    @Test
//    public void insertUserTest(){
//        User user1 = new User();
//        user1.setOpenId("123456780");
//        user1.setNickName("MrZhou");
//
//        int result = userMapper.insertUser(user1);
//
//        System.out.println(result);
//    }
//
//    @Test
//    public void updateUserTest(){
//        User user = new User();
//        user.setOpenId("123456780");
//        user.setNickName("Mr");
//
//        int result = userMapper.updateUser(user);
//
//        System.out.println(result);
//    }
}
