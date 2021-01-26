package com.alice.hros.service;

import com.alice.hros.mapper.PayrollMapper;
import com.alice.hros.mapper.UtilMapper;
import com.alice.hros.model.RespBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/1/22 10:38
 */
@Service
public class PayrollService {

    @Autowired
    UtilMapper utilMapper;
    @Autowired
    PayrollMapper payrollMapper;

    public List<Map<String,Object>> generatePayroll(String date) {

        return null;
    }

    public RespBean getPayroll(String startDate,String endDate) {

        return null;
    }

    public RespBean deletePayroll(int id) {

        return null;
    }

 }
