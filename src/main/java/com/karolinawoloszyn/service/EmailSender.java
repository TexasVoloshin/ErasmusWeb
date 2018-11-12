package com.karolinawoloszyn.service;

public interface EmailSender {
    void sendEmail(String to, String subject, String content);
}