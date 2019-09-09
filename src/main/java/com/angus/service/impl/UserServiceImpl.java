package com.angus.service.impl;

import com.angus.dao.mapper.UserMapper;
import com.angus.dao.pojo.User;
import com.angus.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserServiceImpl implements UserService
{
    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserByNameAndPassword (User user)
    {
        return userMapper.getUserByNameAndPassword(user);
    }
}
