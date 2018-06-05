package com.yzbbanban.identify.dao;


import com.yzbbanban.identify.entity.User;

/**
 * Created by brander on 2018/3/1
 */
public interface UserDao {

    int addUser(User user);

    User selectUserById(Integer id);

    int updateById(User user);

    int checkUsername(String username);

}
