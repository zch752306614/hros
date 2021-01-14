package com.alice.hros.service;

import com.alice.hros.mapper.EmployeeRecycleMapper;
import com.alice.hros.model.Employee;
import com.alice.hros.model.EmployeeRecycle;
import com.alice.hros.model.datas.DataModel;
import com.alice.hros.model.datas.DataModels;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/16 16:45
 */
@Service
public class EmployeeRecycleService {

    @Autowired
    EmployeeRecycleMapper employeeRecycleMapper;


    public void addEmployeeRecycle(Employee employee){
        employeeRecycleMapper.insertSelective(employee);

    }

    public List<EmployeeRecycle> getAllEmployeeRecycle() {
        return employeeRecycleMapper.selectByPrimaryKey();
    }

    public List<DataModel> dataViewDepartment() {
        return employeeRecycleMapper.dataViewDepartment();
    }

    public List<DataModels> dataViewPosition() {
        return employeeRecycleMapper.dataViewPosition();
    }

    public List<DataModels> dataViewJobLevelT() {
        return employeeRecycleMapper.dataViewJobLevelT();
    }
}
