package com.sstdl.example.common.service;

import com.sstdl.example.common.model.User;

/**
 * @author SSTDL
 * @description
 */
public interface UserService {
    /**
     * 获取用户
     *
     * @param user
     * @return
     */
    User getUser(User user);
}
