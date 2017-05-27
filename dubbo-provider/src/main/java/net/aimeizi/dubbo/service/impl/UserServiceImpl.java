package net.aimeizi.dubbo.service.impl;

import net.aimeizi.dubbo.context.DubboFilter;
import net.aimeizi.dubbo.context.SessionHolder;
import net.aimeizi.dubbo.entity.User;
import net.aimeizi.dubbo.service.UserService;

import com.alibaba.dubbo.config.annotation.Service;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public User save(User user) {
        user.setUserId(++UserIdGenerator.id);
        String userName = (String) SessionHolder.get(DubboFilter.USER_INFO);
        System.out.println("useName from dubbo context: " + userName);
        user.setUserName(userName);
        return user;
    }

}
