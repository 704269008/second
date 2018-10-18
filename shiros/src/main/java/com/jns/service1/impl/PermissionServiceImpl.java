package com.jns.service1.impl;

import com.jns.dao.RolePermissionMapper;
import com.jns.pojo.RolePermission;
import com.jns.dao.PermissionMapper;
import com.jns.pojo.Permission;
import com.jns.pojo.PermissionExample;
import com.jns.pojo.Role;
import com.jns.pojo.RolePermissionExample;
import com.jns.service1.PermissionService;
import com.jns.service1.RoleService;
import com.jns.service1.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class PermissionServiceImpl implements PermissionService {
    @Autowired
    PermissionMapper permissionMapper;
    @Autowired
    UserService userService;
    @Autowired
    RoleService roleService;
    @Autowired
    RolePermissionMapper rolePermissionMapper;
    @Override
    public Set<String> listPermissions(String userName) {
        Set<String> result = new HashSet<>();
        List<Role> roles = roleService.listRoles(userName);

        List<RolePermission> rolePermissions = new ArrayList<>();

        for (Role role : roles) {
            RolePermissionExample example = new RolePermissionExample();
            example.createCriteria().andRole_idEqualTo(role.getRole_id());
            List<RolePermission> rps= rolePermissionMapper.selectByExample(example);
            rolePermissions.addAll(rps);
        }

        for (RolePermission rolePermission : rolePermissions) {
            Permission p = permissionMapper.selectByPrimaryKey(rolePermission.getPermission_id());
            result.add(p.getResource_name());
        }
        return result;
    }

    @Override
    public List<Permission> list() {
        PermissionExample example =new PermissionExample();
        example.setOrderByClause("resource_id desc");
        return permissionMapper.selectByExample(example);
    }

    @Override
    public void add(Permission permission) {
        permissionMapper.insert(permission);
    }

    @Override
    public void delete(Long id) {
        permissionMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Permission get(Long id) {
        return permissionMapper.selectByPrimaryKey(id);
    }

    @Override
    public void update(Permission permission) {
        permissionMapper.updateByPrimaryKeySelective(permission);
    }

    @Override
    public List<Permission> list(Role role) {
        List<Permission> result = new ArrayList<>();
        RolePermissionExample example = new RolePermissionExample();
        example.createCriteria().andRole_idEqualTo(role.getRole_id());
        List<RolePermission> rps = rolePermissionMapper.selectByExample(example);
        for (RolePermission rolePermission : rps) {
            result.add(permissionMapper.selectByPrimaryKey(rolePermission.getPermission_id()));
        }

        return result;
    }
}
