package com.alice.hros.controller.system.basic;

import com.alice.hros.model.RespBean;
import com.alice.hros.model.RwardsAndPunishments;
import com.alice.hros.model.RwardsPunishments;
import com.alice.hros.service.RwardsAndPunishmentsService;
import com.alice.hros.service.RwardsPunishmentsSevice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description : 奖惩
 * @Author: Alice
 * @Date: 2021/01/18 16:06
 */

@RestController
@RequestMapping("/system/basic/rp")
public class RwardsPunishmentsController {

    @Autowired
    RwardsPunishmentsSevice rwardsPunishmentsSevice;
    @Autowired
    RwardsAndPunishmentsService rwardsAndPunishmentsService;

    @GetMapping("/")
    public List<RwardsPunishments> getAllRwardsPunishments() {
        return rwardsPunishmentsSevice.getAllRwardsPunishments();
    }

    @GetMapping("/rap/")
    public List<RwardsAndPunishments> getAllRwardsAndPunishments(){
        return rwardsAndPunishmentsService.getAllRwardsAndPunishments();
    };

    @PutMapping("/")
    public RespBean updateRwardsPunishments(@RequestBody RwardsPunishments rwardsPunishments) {

        if (rwardsPunishmentsSevice.updateRwardsPunishments(rwardsPunishments) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/")
    public RespBean addRwardsPunishments(@RequestBody RwardsPunishments rwardsPunishments) {
        if (rwardsPunishmentsSevice.addRwardsPunishments(rwardsPunishments) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    @DeleteMapping("/{id}")
    public RespBean deleteRwardsPunishmentsById( @PathVariable Integer id){
        if (rwardsPunishmentsSevice.deleteRwardsPunishmentsById(id) == 1){
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");

    }
    @DeleteMapping("/")
    public RespBean deleteRwardsPunishmentsByIds(Integer[] ids){
        if (rwardsPunishmentsSevice.deleteRwardsPunishmentsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    @PostMapping("/serch/")
    public List<RwardsPunishments> sercRwardsPunishments(@RequestBody RwardsPunishments rwardsPunishments){
        return rwardsPunishmentsSevice.sercRwardsPunishments(rwardsPunishments);
    }


}

