package com.alice.hros.service;

import com.alice.hros.model.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

/**
 * @author Alice
 * @version 1.0
 * @date 2021/1/20 15:14
 */
@Component
public class MailService {
    @Autowired
    private JavaMailSender javaMailSender;
    @Value("${spring.mail.username}")
    private String sender;
    public void sendEmail(EmailModel emailModel) {
        try {
            System.out.println("发送者=" + sender + "\n接收者=" + emailModel.getEmployee().getEmail() + "\n标题=" + emailModel.getTitle() + "\n正文=" + emailModel.getContent());
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            simpleMailMessage.setFrom(sender);
            simpleMailMessage.setTo(emailModel.getEmployee().getEmail());
            simpleMailMessage.setSubject(emailModel.getTitle());
            simpleMailMessage.setText(emailModel.getContent());
            javaMailSender.send(simpleMailMessage);
            System.out.println("邮件发送成功！");
        } catch (Exception e) {
            System.out.println("邮件发送失败！");
            e.printStackTrace();
        }
    }
}
