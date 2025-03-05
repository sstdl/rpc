package com.sstdl.example.consumer;

import com.sstdl.example.common.model.User;
import com.sstdl.example.common.service.UserService;
import com.sstdl.example.rpc.proxy.ServiceProxyFactory;

/**
 * @author SSTDL
 * @description 消费者启动类
 */
public class EasyConsumerExample {
    public static void main(String[] args) {
        // 动态代理
        UserService userService = ServiceProxyFactory.getProxy(UserService.class);
        User user = new User();
        user.setName("sstdl");
        // 调用
        User newUser = userService.getUser(user);
        if (newUser != null) {
            System.out.println(newUser.getName());
        } else {
            System.out.println("user == null");
        }
    }
}
