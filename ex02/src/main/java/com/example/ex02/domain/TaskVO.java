package com.example.ex02.domain;

import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
public class TaskVO {
    private int num;
    private int kor;
    private int eng;
    private int math;
}
