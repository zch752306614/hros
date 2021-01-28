package com.alice.hros.controller.system.basic;


import com.alice.hros.model.Menu;
import com.alice.hros.model.RespBean;
import com.alice.hros.model.Role;
import com.alice.hros.service.MenuService;
import com.alice.hros.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Alice
 * @Description
 * @Date 17:21 2021/01/16
 * @Param
 * @return
 **/
@Api(tags = "权限管理")
@RestController
@RequestMapping("/system/basic/permiss")
public class PermissController {
    @Autowired
    RoleService roleService;
    @Autowired
    MenuService menuService;

    @GetMapping("/")
    @ApiOperation("获取所有角色")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    /**
     * @return java.util.List<com.alice.hros.model.Menu>
     * @Author Alice
     * @Description 系統設置裏的菜單處理
     * @Date 16:17 2021/01/14
     * @Param []
     **/
    @GetMapping("/menus")
    @ApiOperation("获取所有菜单")
    public List<Menu> getAllMenus() {
        return menuService.getAllMenus();
    }

    @GetMapping("/mids/{rid}")
    @ApiOperation("根据角色id获取菜单id")
    private List<Integer> getMidsByRid(@PathVariable Integer rid) {
        return menuService.getMidsByRid(rid);
    }

    @PutMapping("/")
    @ApiOperation("更新角色权限")
    public RespBean updateMenuRole(Integer rid, Integer[] mids) {
        if (menuService.updateMenuRole(rid, mids)) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    @PostMapping("/role")
    @ApiOperation("添加角色")
    public RespBean addRole(@RequestBody Role role) {
        if (roleService.addRole(role) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/role/{rid}")
    @ApiOperation("删除角色")
    public RespBean deleteRoleById(@PathVariable Integer rid) {
        if (roleService.deleteRoleById(rid) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

}


