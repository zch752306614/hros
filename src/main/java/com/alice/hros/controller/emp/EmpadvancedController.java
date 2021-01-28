package com.alice.hros.controller.emp;

import com.alice.hros.model.Employee;
import com.alice.hros.model.RespPageBean;
import com.alice.hros.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/21 9:15
 */
@Api(tags = "员工高级资料")
@RestController
@RequestMapping("/employee/advanced")
public class EmpadvancedController {

    @Autowired
    EmpadvancedService empadvancedService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    NationService nationService;
    @Autowired
    PoliticsstatusService politicsstatusService;
    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;
    @Autowired
    DepartmentService departmentService;
    @Autowired
    EmployeeecService employeeecService;

    @GetMapping("/")
    @ApiOperation("获取员工高级资料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "每页行数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "employee", value = "员工实体类Employee", required = true, dataType = "Employee"),
            @ApiImplicitParam(name = "beginDateScope", value = "日期范围", required = true, dataType = "Date[]")
    })
    public RespPageBean getAllsEmpadvanced(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope){
        return empadvancedService.getAllsEmpadvanced(page, size, employee, beginDateScope);
    }

}
