package com.alice.hros.service;

import com.alice.hros.mapper.RwardsAndPunishmentsMapper;
import com.alice.hros.model.RwardsAndPunishments;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/18 16:52
 */

@Service
public class RwardsAndPunishmentsService {

    @Autowired
    RwardsAndPunishmentsMapper rwardsAndPunishmentsMapper;

    public List<RwardsAndPunishments> getAllRwardsAndPunishments() {
        return  rwardsAndPunishmentsMapper.getAllRwardsAndPunishments();
    }
}
