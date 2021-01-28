package com.alice.hros.controller.personnel;

import com.alice.hros.model.*;
import com.alice.hros.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description : 奖惩处理
 * @Author: Alice
 * @Date: 2021/01/18 20:25
 */
@Api(tags = "员工奖惩")
@RestController
@RequestMapping("/personnel/ec")
public class EmployeeecController {

    @Autowired
    EmployeeecService employeeecService;

    @Autowired
    JobLevelService jobLevelService;
    @Autowired
    PositionService positionService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    RwardsPunishmentsSevice rwardsPunishmentsSevice;


    @GetMapping("/")
    @ApiOperation("新增奖惩")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "employeeec", value = "实体类Employeeec", required = true, dataType = "Employeeec"),
            @ApiImplicitParam(name = "ids", value = "新增的奖惩id列表", required = true, dataType = "Integer[]")
    })
    public RespBean addEmployeeec(Employeeec employeeec, Integer[] ids) {

        if (employeeecService.addEmployeeec(employeeec, ids) == ids.length) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }

    }

    @GetMapping("/init")
    @ApiOperation("获取员工列表")
    public RespPageBean getEmploteeByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteeByPge(page, size, employee, beginDateScope);

    }

    @GetMapping("/rp")
    @ApiOperation("获取奖惩项")
    public List<RwardsPunishments> getAllRwardsPunishments() {
        return rwardsPunishmentsSevice.getAllRwardsPunishments();
    }

    @GetMapping("/ec")
    @ApiOperation("获取员工奖惩列表")
    public RespPageBean getEmploteecByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "100") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteecByPge(page, size, employee, beginDateScope);
    }

    @DeleteMapping("/{eid}/{id}")
    @ApiOperation("删除员工奖惩")
    public RespBean deleteEmpByEidc(@PathVariable Integer eid, @PathVariable Integer id) {
        if (employeeecService.deleteEmpByEidc(eid, id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @GetMapping("/joblevels")
    @ApiOperation("获取职位等级列表")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    @ApiOperation("获取民族列表")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

}
