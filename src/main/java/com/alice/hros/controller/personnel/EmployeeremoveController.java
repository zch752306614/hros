package com.alice.hros.controller.personnel;

import com.alice.hros.model.*;
import com.alice.hros.service.DepartmentService;
import com.alice.hros.service.EmployeeService;
import com.alice.hros.service.EmployeeremoveService;
import com.alice.hros.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description : 员工变动
 * @Author: Alice
 * @Date: 2021/01/14 9:16
 */
@RestController
@RequestMapping("/personnel/remove")
@Api(tags = "员工变动")
public class EmployeeremoveController {

    @Autowired
    EmployeeService employeeService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeremoveService employeeremoveService;

    @GetMapping("/")
    @ApiOperation("获取员工列表")
    public RespPageBean getEmploteeByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteeByPgeM(page, size, employee, beginDateScope);
    }

    @GetMapping("/positions")
    @ApiOperation("获取政治面貌")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }


    @GetMapping("/deps")
    @ApiOperation("获取部门")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @PutMapping("/")
    @ApiOperation("员工岗位调动")
    public RespBean updateEmp(@RequestBody Employee employee) {
        Employeeremove employeeremove = new Employeeremove(employee.getId(), employee.getDepartmentid(), employee.getJoblevelid(), new Date(), employee.getWorkstate());
        employee.setWorkstate("在职");
        if (employeeService.updateEmp(employee) + employeeremoveService.addEmploymove(employeeremove) == 2) {
            return RespBean.ok("调动成功!");
        }
        return RespBean.error("调动失败!");
    }

}
