package com.angus.service;

import com.angus.dao.pojo.User;
import java.util.List;

public interface UserService
{

    public List<User> getUserByNameAndPassword (User user);

}
