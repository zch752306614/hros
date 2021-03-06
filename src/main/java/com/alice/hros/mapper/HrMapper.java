package com.alice.hros.mapper;

import com.alice.hros.model.Hr;
import com.alice.hros.model.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface HrMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Hr record);

    int insertSelective(Hr record);

    Hr selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Hr record);

    int updateByPrimaryKey(Hr record);

    /**
     * @return com.alice.hros.model.Hr
     * @Author Alice
     * @Description 登录
     * @Date 19:06 2021/01/18
     * @Param [username]
     **/

    Hr loadUserByUsername(String username);

    /**
     * @return java.util.List<com.alice.hros.model.Role>
     * @Author Alice
     * @Description 获取当前用户的所用角色
     * @Date 23:23 2021/01/24
     * @Param [id]
     **/

    List<Role> getHrRolesById(Integer id);

    List<Hr> getAllHRs(@Param("id") Integer id, @Param("name") String name);


    List<Hr>  getAllHrsExceptCurrentHr(Integer id);
}