package com.alice.hros.controller.statistics;

import com.alice.hros.model.datas.DataModel;
import com.alice.hros.service.EmployeeService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/5 15:54
 */
@Api(tags = "员工分类统计")
@RestController
@RequestMapping("/statistics/personnel")
public class PersonnelController {

    @Autowired
    EmployeeService employeeService;

    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/Position")
    public List<DataModel> DataViewPosition() {
        return employeeService.dataViewPosition();
    }

    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/JobLevel")
    public List<DataModel> DataViewJobLevel() {
        return employeeService.dataViewJobLevel();
    }

    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/Department")
    public List<DataModel> DataViewDepartment() {
        return employeeService.dataViewDepartment();
    }

    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/tiptopdegree")
    public List<DataModel> DataViewtiptopdegree() {
        return employeeService.dataViewtiptopdegree();
    }

    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/school")
    public List<DataModel> DataViewschool() {
        return employeeService.dataViewschool();
    }

    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/nation")
    public List<DataModel> DataViewNation() {
        return employeeService.dataViewNation();
    }

    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/politicsstatus")
    public List<DataModel> DataViewPoliticsstatus() {
        return employeeService.dataViewPoliticsstatus();
    }

}
