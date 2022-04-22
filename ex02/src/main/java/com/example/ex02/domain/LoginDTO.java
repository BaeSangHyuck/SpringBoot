package com.example.ex02.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class LoginDTO {
    private int userNum;
    private String id;
    private String pw;
}
