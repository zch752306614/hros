package com.alice.hros.mapper;

import com.alice.hros.model.Employee;
import com.alice.hros.model.EmployeeRecycle;
import com.alice.hros.model.datas.DataModel;
import com.alice.hros.model.datas.DataModels;

import java.util.List;

public interface EmployeeRecycleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeRecycle record);

    int insertSelective(Employee record);

    List<EmployeeRecycle> selectByPrimaryKey( );

    int updateByPrimaryKeySelective(EmployeeRecycle record);

    int updateByPrimaryKey(EmployeeRecycle record);

    List<DataModel>  dataViewDepartment();

    List<DataModels>  dataViewPosition();

    List<DataModels>  dataViewJobLevelT();
}