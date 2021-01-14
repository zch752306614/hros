package com.alice.hros.service;

import com.alice.hros.model.MainNorice;
import com.alice.hros.model.OpLog;
import com.alice.hros.model.RespPageBean;
import com.alice.hros.service.utils.Hruitls;
import com.alice.hros.mapper.EmployeeMapper;
import com.alice.hros.mapper.MainNoriceMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/13 10:02
 */

@Transactional
@Service
public class MainNoriceService {
    @Autowired
    MainNoriceMapper mainNoriceMapper;
    @Autowired
    EmployeeMapper employeeMapper;
    @Autowired
    OplogService oplogService;

     Logger logger= LoggerFactory.getLogger(MainNoriceService.class);
    public RespPageBean getAllsMainNorice(Integer page, Integer size, String keyword) {
        if (page != null && size != null) {
            page = (page - 1) * size;
        }
        Long total = mainNoriceMapper.gettotal();
        List<MainNorice> data = mainNoriceMapper.getAllsMainNorice(page, size, keyword);
        return new RespPageBean(total, data);
    }

    public Integer addMainNorice(MainNorice mainNorice) {
        mainNorice.setAuthon(Hruitls.getCurrent().getName());
        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "添加公告" + mainNorice.getTitle(), Hruitls.getCurrent().getName()));
        Integer integer = mainNoriceMapper.insertSelective(mainNorice);
          //  employeeMapper.getEmployeeAll().stream().map(o -> o.getEmail()).forEach(o -> { ThreadUtils.getThreadPoolExecutor(new EmailModel(mainNorice.getTitle(), mainNorice.getMainbody(), "sendemailpy.py" ,o));});
        return integer;
    }

    public Integer updateMainNorice(MainNorice mainNorice) {
        mainNorice.setUpdateTime(new Date());
        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "更新公告" + mainNorice.getTitle(), Hruitls.getCurrent().getName()));

        return mainNoriceMapper.updateByPrimaryKeySelective(mainNorice);
    }

    public Integer deleteMainNorice(Integer id) {
        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "删除公告: id" + id, Hruitls.getCurrent().getName()));

        return mainNoriceMapper.deleteByPrimaryKey(id);
    }

    public List<MainNorice> getAllsMainNoricebody() {
        return mainNoriceMapper.getAllsMainNoricebody();
    }

    public Integer deldteMainNorices(Integer[] ids) {
        oplogService.addOpLog(new OpLog((byte) 1, new Date(), "批量删除公告:ids = " + ids.toString(), Hruitls.getCurrent().getName()));

        return mainNoriceMapper.deldteMainNorices(ids);


    }
}
