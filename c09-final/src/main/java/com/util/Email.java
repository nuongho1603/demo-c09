package com.util;

import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Properties;

public class Email {
    static final String from = "ngochann.1603@gmail.com";
    static final String password = "bvwtgrsxqskwzjan";

    public static boolean sendEMail(String to, String subject, String content) {
        // Properties: khai bao ca thuoc tinh
        Properties pros = new Properties();
        pros.put("mail.smtp.host", "smtp.gmail.com");
        pros.put("mail.smtp.port", "587"); // TTL: 587 SSL:465
        pros.put("mail.smtp.auth", "true");
        pros.put("mail.smtp.starttls.enable", "true");

//lay ra doi tuong authen de login mail
        //create: Authenticator
        Authenticator auth = new Authenticator() {
            @Override
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication(from, password);
            }
        };

        //phien lam viec(session cua mail)
        Session session = Session.getInstance(pros, auth);

        // send email
//        final String to = "nuongho.160304@gmail.com";
//Tao 1tin nhan
        MimeMessage msg = new MimeMessage(session);

        try {
            //kieu noi dung
            msg.addHeader("Content-type", "text/HTML; charsetd=UTF-8");
            //nguoi gui
            msg.setFrom();
            msg.setRecipients(Message.RecipientType.TO, InternetAddress.parse(to, false));

            //Nguoi nhan
            msg.setSubject(subject);

            // Quy dinh ngay gui
            msg.setSentDate(new Date());

            //Quy dinh email nhận phản hồi
            // msg.setReplyTo(InternetAddress.parse(from,false));

            //noidung
//            msg.setContent(noiDung, "UTF-8");
            msg.setText(content, "UTF-8");

            //gui mail
            Transport.send(msg);
            System.out.println("Send mail sucessful.");
            return true;
        } catch (MessagingException e) {
            System.out.println("No can't send mail.");
            e.printStackTrace();
            return false;
        }
    }

//    public static void main(String[] args) {
//        Email.sendEMail("nuongho.160304@gmail.com", "Test mail hihi", "Ho Thi Nuong cute.");
//    }

}
