package com.example.mailsender.controller;
import com.example.mailsender.dto.EmailRequest;
import com.example.mailsender.service.EmailService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/api/email")
public class EmailController {

    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @PostMapping("/send")
    public ResponseEntity<String> sendEmail(@RequestBody EmailRequest emailRequest) {
        try {
            emailService.sendEmail(emailRequest.getAddress(), emailRequest.getMessage());
            return new ResponseEntity<>("Email sent successfully", HttpStatus.OK);
        } catch (Exception e) {
            log.error("Failed to send email", e);
            return new ResponseEntity<>("Failed to send email", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
