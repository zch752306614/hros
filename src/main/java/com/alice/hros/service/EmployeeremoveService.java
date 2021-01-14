package com.alice.hros.service;

import com.alice.hros.service.utils.LogUtils;
import com.alice.hros.mapper.EmployeeremoveMapper;
import com.alice.hros.model.Employeeremove;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/14 16:40
 */
@Service
@Transactional
public class EmployeeremoveService {

    @Autowired
    EmployeeremoveMapper employeeremoveMapper;
    @Autowired
    OplogService oplogService;
    public Integer addEmploymove(Employeeremove employeeremove) {
       oplogService.addOpLog(LogUtils.addLog((byte) 6,"员工调动:eid="+employeeremove.getEid()));
       return employeeremoveMapper.insertSelective(employeeremove);
    }
}
