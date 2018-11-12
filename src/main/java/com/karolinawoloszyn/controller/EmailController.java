package com.karolinawoloszyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.karolinawoloszyn.service.EmailSender;

@Controller
public class EmailController {

    private final EmailSender emailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailSender emailSender,
                           TemplateEngine templateEngine){
        this.emailSender = emailSender;
        this.templateEngine = templateEngine;
    }

    @RequestMapping("/contact")
    public String send() {
        Context context = new Context();
        context.setVariable("header", "Masz zapytanie  od Eramsusa/Mentora");
        context.setVariable("title", "Custom request from user");
        context.setVariable("description", "Tutaj bedzie wczytana tresc wiadomosci ");

        String body = templateEngine.process("template", context);
        emailSender.sendEmail("erasmusmentor@outlook.com", "Erasmus-Mentor Request", body);
        return "index";
    }
}