package com.example.ex02.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.stereotype.Component;

@Component
@Data
@AllArgsConstructor
public class ScrollVO {
    private int scroll_10;
    private int scroll_60;
    private int scroll_100;

    public ScrollVO(){
        this(80,60,10);
    }
}
