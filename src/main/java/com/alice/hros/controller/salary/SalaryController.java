package com.alice.hros.controller.salary;


import com.alice.hros.model.RespBean;
import com.alice.hros.model.Salary;
import com.alice.hros.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/salary/sob")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    @GetMapping("/")
    public List<Salary> getAllSalaries() {
        return salaryService.getAllSalaries();
    }

    @PostMapping("/")
    public RespBean addSalary(@RequestBody Salary salary) {
        if (salaryService.addSalary(salary) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteSalaryById(@PathVariable Integer id) {
        if (salaryService.deleteSalaryById(id) == 1) {
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateSalaryById(@RequestBody Salary salary) {
        if (salaryService.updateSalaryById(salary) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/adjustSalary")
    public RespBean adjustSalary(@RequestBody Map map) {
        Salary salary = new Salary();
        int eid = Integer.parseInt(map.get("eid").toString());
        salary.setAccumulationfundbase(Integer.parseInt(map.get("accumulationfundbase").toString()));
        salary.setAccumulationfundper(Float.parseFloat(map.get("accumulationfundper").toString()));
        salary.setBasicsalary(Integer.parseInt(map.get("basicsalary").toString()));
        salary.setBonus(Integer.parseInt(map.get("bonus").toString()));
        salary.setLunchsalary(Integer.parseInt(map.get("lunchsalary").toString()));
        salary.setMedicalbase(Integer.parseInt(map.get("medicalbase").toString()));
        salary.setPensionbase(Integer.parseInt(map.get("pensionbase").toString()));
        salary.setPensionper(Float.parseFloat(map.get("pensionper").toString()));
        salary.setMedicalper(Float.parseFloat(map.get("medicalper").toString()));
        salary.setTrafficsalary(Integer.parseInt(map.get("trafficsalary").toString()));
        salary.setName(map.get("name").toString());
        if (salaryService.adjustSalary(salary, eid) == 1) {
            return RespBean.ok("调薪成功!");
        }
        return RespBean.error("调薪失败!");
    }

}