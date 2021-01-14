package com.alice.hros.controller.system;

import com.alice.hros.model.Hr;
import com.alice.hros.model.RespBean;
import com.alice.hros.model.Role;
import com.alice.hros.service.HrService;
import com.alice.hros.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/15 20:14
 */
@RequestMapping("/system/hr")
@RestController
public class HrController {

    @Autowired
    HrService hrService;
    @Autowired
    RoleService roleService;

    @GetMapping("/")
    public List<Hr> getAllHRs(String name){
        return  hrService.getAllHRs(name);

    }

    @PutMapping("/")
    public RespBean updateHr(@RequestBody Hr hr) {
        if (hrService.updateHr(hr) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }
    @GetMapping("/roles")
    public List<Role> getAllRoles() {
        return roleService.getAllRoles();
    }

    @PutMapping("/role")
    public RespBean updateHrRole(Integer hrid, Integer[] rids) {
        if (hrService.updateHrRole(hrid, rids)) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteHrById(@PathVariable Integer id) {
        if (hrService.deleteHrById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

}


