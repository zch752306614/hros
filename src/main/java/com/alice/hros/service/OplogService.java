package com.alice.hros.service;

import com.alice.hros.mapper.OpLogMapper;
import com.alice.hros.model.OpLog;
import com.alice.hros.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/15 22:05
 */
@Service
public class OplogService {

    @Autowired
    OpLogMapper opLogMapper;

    public RespPageBean getAllsOplog(Integer page, Integer size, Integer logtype, Date[] beginDateScope ) {
        if (page != null && size != null){
            page = (page - 1) * size;
        }
        Long total = opLogMapper.selectByPrimaryKey( logtype,beginDateScope);
        return  new RespPageBean(total, opLogMapper.getAllsOplog(page, size, logtype,beginDateScope));
    }
    public void addOpLog(OpLog opLog){
        opLogMapper.insertSelective(opLog);

    }

    public List<OpLog> getAllsOplogm() {
        return opLogMapper.getAllsOplogm();
    }
}
