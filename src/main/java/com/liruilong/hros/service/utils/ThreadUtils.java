package com.liruilong.hros.service.utils;

import com.liruilong.hros.model.EmailModel;

import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Description :线程池工具类
 * @Author: Alice
 * @Date: 2021/01/19 12:29
 */
public class ThreadUtils {
    //邮件发送线程池
    private static ThreadPoolExecutor threadPoolExecutor =
            new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.MILLISECONDS, new SynchronousQueue<Runnable>());



    // 构建一个邮件发送的线程
    public static Thread getThtead(EmailModel emailModel) {
        return new Thread(() -> EmailUtils.sendGEmail(emailModel));
    }
    /**
     * @Author Alice
     * @Description 构造一个有缓冲功能的线程池
     * @Date 18:14 2021/01/19
     * @Param [thread]
     * @return void
     **/
    public static void getCachedThreadPool(Thread thread) {
       Executors.newCachedThreadPool().execute(thread);
    }
    /**
     * @Author Alice
     * @Description 构造一个固定线程数目的线程池
     * @Date 18:21 2021/01/19
     * @Param [thread] 
     * @return void 
     **/
    public static void getFixedThreadPool(Thread thread,Integer size){
        Executors.newFixedThreadPool(size).execute(thread);
    }




    public static void getThreadPoolExecutor(EmailModel emailModel){
          ThreadUtils.threadPoolExecutor.execute(getThtead(emailModel));
    }


}
