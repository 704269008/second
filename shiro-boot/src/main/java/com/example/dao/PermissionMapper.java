package com.example.dao;


import com.example.pojo.Permission;
import com.example.pojo.PermissionExample;

import java.util.List;


public interface PermissionMapper {
    int deleteByPrimaryKey(Long resource_id);

    int insert(Permission record);

    int insertSelective(Permission record);

    List<Permission> selectByExample(PermissionExample example);

    Permission selectByPrimaryKey(Long resource_id);

    int updateByPrimaryKeySelective(Permission record);

    int updateByPrimaryKey(Permission record);
}