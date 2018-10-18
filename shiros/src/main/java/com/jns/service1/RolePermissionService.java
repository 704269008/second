package com.jns.service1;

import com.jns.pojo.Role;

public interface RolePermissionService {
    public void setPermissions(Role role, long[] permissionIds);
    public void deleteByRole(long roleId);
    public void deleteByPermission(long permissionId);
}
