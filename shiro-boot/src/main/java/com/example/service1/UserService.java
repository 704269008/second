package com.example.service1;

import com.example.pojo.User;

import java.util.List;

public interface UserService {
    String getPassword(String userName);
    User getByName(String userName);
    List<User> list();
    void add(User user);
    void delete(long id);
    User get(long id);
    void update(User user);
}
