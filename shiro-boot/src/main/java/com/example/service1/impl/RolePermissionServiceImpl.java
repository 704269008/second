package com.example.service1.impl;

import com.example.dao.RolePermissionMapper;
import com.example.pojo.Role;
import com.example.pojo.RolePermission;
import com.example.pojo.RolePermissionExample;
import com.example.service1.RolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RolePermissionServiceImpl implements RolePermissionService {
    @Autowired
    RolePermissionMapper rolePermissionMapper;
    //@Override
    public void setPermissions(Role role, long[] permissionIds) {
        //删除当前角色所有的权限
        RolePermissionExample example= new RolePermissionExample();
        example.createCriteria().andRole_idEqualTo(role.getRole_id());
        List<RolePermission> rps= rolePermissionMapper.selectByExample(example);
        for (RolePermission rolePermission : rps)
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());

        //设置新的权限关系
        if(null!=permissionIds)
            for (long pid : permissionIds) {
                RolePermission rolePermission = new RolePermission();
                rolePermission.setPermission_id(pid);
                rolePermission.setRole_id(role.getRole_id());
                rolePermissionMapper.insert(rolePermission);
            }
    }

    @Override
    public void deleteByRole(long roleId) {
        RolePermissionExample example= new RolePermissionExample();
        example.createCriteria().andRole_idEqualTo(roleId);
        List<RolePermission> rps= rolePermissionMapper.selectByExample(example);
        for (RolePermission rolePermission : rps)
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
    }

    @Override
    public void deleteByPermission(long permissionId) {
        RolePermissionExample example= new RolePermissionExample();
        example.createCriteria().andPermission_idEqualTo(permissionId);
        List<RolePermission> rps= rolePermissionMapper.selectByExample(example);
        for (RolePermission rolePermission : rps)
            rolePermissionMapper.deleteByPrimaryKey(rolePermission.getId());
    }
}
