package com.example.service1;

import com.example.pojo.Role;
import com.example.pojo.User;

import java.util.List;
import java.util.Set;

public interface RoleService {
    public Set<String> listRoleNames(String userName);
    public List<Role> listRoles(String userName);
    public List<Role> listRoles(User user);

    public List<Role> list();
    public void add(Role role);
    public void delete(long id);
    public Role get(long id);
    public void update(Role role);
}
