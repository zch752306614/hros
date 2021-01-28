package com.alice.hros.controller.system.basic;


import com.alice.hros.model.JobLevel;
import com.alice.hros.model.Position;
import com.alice.hros.model.RespBean;
import com.alice.hros.service.JobLevelService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description : 职称
 * @Author: Alice
 * @Date: 2021/01/16 13:14
 */
@Api(tags = "职位管理")
@RestController
@RequestMapping("/system/basic/joblevel")
public class JobLevelController {

    @Autowired
    JobLevelService jobLevelService;

    @GetMapping("/")
    @ApiOperation("获取所有职位")
    public List<JobLevel> getAllJobLevels() {
        return jobLevelService.getAllJobLevels();
    }

    @PostMapping("/serch/")
    @ApiOperation("搜索职位")
    public List<Position> serchJobLevel(@RequestBody JobLevel jobLevel) {
        return jobLevelService.serchJobLevel(jobLevel);

    }

    @PostMapping("/")
    @ApiOperation("添加职位")
    public RespBean addJobLevel(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.addJobLevel(jobLevel) == 1) {
            return RespBean.ok("添加成功!");
        } else {
            return RespBean.ok("添加失败!");
        }
    }


    @PutMapping("/")
    @ApiOperation("更新职位")
    public RespBean updateJobLevelById(@RequestBody JobLevel jobLevel) {
        if (jobLevelService.updateJobLevelById(jobLevel) == 1) {
            return RespBean.ok("更新成功!");
        } else {
            return RespBean.ok("更新失败!");
        }
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除职位")
    public RespBean deleteJobLevelById(@PathVariable Integer id) {
        if (jobLevelService.deleteJobLevelById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @DeleteMapping("/")
    @ApiOperation("批量删除职位")
    public RespBean deleteJobLevelByIds(Integer[] ids) {
        if (jobLevelService.deleteJobLevelByIds(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

}
