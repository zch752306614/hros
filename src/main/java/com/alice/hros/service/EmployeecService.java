package com.alice.hros.service;

import com.alice.hros.mapper.EmployeeecMapper;
import com.alice.hros.model.datas.DataModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/11 13:31
 */
@Service
public class EmployeecService {

    @Autowired
    EmployeeecMapper employeeecMapper;

    public List<DataModel> getModelandView() {
        return employeeecMapper.getModelandView();
    }
}
