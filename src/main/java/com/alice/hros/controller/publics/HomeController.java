package com.alice.hros.controller.publics;

import com.alice.hros.model.MainNorice;
import com.alice.hros.model.OpLog;
import com.alice.hros.service.MainNoriceService;
import com.alice.hros.service.OplogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/18 19:23
 */

@ApiIgnore
@RestController
public class HomeController {

    @Autowired
    MainNoriceService mainNoriceService;
    @Autowired
    OplogService oplogService;

    @GetMapping("/body")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<MainNorice> getAllsMainNoricebody() {
        return mainNoriceService.getAllsMainNoricebody();
    }

    @GetMapping("/log")
    @Scheduled(cron = "0 0 3 * * ?")
    public List<OpLog> getAllsOplog() {
        return oplogService.getAllsOplogm();
    }

}
