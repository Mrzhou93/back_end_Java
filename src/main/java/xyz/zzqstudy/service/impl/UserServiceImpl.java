package xyz.zzqstudy.service.impl;

import org.springframework.stereotype.Service;
import xyz.zzqstudy.dao.UserMapper;
import xyz.zzqstudy.entity.User;
import xyz.zzqstudy.service.UserService;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public void checkUser(String openId) {

        System.out.println("能够进入切面");

        User user = userMapper.getUserById(openId);

        User user1 = new User();
        user1.setOpenId(openId);

        if (user == null){
            userMapper.insertUser(user1);
        }
        System.out.println("切面介绍");
    }
}
