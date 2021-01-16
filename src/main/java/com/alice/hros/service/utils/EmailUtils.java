package com.alice.hros.service.utils;

import com.alice.hros.model.EmailModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;

import java.io.IOException;
import java.util.Arrays;


/**
 * @Description :
 * @Author: Alice
 * @Date: 2021/01/17 23:05
 */

public class EmailUtils {

    @Autowired
    static JavaMailSender javaMailSender;

    final static Logger logger = LoggerFactory.getLogger(EmailUtils.class);
    final static String PATH = "src\\main\\java\\com\\alice\\hros\\script\\";

    public static void sendEmail(EmailModel emailModel) {

        String emailTo = emailModel.getEmployee().getEmail();
        String username = emailModel.getEmployee().getName();
        String titles = emailModel.getTitle();
        String pathPy = PATH + emailModel.getPath();
        String[] args = new String[]{"python", pathPy, emailTo, username, titles};
        logger.info(Arrays.toString(args));
        try {
            Process process = Runtime.getRuntime().exec(args);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendGEmail(EmailModel emailModel) {
        String content = emailModel.getContent();
        String pathPy = PATH + emailModel.getPath();
        String emailTo = emailModel.getToEmail();
        String titles = emailModel.getTitle();
       // String username = emailModel.getEmployee().getName();
        String[] args = new String[]{"python", pathPy, emailTo, "测试", titles, content};
        logger.info(Arrays.toString(args));
        try {

            Process process = Runtime.getRuntime().exec(args);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
