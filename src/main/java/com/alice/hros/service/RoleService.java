package com.alice.hros.service;


import com.alice.hros.mapper.RoleMapper;
import com.alice.hros.service.utils.Hruitls;
import com.alice.hros.model.OpLog;
import com.alice.hros.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Alice
 * @Description
 * @Date 17:37 2021/01/16
 * @Param
 * @return
 **/
@Transactional
@Service
public class RoleService {
    @Autowired
    RoleMapper roleMapper;
    @Autowired
    OplogService oplogService;


    /**
     * @Author Alice
     * @Description  数据初始化
     * @Date 20:42 2021/01/16
     * @Param []
     * @return java.util.List<com.alice.hros.model.Role>
     **/

    public List<Role> getAllRoles() {
        return roleMapper.getAllRoles();
    }

    /**
     * @Author Alice
     * @Description  添加角色权限
     * @Date 20:42 2021/01/16
     * @Param [role]
     * @return java.lang.Integer
     **/

    public Integer addRole(Role role) {
        if (!role.getName().startsWith("ROLE_")) {
            role.setName("ROLE_" + role.getName());
        }
        oplogService.addOpLog(new OpLog((byte) 1,new Date(),"添加角色: " + role.getName(), Hruitls.getCurrent().getName()));
        return roleMapper.insert(role);
    }

    /**
     * @Author Alice
     * @Description 删除角色
     * @Date 20:43 2021/01/16
     * @Param [rid]
     * @return java.lang.Integer
     **/

    public Integer deleteRoleById(Integer rid) {
        oplogService.addOpLog(new OpLog((byte) 1,new Date(),"删除奖惩: id = " + rid, Hruitls.getCurrent().getName()));

        return roleMapper.deleteByPrimaryKey(rid);
    }
}
