package com.alice.hros.controller.systems;

import com.alice.hros.model.Menu;
import com.alice.hros.service.MenuService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description :  菜单加载
 * @Author: Alice
 * @Date: 2021/01/16 13:14
 */
@Api(tags = "菜单加载")
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;

    /**
     * @return java.util.List<com.alice.hros.model.Menu>
     * @Author Alice
     * @Description 系統菜單加載
     * @Date 16:13 2021/01/14
     * @Param []
     **/
    @GetMapping("/menu")
    @ApiOperation("菜单加载")
    public List<Menu> getMenusByHrId() {
        return menuService.getMenusById();
    }

}
