package com.liruilong.hros.service;

import com.liruilong.hros.mapper.EmployeeecMapper;
import com.liruilong.hros.model.Employeeec;
import com.liruilong.hros.service.utils.LogUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Date;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/18 20:26
 */
@Service
public class EmployeeecService {

    @Autowired
    EmployeeecMapper employeeecMapper;

    @Autowired
    OplogService oplogService;
    public Integer addEmployeeec(Employeeec employeeec, Integer[] ids) {
        employeeec.setEcdate(new Date());
        oplogService.addOpLog(LogUtils.addLog((byte) 3,"员工奖惩添加:eid="+ employeeec.getEid()+"--ids:"+ Arrays.toString(ids)));
      return   employeeecMapper.insertSelectives(employeeec,  ids);


    }

    public Integer deleteEmpByEidc(Integer eid, Integer id) {
        oplogService.addOpLog(LogUtils.addLog((byte) 3,"员工奖惩删除:eid="+ eid+"--id:"+ id));
        return employeeecMapper.deleteEmpByEidc(eid, id);
    }
}
