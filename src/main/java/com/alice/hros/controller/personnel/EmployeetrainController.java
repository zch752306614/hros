package com.alice.hros.controller.personnel;

import com.alice.hros.model.*;
import com.alice.hros.service.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/12 12:27
 */
@Api(tags = "员工培训")
@RestController
@RequestMapping("/personnel/train")
public class EmployeetrainController {

    @Autowired
    EmployeetrainService employeetrainService;

    @Autowired
    EmployeeService employeeService;

    @Autowired
    JobLevelService jobLevelService;

    @Autowired
    PositionService positionService;

    @Autowired
    AppraiseService appraiseService;


    @GetMapping("/init")
    @ApiOperation("获取员工列表")
    public RespPageBean getEmploteeByPgeT(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteeByPgeT(page, size, employee, beginDateScope);

    }

    @GetMapping("/inia")
    @ApiOperation("获取员工列表")
    public RespPageBean getEmploteeByPgeA(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteeByPgeA(page, size, employee, beginDateScope);

    }

    @GetMapping("/initapp")
    @ApiOperation("获取考评信息")
    public RespPageBean getAppraiseByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getAppraiseByPge(page, size, employee, beginDateScope);

    }

    @PostMapping("/")
    @ApiOperation("添加培训")
    public RespBean addEmployeetrain(@RequestBody Employeetrain employeetrain) {
        if (employeetrainService.addEmployeetrain(employeetrain) == 1) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @PostMapping("/add")
    @ApiOperation("添加考评")
    public RespBean addAppraise(@RequestBody Appraise appraise) {
        if (appraiseService.addAppraise(appraise) == 1) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @PutMapping("/")
    @ApiOperation("更新培训")
    public RespBean updateEmployeetrain(@RequestBody Employeetrain employeetrain) {
        if (employeetrainService.updateEmployeetrain(employeetrain) == 1) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    @PutMapping("/app")
    @ApiOperation("更新考评")
    public RespBean updateAppraise(@RequestBody Appraise appraise) {
        if (appraiseService.updateAppraise(appraise) == 1) {
            return RespBean.ok("更新成功");
        } else {
            return RespBean.error("更新失败");
        }
    }

    /**
     * @return com.alice.hros.model.RespBean
     * @Author Alice
     * @Description 删除
     * @Date 22:35 2021/01/13
     * @Param [eid, id]
     **/
    @DeleteMapping("/{eid}/{id}")
    @ApiOperation("取消培训")
    public RespBean deleteEmployeetrain(@PathVariable Integer eid, @PathVariable Integer id) {
        if (employeetrainService.deleteEmployeetrain(eid, id) == 1) {
            return RespBean.ok("取消成功!");
        }
        return RespBean.error("取消失败!");
    }

    @DeleteMapping("/app/{eid}/{id}")
    @ApiOperation("取消考评")
    public RespBean deleteAppraise(@PathVariable Integer eid, @PathVariable Integer id) {
        if (appraiseService.deleteAppraise(eid, id) == 1) {
            return RespBean.ok("取消成功!");
        }
        return RespBean.error("取消失败!");
    }

    @GetMapping("/")
    @ApiOperation("获取员工列表")
    public RespPageBean getEmploteetByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteetByPge(page, size, employee, beginDateScope);

    }

    /**
     * @return com.alice.hros.model.RespBean
     * @Author Alice
     * @Description 批量处理
     * @Date 22:35 2021/01/13
     * @Param [employeetrain, ids, beginDateScope]
     **/
    @GetMapping("/addt")
    @ApiOperation("批量添加培训")
    public RespBean addEmploteetByPge(Employeetrain employeetrain, Integer[] ids, Date[] beginDateScope) {
        if (employeetrainService.addEmploteetByPge(employeetrain, ids) == ids.length) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @GetMapping("/adda")
    @ApiOperation("批量添加考评")
    public RespBean addEmploteetByPge(Appraise appraise, Integer[] ids) {
        if (appraiseService.addEmploteeaByPge(appraise, ids) == ids.length) {
            return RespBean.ok("添加成功");
        } else {
            return RespBean.error("添加失败");
        }
    }

    @GetMapping("/joblevels")
    @ApiOperation("获取职位等级列表")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    @ApiOperation("获取岗位名称列表")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

}




