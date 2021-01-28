package com.alice.hros.controller.system.basic;

import com.alice.hros.model.RespBean;
import com.alice.hros.model.RwardsAndPunishments;
import com.alice.hros.model.RwardsPunishments;
import com.alice.hros.service.RwardsAndPunishmentsService;
import com.alice.hros.service.RwardsPunishmentsSevice;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description : 奖惩
 * @Author: Alice
 * @Date: 2021/01/18 16:06
 */
@Api(tags = "奖惩管理")
@RestController
@RequestMapping("/system/basic/rp")
public class RwardsPunishmentsController {

    @Autowired
    RwardsPunishmentsSevice rwardsPunishmentsSevice;
    @Autowired
    RwardsAndPunishmentsService rwardsAndPunishmentsService;

    @GetMapping("/")
    @ApiOperation("获取所有奖惩")
    public List<RwardsPunishments> getAllRwardsPunishments() {
        return rwardsPunishmentsSevice.getAllRwardsPunishments();
    }

    @GetMapping("/rap/")
    @ApiOperation("获取奖惩分类")
    public List<RwardsAndPunishments> getAllRwardsAndPunishments() {
        return rwardsAndPunishmentsService.getAllRwardsAndPunishments();
    }

    @PutMapping("/")
    @ApiOperation("更新奖惩")
    public RespBean updateRwardsPunishments(@RequestBody RwardsPunishments rwardsPunishments) {
        if (rwardsPunishmentsSevice.updateRwardsPunishments(rwardsPunishments) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/")
    @ApiOperation("增加奖惩项")
    public RespBean addRwardsPunishments(@RequestBody RwardsPunishments rwardsPunishments) {
        if (rwardsPunishmentsSevice.addRwardsPunishments(rwardsPunishments) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    @ApiOperation("删除奖惩项")
    public RespBean deleteRwardsPunishmentsById(@PathVariable Integer id) {
        if (rwardsPunishmentsSevice.deleteRwardsPunishmentsById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");

    }

    @DeleteMapping("/")
    @ApiOperation("批量删除奖惩项")
    public RespBean deleteRwardsPunishmentsByIds(Integer[] ids) {
        if (rwardsPunishmentsSevice.deleteRwardsPunishmentsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/serch/")
    @ApiOperation("搜索奖惩项")
    public List<RwardsPunishments> sercRwardsPunishments(@RequestBody RwardsPunishments rwardsPunishments) {
        return rwardsPunishmentsSevice.sercRwardsPunishments(rwardsPunishments);
    }

}

