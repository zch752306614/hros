package com.alice.hros.service;

import com.alice.hros.service.utils.Hruitls;
import com.alice.hros.mapper.MenuMapper;
import com.alice.hros.mapper.MenuRoleMapper;
import com.alice.hros.model.Menu;
import com.alice.hros.model.OpLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description : 菜单处理
 * @Author: Alice
 * @Date: 2021/01/14 13:17
 */
@Transactional
@Service
public class MenuService {
    @Autowired
    MenuMapper menuMapper;

    @Autowired
    MenuRoleMapper menuRoleMapper;

    @Autowired
    OplogService oplogService;

    /**
     * @return java.util.List<com.alice.hros.model.Menu>
     * @Author Alice
     * @Description 根据角色id获取权限菜单
     * @Date 22:20 2021/01/15
     * @Param []
     **/
    public List<Menu> getMenusById() {
        return menuMapper.getMenusByHrId(Hruitls.getCurrent().getId());
    }

    /**
     * @return java.util.List<com.alice.hros.model.Menu>
     * @Author Alice
     * @Description 获取所有权限菜单, springSecurity鑒權處理
     * @Date 17:48 2021/01/15
     * @Param []
     **/
    // @Cacheable
    public List<Menu> getAllMenusWithRole() {
        return menuMapper.getAllMenusWithRole();
    }

    /**
     * @return java.util.List<com.alice.hros.model.Menu>
     * @Author Alice
     * @Description 菜单数据初始化，系統設置裏的系統菜單處理。
     * @Date 21:13 2021/01/16
     * @Param []
     **/

    public List<Menu> getAllMenus() {
        return menuMapper.getAllMenus();
    }

    /**
     * @return java.util.List<java.lang.Integer>
     * @Author Alice
     * @Description 获取当前角色权限
     * @Date 20:42 2021/01/16
     * @Param [rid]
     **/
    public List<Integer> getMidsByRid(Integer rid) {

        return menuRoleMapper.getMidsByRid(rid);

    }

    /**
     * @return boolean
     * @Author Alice
     * @Description 更新信息
     * @Date 21:12 2021/01/16
     * @Param [rid, mids]
     **/

    @Transactional
    public boolean updateMenuRole(Integer rid, Integer[] mids) {

        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "角色权限变更", Hruitls.getCurrent().getName()));

        menuRoleMapper.deleteByRid(rid);
        if (mids != null && mids.length > 0) {
            Integer result = menuRoleMapper.insertRecord(rid, mids);
            return result == mids.length;
        } else {
            return true;
        }
    }
}
