package com.alice.hros.controller.emp;

import com.alice.hros.model.*;
import com.alice.hros.service.*;
import com.alice.hros.service.utils.POIUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/11 11:19
 */
@Api(tags = "员工基本资料")
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {

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
    @ApiOperation("获取用户基本资料")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "size", value = "每页行数", required = true, dataType = "Integer"),
            @ApiImplicitParam(name = "employee", value = "员工实体类Employee", required = true, dataType = "Employee"),
            @ApiImplicitParam(name = "beginDateScope", value = "日期范围", required = true, dataType = "Date[]")
    })
    public RespPageBean getEmploteeByPge(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size, Employee employee, Date[] beginDateScope) {
        return employeeService.getEmploteeByPge(page, size, employee, beginDateScope);

    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除员工")
    @ApiImplicitParam(name = "id", value = "员工ID", required = true, dataType = "Integer")
    public RespBean deleteEmpByEid(@PathVariable Integer id) {
        if (employeeService.deleteEmpByEid(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @DeleteMapping("/many/")
    @ApiOperation("批量删除员工")
    @ApiImplicitParam(name = "ids", value = "员工ID列表", required = true, dataType = "Integer[]")
    public RespBean deleteEmpByEids(Integer[] ids) {
        if (employeeService.deleteEmpByEids(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/")
    @ApiOperation("添加员工")
    @ApiImplicitParam(name = "employee", value = "员工实体类Employee", required = true, dataType = "Employee")
    public RespBean addEmp(@RequestBody Employee employee) {
        if (employeeService.addEmp(employee) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @PutMapping("/")
    @ApiOperation("更新员工信息")
    @ApiImplicitParam(name = "employee", value = "员工实体类Employee", required = true, dataType = "Employee")
    public RespBean updateEmp(@RequestBody Employee employee) {
        if (employeeService.updateEmp(employee) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @GetMapping("/nations")
    @ApiOperation("获取名族")
    public List<Nation> getAllNations() {
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    @ApiOperation("获取政治面貌")
    public List<Politicsstatus> getAllPoliticsstatus() {
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/joblevels")
    @ApiOperation("获取职位等级")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    @ApiOperation("获取职位吗名称")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    @GetMapping("/deps")
    @ApiOperation("获取部门名称")
    public List<Department> getAllDepartments() {
        return departmentService.getAllDepartments();
    }

    @GetMapping("/maxWorkID")
    @ApiOperation("获取新的工号")
    public RespBean maxWorkID() {
        RespBean respBean = RespBean.build().setStatus(200)
                .setObj(String.format("%08d", employeeService.maxWorkID() + 1));
        return respBean;
    }

    /**
     * @return org.springframework.http.ResponseEntity<byte [ ]>
     * @Author Alice
     * @Description 文件下载
     * @Date 19:04 2021/01/12
     * @Param []
     **/
    @GetMapping("/export")
    @ApiOperation("文件导出")
    public ResponseEntity<byte[]> exportData() {
        List<Employee> list = (List<Employee>) employeeService.getEmploteeByPge(null, null, null, null).getData();
        return POIUtils.employee2Excel(list);
    }

    /**
     * @return com.alice.hros.model.RespBean
     * @Author Alice
     * @Description 文件导出
     * @Date 19:48 2021/01/12
     * @Param [file]
     **/
    @PostMapping("/import")
    @ApiOperation("文件导入")
    public RespBean importData(MultipartFile file) throws IOException {
        List<Employee> list = POIUtils.excel2Employee(file, nationService.getAllNations(), politicsstatusService.getAllPoliticsstatus()
                , departmentService.getAllDepartmentsWithOutChildren(), positionService.getAllPositions(), jobLevelService.getAllJobLevels());
        if (employeeService.addEmps(list) == list.size()) {
            return RespBean.ok("上传成功");
        }
        return RespBean.error("上传失败");
    }

}
