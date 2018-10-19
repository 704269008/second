package com.example.service1.impl;

import com.example.dao.UserRoleMapper;
import com.example.pojo.UserRole;
import com.example.pojo.UserRoleExample;
import com.example.service1.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class UserRoleServiceImpl implements UserRoleService{
    @Autowired
    UserRoleMapper userRoleMapper;
    @Override
    public void setRoles(com.example.pojo.User user, long[] roleIds) {
        //删除当前用户所有的角色
        UserRoleExample example= new UserRoleExample();
        example.createCriteria().andUser_idEqualTo(user.getUserId());
        List<UserRole> urs= userRoleMapper.selectByExample(example);
        for (UserRole userRole : urs)
            userRoleMapper.deleteByPrimaryKey(userRole.getId());
        //设置新的角色关系
        if(null!=roleIds)
            for (Long rid : roleIds) {
                UserRole userRole = new UserRole();
                userRole.setUser_id(user.getUserId());
                userRole.setRole_id(rid);
                userRoleMapper.insert(userRole);
            }
    }

    @Override
    public void deleteByUser(long userId) {
        UserRoleExample example= new UserRoleExample();
        example.createCriteria().andUser_idEqualTo(userId);
        List<UserRole> urs= userRoleMapper.selectByExample(example);
        for (UserRole userRole : urs) {
            userRoleMapper.deleteByPrimaryKey(userRole.getId());
        }
    }

    @Override
    public void deleteByRole(long roleId) {
        UserRoleExample example= new UserRoleExample();
        example.createCriteria().andRole_idEqualTo(roleId);
        List<UserRole> urs= userRoleMapper.selectByExample(example);
        for (UserRole userRole : urs) {
            userRoleMapper.deleteByPrimaryKey(userRole.getId());
        }
    }
}
