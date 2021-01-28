package com.alice.hros.controller.statistics;

import com.alice.hros.model.datas.DataModelT;
import com.alice.hros.service.DataModelTService;

import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * @Description : 人事记录统计
 * @Author: Alice
 * @Date: 2021/1/6 16:11
 */
@Api(tags = "离职统计")
@RestController
@RequestMapping("/statistics/recored")
public class RecoredController {

    @Autowired
    DataModelTService dataModelTService;

    /**
     * @return java.util.List<com.alice.hros.model.datas.DataModelT>
     * @Author Alice
     * @Description 部门入职统计，离职统计 离职率
     * @Date 10:58 2021/1/7
     * @Param []
     **/
    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/department")
    public List<DataModelT> dataViewDepartment() {
        return dataModelTService.dataViewDepartment();
    }

    /**
     * @return java.util.List<com.alice.hros.model.datas.DataModelT>
     * @Author Alice
     * @Description 职位入职统计，离职统计 离职工龄 离职率
     * @Date 16:33 2021/1/7
     * @Param []
     **/
    @Scheduled(cron = "0 0 3 * * ?")
    @GetMapping("/workAge")
    public List<DataModelT> dataViewWorkAge() {
        return dataModelTService.dataViewWorkAge();
    }

    /**
     * @return java.util.List<com.alice.hros.model.datas.DataModelT>
     * @Author Alice
     * @Description 职称入职统计，离职统计 离职工龄 离职率
     * @Date 16:51 2021/1/7
     * @Param []
     **/
    @GetMapping("/JobLevel")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<DataModelT> DataViewJobLevelT() {
        return dataModelTService.dataViewJobLevelT();
    }

    /**
     * @return java.util.List<com.alice.hros.model.datas.DataModelT>
     * @Author Alice
     * @Description
     * @Date 16:54 2021/1/7
     * @Param []
     **/
    @GetMapping("/Department")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<DataModelT> DataViewDepartment() {
        return dataModelTService.dataViewDepartment();
    }

}
