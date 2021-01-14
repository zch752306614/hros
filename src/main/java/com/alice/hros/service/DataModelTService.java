package com.alice.hros.service;

import com.alice.hros.model.datas.DataModelT;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/16 20:26
 */
@Service
public class DataModelTService {

    @Autowired
    EmployeeService employeeService;


    public List<DataModelT> dataViewDepartment() {
       return employeeService.DataViewDepartmentT();

    }

    public List<DataModelT> dataViewWorkAge() {
        return employeeService.dataViewWorkAge();
    }

    public List<DataModelT> dataViewJobLevelT() {
        return employeeService.dataViewJobLevelTAge();
    }




}
