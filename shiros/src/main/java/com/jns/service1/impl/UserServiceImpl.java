package com.jns.service1.impl;

import com.jns.dao.UserMapper;
import com.jns.pojo.User;
import com.jns.pojo.UserExample;
import com.jns.service1.UserRoleService;
import com.jns.service1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    UserMapper userMapper;
    @Autowired
    UserRoleService userRoleService;

    @Override
    public String getPassword(String userName) {
        User user=getByName(userName);
        if(null==user)
            return null;
        return user.getUserPassword();
    }

    @Override
    public User getByName(String userName) {
        UserExample example=new UserExample();
        example.createCriteria().andUserNameEqualTo(userName);
        List<User> users=userMapper.selectByExample(example);
        if(users.isEmpty())
            return null;
        return users.get(0);
    }

    @Override
    public List<User> list() {
        UserExample example=new UserExample();
        example.setOrderByClause("user_id desc");
        return userMapper.selectByExample(example);
    }

    @Override
    public void add(User user) {
        userMapper.insert(user);
    }

    @Override
    public void delete(long id) {
        userMapper.deleteByPrimaryKey(id);
        userRoleService.deleteByUser(id);
    }

    @Override
    public User get(long id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(User user) {
        userMapper.updateByPrimaryKeySelective(user);
    }
}
