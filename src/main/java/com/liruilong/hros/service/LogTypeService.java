package com.liruilong.hros.service;

import com.liruilong.hros.mapper.LogTypeMapper;
import com.liruilong.hros.model.LogType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/15 22:20
 */
@Service
public class LogTypeService {

    @Autowired
    LogTypeMapper logTypeMapper;


    public List<LogType> getAllsLogtype() {
        return logTypeMapper.selectByPrimaryKey();
    }
}
