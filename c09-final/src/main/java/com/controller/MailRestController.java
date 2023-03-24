package com.controller;

import com.service.EmailService;
import com.util.Email;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.mail.internet.AddressException;

@RestController
@CrossOrigin("*")
@RequestMapping("")
public class MailRestController {

    @Autowired
    private EmailService emailService;
//
//    @GetMapping("/send-mail")
//    public void sendMail() {
//        Email.sendEMail("nuongho.160304@gmail.com", "Hello", "HELLO, Mình là Nương cute phô mai que đây! hihihi! bye. ");
//
//    }

    @GetMapping("/send")
    public void sendEMail () throws AddressException {
        emailService.sendSimpleMessage("", "Hello", "Đề tài được duyệt.");
    }
}
