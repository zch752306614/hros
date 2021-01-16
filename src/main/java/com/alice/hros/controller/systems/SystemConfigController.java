package com.alice.hros.controller.systems;

import com.alice.hros.model.Menu;
import com.alice.hros.service.MenuService;
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
@RestController
@RequestMapping("/system/config")
public class SystemConfigController {
    @Autowired
    MenuService menuService;

    /**
     * @Author Alice
     * @Description  系統菜單加載
     * @Date 16:13 2021/01/14
     * @Param []
     * @return java.util.List<com.alice.hros.model.Menu>
     **/

    @GetMapping("/menu")
    public List<Menu> getMenusByHrId(){
        return menuService.getMenusById();
    }
}
