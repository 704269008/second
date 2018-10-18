package com.jns.service1.impl;

import com.jns.dao.RoleMapper;
import com.jns.dao.UserRoleMapper;
import com.jns.pojo.*;
import com.jns.service1.RoleService;
import com.jns.service1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleMapper roleMapper;
    @Autowired
    UserRoleMapper userRoleMapper;
    @Autowired
    UserService userService;
    @Override
    public Set<String> listRoleNames(String userName) {
        Set<String> result=new HashSet<>();
        List<Role> roles=listRoles(userName);
        for(Role role:roles){
            result.add(role.getRole_name());
        }
        return result;
    }

    @Override
    public List<Role> listRoles(String userName) {
        List<Role> roles=new ArrayList<>();
        User user= userService.getByName(userName);
        if(null==user)
            return roles;
        roles=listRoles(user);
        return roles;
    }

    @Override
    public List<Role> listRoles(User user) {
        List<Role> roles=new ArrayList<>();
        UserRoleExample example=new UserRoleExample();
        example.createCriteria().andUser_idEqualTo(user.getUserId());
        List<UserRole> userRoles=userRoleMapper.selectByExample(example);
        for(UserRole userRole:userRoles){
            Role role=roleMapper.selectByPrimaryKey(userRole.getRole_id());
            roles.add(role);
        }
        return roles;
    }

    @Override
    public List<Role> list() {
        RoleExample example=new RoleExample();
        example.setOrderByClause("role_id");
        return roleMapper.selectByExample(example);
    }

    @Override
    public void add(Role role) {
        roleMapper.insert(role);
    }

    @Override
    public void delete(long id) {
        roleMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Role get(long id) {
        return roleMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Role role) {
roleMapper.updateByPrimaryKey(role);
    }
}
