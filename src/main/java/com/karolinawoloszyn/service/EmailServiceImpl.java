package com.karolinawoloszyn.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;


@Service
public class EmailServiceImpl implements EmailService{

    @Autowired
    private JavaMailSender javaMailSender;

    @Override
    public void sendEmail(String to_address, String subject, String body) {
        MimeMessage mail = javaMailSender.createMimeMessage();
        try {
            MimeMessageHelper helper = new MimeMessageHelper(mail, true);
            helper.setTo(to_address);
            helper.setReplyTo("erasmusmentor@outlook.com");
            helper.setFrom("erasmusmentor@outlook.com");
            helper.setSubject(subject);
            helper.setText(body, true);

        } catch (MessagingException e) {
            e.printStackTrace();
        }

        javaMailSender.send(mail);
    }
    
	
}
