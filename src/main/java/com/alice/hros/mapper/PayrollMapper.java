package com.alice.hros.mapper;

import java.util.List;
import java.util.Map;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/1/22 10:39
 */
public interface PayrollMapper {
    List<Map<String,Object>> generatePayroll(String date);
}
