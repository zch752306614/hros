package com.alice.hros.mapper;

import com.alice.hros.model.HrRole;
import org.apache.ibatis.annotations.Param;

public interface HrRoleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HrRole record);

    int insertSelective(HrRole record);

    HrRole selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(HrRole record);

    int updateByPrimaryKey(HrRole record);

    int  deleteByHeId(Integer hrid);

    Integer addHrRole(@Param("hrid") Integer hrid, @Param("rids") Integer[] rids);
}