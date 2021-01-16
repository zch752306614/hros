package com.alice.hros.service;

import com.alice.hros.service.utils.Hruitls;
import com.alice.hros.mapper.HrMapper;
import com.alice.hros.mapper.HrRoleMapper;
import com.alice.hros.model.Hr;
import com.alice.hros.model.OpLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.logging.Logger;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/18 18:59
 */
@Transactional
@Service
public class HrService implements UserDetailsService {

    @Autowired
    HrMapper hrMapper;
    @Autowired
    HrRoleMapper hrRoleMapper;
    @Autowired
    OplogService oplogService;

    private static Logger Loggerlogger = Logger.getLogger("com.alice.hros.service.HrService");

    // 根据用户名加载user对象
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Hr hr = hrMapper.loadUserByUsername(username);
        if (hr == null) {
            throw new UsernameNotFoundException("用户名不存在");
        }
        hr.setRoles(hrMapper.getHrRolesById(hr.getId()));
        return hr;
    }

    public List<Hr> getAllHRs(String name) {
        return hrMapper.getAllHRs(Hruitls.getCurrent().getId(), name);
    }

    @Transactional
    public boolean updateHrRole(Integer hrid, Integer[] rids) {
        oplogService.addOpLog(new OpLog((byte) 8,new Date(),"操作员角色更新", Hruitls.getCurrent().getName()));
        Loggerlogger.warning("hrid:"+hrid + Arrays.toString(rids));
        int i = hrRoleMapper.deleteByHeId(hrid);
        if (rids == null || rids.length == 0) {
            return true;
        } else {
            return i >= 0 && hrRoleMapper.addHrRole(hrid, rids) == rids.length;
        }
    }

    public Integer updateHr(Hr hr) {
        oplogService.addOpLog(new OpLog((byte) 8,new Date(),"操作员信息更新:" + hr.getName(), Hruitls.getCurrent().getName()));
        return hrMapper.updateByPrimaryKeySelective(hr);
    }

    public Integer deleteHrById(Integer id) {
        oplogService.addOpLog(new OpLog((byte) 8,new Date(),"删除操作员: id=" + id, Hruitls.getCurrent().getName()));
        return hrMapper.deleteByPrimaryKey(id);
    }

    public List<Hr> getAllHrsExceptCurrentHr() {
      return hrMapper.getAllHrsExceptCurrentHr(Hruitls.getCurrent().getId());
    }
}
