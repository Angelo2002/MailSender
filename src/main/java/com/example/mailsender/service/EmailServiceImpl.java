package com.example.mailsender.service;

import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {

    private final JavaMailSender mailSender;

    @Override
    public void sendEmail(String to, String message) {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        mailMessage.setTo(to);
        mailMessage.setSubject("Notification Message");
        mailMessage.setText(message);

        mailSender.send(mailMessage);
    }
}
