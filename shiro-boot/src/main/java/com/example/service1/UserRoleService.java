package com.example.service1;

import com.example.pojo.User;


public interface UserRoleService {
    public void setRoles(User user, long[] roleIds);
    public void deleteByUser(long userId);
    public void deleteByRole(long roleId);
}
