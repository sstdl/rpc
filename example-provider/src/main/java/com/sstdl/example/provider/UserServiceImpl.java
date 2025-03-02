package com.sstdl.example.provider;

import com.sstdl.example.common.model.User;
import com.sstdl.example.common.service.UserService;

/**
 * @author SSTDL
 * @description
 */
public class UserServiceImpl implements UserService {
    @Override
    public User getUser(User user) {
        System.out.println("用户名：" + user.getName());
        return user;
    }
}
