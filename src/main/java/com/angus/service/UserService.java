package com.angus.service;

import com.angus.dao.pojo.User;
import java.util.List;

public interface UserService
{

    public List<User> getUserByNameAndPassword (User user);

    User getUserById (Integer id);

    void updateUserById (Integer id);

    void deleteUserById (Integer id);
}
