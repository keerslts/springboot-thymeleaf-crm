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

    @Override
    public User getUserById (Integer id)
    {
        return userMapper.getUserById(id);
    }

    @Override
    public void updateUser (User user)
    {
        userMapper.updateUser(user);
    }

    @Override
    public void deleteUserById (Integer id)
    {
        userMapper.deleteUserById(id);
    }

    @Override
    public List<User> getAllUser() {
        return userMapper.getAllUser();
    }

    @Override
    public void addNewUser (User user)
    {
        userMapper.addNewUser(user);
    }
}
