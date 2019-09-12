package com.angus.service;

import com.angus.dao.pojo.User;
import java.util.List;

public interface UserService
{

    public List<User> getUserByNameAndPassword (User user);

    User getUserById (Integer id);

    void updateUser (User user);

    void deleteUserById (Integer id);

    List<User> getAllUser();

    void addNewUser (User user);
}
