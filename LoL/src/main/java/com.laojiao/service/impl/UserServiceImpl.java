package com.laojiao.service.impl;

import com.laojiao.dao.UserMapper;
import com.laojiao.model.User;
import com.laojiao.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Super.John on 2017/06/18.
 */
@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Override
    public void addUser(User user) {
        userMapper.insert(user);
    }

    @Override
    public int selectIdByUserName(String username) {
        userMapper.selectIdByUsername(username);
        return 0;
    }
}
