package com.example.mailsender.dto;

import lombok.Data;

@Data
public class EmailRequest {
        private String address;
        private String message;
}
