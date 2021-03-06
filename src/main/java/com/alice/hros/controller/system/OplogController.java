package com.alice.hros.controller.system;

import com.alice.hros.model.LogType;
import com.alice.hros.model.RespPageBean;
import com.alice.hros.service.LogTypeService;
import com.alice.hros.service.OplogService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/15 22:06
 */
@Api(tags = "系统日志")
@RestController
@RequestMapping("/system/log")
public class OplogController {

    @Autowired
    OplogService oplogService;

    @Autowired
    LogTypeService logTypeService;

    @GetMapping("/")
    @ApiOperation("获取所有日志")
    public RespPageBean getAllsOplog(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "13") Integer size, Integer logtype, Date[] beginDateScope ){
        return  oplogService.getAllsOplog(page, size, logtype,beginDateScope );
    }

    @GetMapping("/logtype")
    @ApiOperation("获取日志类型")
    public List<LogType> getAllsLogtype(){
        return logTypeService.getAllsLogtype();
    }

}
