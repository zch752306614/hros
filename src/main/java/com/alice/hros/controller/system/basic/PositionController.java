package com.alice.hros.controller.system.basic;


import com.alice.hros.model.Position;
import com.alice.hros.model.RespBean;
import com.alice.hros.service.PositionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author Alice
 * @Description  职位
 * @Date 15:01 2021/01/12
 * @Param  
 * @return  
 **/
@Api(tags = "岗位管理")
@RestController
@RequestMapping("/system/basic/pos")
public class PositionController {
    @Autowired
    PositionService positionService;

    /**
     * @return java.util.List<com.alice.hros.model.Position>
     * @Author Alice
     * @Description 返回显示信息
     * @Date 15:29 2021/01/15
     * @Param []
     **/
    @GetMapping("/")
    @ApiOperation("获取所有岗位")
    public List<Position> getAllPositions() {
        return positionService.getAllPositions();
    }

    /**
     * @return com.alice.hros.model.RespBean
     * @Author Alice
     * @Description 添加
     * @Date 15:29 2021/01/15
     * @Param [position]
     **/
    @PostMapping("/")
    @ApiOperation("添加岗位")
    public RespBean addPosition(@RequestBody Position position) {
        if (positionService.addPosition(position) == 1) {
            return RespBean.ok("添加成功!");
        }
        return RespBean.error("添加失败!");
    }

    /**
     * @return com.alice.hros.model.RespBean
     * @Author Alice
     * @Description 更新
     * @Date 15:29 2021/01/15
     * @Param [position]
     **/
    @PutMapping("/")
    @ApiOperation("修改岗位")
    public RespBean updatePositions(@RequestBody Position position) {
        if (positionService.updatePositions(position) == 1) {
            return RespBean.ok("更新成功!");
        }
        return RespBean.error("更新失败!");
    }

    @PostMapping("/serch/")
    @ApiOperation("搜索岗位")
    public List<Position> serchPositions(@RequestBody Position position) {
        return positionService.serchPositions(position);

    }

    /**
     * @return com.alice.hros.model.RespBean
     * @Author Alice
     * @Description 删除
     * @Date 15:29 2021/01/15
     * @Param [id]
     **/
    @DeleteMapping("/{id}")
    @ApiOperation("删除岗位")
    public RespBean deletePositionById(@PathVariable Integer id) {
        if (positionService.deletePositionById(id) == 1) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

    /**
     * @return com.alice.hros.model.RespBean
     * @Author Alice
     * @Description 批量删除
     * @Date 15:30 2021/01/15
     * @Param [ids]
     **/
    @DeleteMapping("/")
    @ApiOperation("批量删除岗位")
    public RespBean deletePositionsByIds(Integer[] ids) {
        if (positionService.deletePositionsByIds(ids) == ids.length) {
            return RespBean.ok("删除成功!");
        }
        return RespBean.error("删除失败!");
    }

}
