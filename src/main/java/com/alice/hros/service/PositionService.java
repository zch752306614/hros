package com.alice.hros.service;

import com.alice.hros.service.utils.Hruitls;
import com.alice.hros.mapper.PositionMapper;
import com.alice.hros.model.OpLog;
import com.alice.hros.model.Position;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Author Alice
 * @Description
 * @Date 15:05 2021/01/15
 * @Param
 * @return
 **/
@Transactional
@Service
public class PositionService {
    @Autowired
    PositionMapper positionMapper;

    @Autowired
    OplogService oplogService;

    public List<Position> getAllPositions() {
        return positionMapper.getAllPositions();
    }

    public Integer addPosition(Position position) {
        // 设置默认值
        position.setEnabled(true);
        position.setCreatedate(new Date());
        oplogService.addOpLog(new OpLog((byte) 1,new Date(),"添加职位: " + position.getName(), Hruitls.getCurrent().getName()));
        return positionMapper.insertSelective(position);
    }

    public Integer updatePositions(Position position) {
        position.setCreatedate(new Date());
        oplogService.addOpLog(new OpLog((byte) 1,new Date(),"更新职位:"+ position.getName(), Hruitls.getCurrent().getName()));

        return positionMapper.updateByPrimaryKeySelective(position);
    }

    public Integer deletePositionById(Integer id) {
        oplogService.addOpLog(new OpLog((byte) 1,new Date(),"删除职位: id = " + id, Hruitls.getCurrent().getName()));

        return positionMapper.deleteByPrimaryKey(id);
    }

    public Integer deletePositionsByIds(Integer[] ids) {
        oplogService.addOpLog(new OpLog((byte) 1,new Date(),"批量删除职位: ids = " + ids.toString(), Hruitls.getCurrent().getName()));

        return positionMapper.deletePositionsByIds(ids);
    }

    public List<Position> serchPositions(Position position) {
        position.setName("%"+position.getName()+"%");
        return positionMapper.serchPositions(position);
    }
}
