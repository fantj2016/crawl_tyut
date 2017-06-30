package com.laojiao.service;

import com.laojiao.model.User;

/**
 * Created by Super.John on 2017/06/18.
 */
public interface UserService {
    public void addUser(User user);
    public int selectIdByUserName(String username);
}
