package com.karolinawoloszyn.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.karolinawoloszyn.model.User;
import com.karolinawoloszyn.service.EmailService;

@Controller
public class EmailController {

    private final EmailService emailService;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailController(EmailService emailSender,
                           TemplateEngine templateEngine){
        this.emailService = emailSender;
        this.templateEngine = templateEngine;
    }
    
    @RequestMapping(value= {"/home/admin/messageSent"}, method=RequestMethod.GET)
    public ModelAndView messageSent() {
     ModelAndView model = new ModelAndView();
     User user = new User();
     model.addObject("user", user);
     model.setViewName("home/messageSent");
     return model;
    }
    @RequestMapping(value= {"/notification"}, method=RequestMethod.GET)
    public String send() {
        Context context = new Context();
        context.setVariable("header", "Mentor-Erasmus");
        context.setVariable("title", "Congratulation");
        context.setVariable("description", "Please be informed that Mentor Erasmus pair has been created!");

        String body = templateEngine.process("template", context);
        emailService.sendEmail("erasmusmentor@outlook.com", "Erasmus-Mentor", body);
        return "home/messageSent";
    }
}