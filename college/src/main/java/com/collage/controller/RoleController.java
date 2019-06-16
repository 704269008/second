package com.collage.controller;

import com.collage.mapper.RoleMapper;
import com.collage.mapper.UserMapper;
import com.collage.pojo.Role;
import com.collage.pojo.User;
import com.collage.service.ConstantService;
import com.collage.service.RoleService;
import com.collage.utils.constant.Const;
import com.collage.utils.exception.BizExceptionEnum;
import com.collage.utils.exception.GunsException;
import com.collage.utils.node.ZTreeNode;
import com.collage.utils.tips.SuccessTip;
import com.collage.utils.tips.Tip;
import com.collage.utils.util.Convert;
import com.collage.utils.util.ToolUtil;
import com.collage.wrapper.RoleWarpper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    UserMapper userMapper;

    @Autowired
    RoleMapper roleMapper;

    @Autowired
    RoleService roleService;

    @Autowired
    ConstantService constantService;

    protected static SuccessTip SUCCESS_TIP = new SuccessTip();
    private static String PREFIX = "/role/";

    /**
     * 跳转到角色列表页面
     */
    @RequestMapping("")
    public String index() {
        return PREFIX + "/role.html";
    }

    /**
     * 跳转到添加角色
     */
    @RequestMapping(value = "/role_add")
    public String roleAdd() {
        return PREFIX + "/role_add.html";
    }

    /**
     * 跳转到修改角色
     */
    @RequestMapping(value = "/role_edit/{roleId}")
    public String roleEdit(@PathVariable Integer roleId, Model model) {
        if (ToolUtil.isEmpty(roleId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        Role role = this.roleMapper.selectById(roleId);
        model.addAttribute(role);
        model.addAttribute("pName", constantService.getSingleRoleName(role.getPid()));
        return PREFIX + "/role_edit.html";
    }

    /**
     * 跳转到角色分配
     */
    @RequestMapping(value = "/role_assign/{roleId}")
    public String roleAssign(@PathVariable("roleId") Integer roleId, Model model) {
        if (ToolUtil.isEmpty(roleId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        model.addAttribute("roleId", roleId);
        model.addAttribute("roleName", constantService.getSingleRoleName(roleId));
        return PREFIX + "/role_assign.html";
    }

    /**
     * 获取角色列表
     */
    @RequestMapping(value = "/list")
    @ResponseBody
    public Object list(@RequestParam(required = false) String roleName, HttpServletRequest request) {
        List<Map<String, Object>> roles = this.roleMapper.selectRoles(roleName);
        return new RoleWarpper(roles).warp();
    }

    /**
     * 角色新增
     */
    @RequestMapping(value = "/add")
    @ResponseBody
    public Tip add( Role role, BindingResult result) {
        if (result.hasErrors()) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        role.setId(null);
        this.roleMapper.insertRole(role);
        return SUCCESS_TIP;
    }

    /**
     * 角色修改
     */
    @RequestMapping(value = "/edit")
    @ResponseBody
    public Tip edit( Role role, BindingResult result) {
        if (result.hasErrors()) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        this.roleMapper.updateById(role);

        return SUCCESS_TIP;
    }

    /**
     * 删除角色
     */
    @RequestMapping(value = "/remove")
    @ResponseBody
    public Tip remove(@RequestParam Integer roleId) {
        if (ToolUtil.isEmpty(roleId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }

        //不能删除超级管理员角色
        if(roleId.equals(Const.ADMIN_ROLE_ID)){
            throw new GunsException(BizExceptionEnum.CANT_DELETE_ADMIN);
        }

        this.roleService.delRoleById(roleId);

        return SUCCESS_TIP;
    }

    /**
     * 查看角色
     */
    @RequestMapping(value = "/view/{roleId}")
    @ResponseBody
    public Tip view(@PathVariable Integer roleId) {
        if (ToolUtil.isEmpty(roleId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        this.roleMapper.selectById(roleId);
        return SUCCESS_TIP;
    }

    /**
     * 配置权限
     */
    @RequestMapping("/setAuthority")
    @ResponseBody
    public Tip setAuthority(@RequestParam("roleId") Integer roleId, @RequestParam("ids") String ids) {
        if (ToolUtil.isOneEmpty(roleId)) {
            throw new GunsException(BizExceptionEnum.REQUEST_NULL);
        }
        this.roleService.setAuthority(roleId, ids);
        return SUCCESS_TIP;
    }

    /**
     * 获取角色列表
     */
    @RequestMapping(value = "/roleTreeList")
    @ResponseBody
    public List<ZTreeNode> roleTreeList() {
        List<ZTreeNode> roleTreeList = this.roleMapper.roleTreeList();
        roleTreeList.add(ZTreeNode.createParent());
        return roleTreeList;
    }

    /**
     * 获取角色列表
     */
    @RequestMapping(value = "/roleTreeListByUserId/{userId}")
    @ResponseBody
    public List<ZTreeNode> roleTreeListByUserId(@PathVariable Integer userId) {
        User theUser = this.userMapper.selectById(userId);
        String roleid = theUser.getRoleid();
        if (ToolUtil.isEmpty(roleid)) {
            List<ZTreeNode> roleTreeList = this.roleMapper.roleTreeList();
            return roleTreeList;
        } else {
            String[] strArray = Convert.toStrArray(",", roleid);
            List<ZTreeNode> roleTreeListByUserId = this.roleMapper.roleTreeListByRoleId(strArray);
            return roleTreeListByUserId;
        }
    }


}
