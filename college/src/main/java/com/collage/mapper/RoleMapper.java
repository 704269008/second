package com.collage.mapper;

import com.collage.pojo.Role;
import com.collage.utils.node.ZTreeNode;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface RoleMapper {

    Role selectById(int id);
    void deleteById(int id);
    void updateById(Role role);
    void insertRole(Role role);

    /**
     * 根据条件查询角色列表
     *
     * @return
     */
    List<Map<String, Object>> selectRoles(@Param("condition") String condition);

    /**
     * 删除某个角色的所有权限
     *
     * @param roleId 角色id
     * @return
     */
    int deleteRolesById(@Param("roleId") Integer roleId);

    /**
     * 获取角色列表树
     *
     * @return
     */
    List<ZTreeNode> roleTreeList();

    /**
     * 获取角色列表树
     *
     * @return
     */
    List<ZTreeNode> roleTreeListByRoleId(String[] roleId);
}
