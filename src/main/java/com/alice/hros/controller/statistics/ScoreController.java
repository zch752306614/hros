package com.alice.hros.controller.statistics;

import com.alice.hros.model.datas.DataModel;
import com.alice.hros.service.EmployeecService;
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
 * @Date: 2021/1/21 13:28
 */
@Api(tags = "积分统计")
@RequestMapping("/statistics/score")
@RestController
public class ScoreController {

    @Autowired
    EmployeecService employeecService;

    @GetMapping("/")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<DataModel> getModelandView() {
        return employeecService.getModelandView();
    }

}
