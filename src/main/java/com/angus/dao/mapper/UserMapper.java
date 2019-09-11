package com.angus.dao.mapper;

import com.angus.dao.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;


public interface UserMapper
{
    List<User> getUserByNameAndPassword(User user);

    User getUserById(Integer Id);

    void updateUser(User user);

    void deleteUserById(Integer id);

    List<User> getAllUser();
}
