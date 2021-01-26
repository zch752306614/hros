package com.alice.hros.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/1/22 10:50
 */
public interface UtilMapper {

    Map<String,Object> selectByMaps(String sql);

    Integer update(String sql);

    List<Map<String,Object>> selectByObject(String sql);

    Integer insert(String sql);

}
