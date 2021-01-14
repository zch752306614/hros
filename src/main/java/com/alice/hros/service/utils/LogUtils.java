package com.alice.hros.service.utils;

import com.alice.hros.model.OpLog;

import java.util.Date;

/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/16 17:38
 */
public class LogUtils {

    public static OpLog addLog(Byte type, String msg){
        return new OpLog(type,new Date(),msg,Hruitls.getCurrent().getName() );
    }
}
