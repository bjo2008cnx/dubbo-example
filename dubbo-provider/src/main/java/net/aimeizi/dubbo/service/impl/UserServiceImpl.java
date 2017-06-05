package net.aimeizi.dubbo.service.impl;

import net.aimeizi.dubbo.context.ThreadLocalHolder;
import net.aimeizi.dubbo.context.UserInfoDubboFilter;
import net.aimeizi.dubbo.entity.User;
import net.aimeizi.dubbo.service.UserService;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User save(User user) {
        user.setUserId(++UserIdGenerator.id);
        String userName = (String) ThreadLocalHolder.get(UserInfoDubboFilter.USER_INFO);
        System.out.println("useName from dubbo context: " + userName);
        user.setUserName(userName);
        return user;
    }

}
