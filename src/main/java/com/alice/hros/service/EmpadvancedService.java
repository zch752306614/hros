package com.alice.hros.service;

import com.alice.hros.mapper.EmployeeMapper;
import com.alice.hros.model.Employee;
import com.alice.hros.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/11 9:17
 */
@Service
public class EmpadvancedService {


    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    OplogService oplogService;
    @Autowired
    EmployeeRecycleService employeeRecycleService;


    public RespPageBean getAllsEmpadvanced(Integer page, Integer size, Employee employee, Date[] beginDateScope) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        List<Employee> data = employeeMapper.getAllsEmpadvanced(page, size, employee, beginDateScope);
        Long total = employeeMapper.getTotalE(employee, beginDateScope);
        return new RespPageBean(total, data);
    }
}
