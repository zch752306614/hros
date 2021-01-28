package com.alice.hros.controller.system;

import com.alice.hros.model.Hr;
import com.alice.hros.model.RespBean;
import com.alice.hros.model.Role;
import com.alice.hros.service.HrService;
import com.alice.hros.service.RoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/15 20:14
 */
@Api(tags = "管理员管理")
@RequestMapping("/system/hr")
@RestController
public class HrController {

    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    @ApiOperation("获取所有管理员")
    public List<Hr> getAllHRs(String name) {
        return hrService.getAllHRs(name);

    }

    @PutMapping("/")
    @ApiOperation("更新管理员信息")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/roles")
    @ApiOperation("获取所有角色")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    @ApiOperation("更新管理员角色")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除管理员")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/addRole")
    @ApiOperation("添加管理员")
    public RespBean addRole(@RequestBody Hr hr) {
        System.out.println("hr=" + hr.toString());
        String password = hr.getPassword();
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        hr.setPassword(encoder.encode(password));
        if (hrService.insertSelective(hr) == 1) {
            return RespBean.ok("新增成功!");
        }
        return RespBean.error("新增失败!");
    }

}


