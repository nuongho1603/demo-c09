package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

import javax.mail.Message;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class EmailService {
    @Autowired
    private JavaMailSender emailSender;

    public void sendSimpleMessage(
            String to, String subject, String text) throws AddressException {
        String[] sendEmailIds = {"greidahahuffa-9554@yopmail.com", "nuongho.160304@gmail.com"};
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("ngochann.1603@gmail.com");
        message.setTo(sendEmailIds);
        message.setSubject(subject);
        message.setText(text);
        emailSender.send(message);
    }

//    public String[] sendEmailIds() {
//        String[] emailIds = new String[2];
//        emailIds[0] = "greidahahuffa-9554@yopmail.com";
//        emailIds[1] = "zassihemupra-4330@yopmail.com";
//
//        return emailIds;
//    }
}
