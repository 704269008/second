package com.jns.service1;

import com.jns.pojo.User;

public interface UserRoleService {
    public void setRoles(User user, long[] roleIds);
    public void deleteByUser(long userId);
    public void deleteByRole(long roleId);
}
