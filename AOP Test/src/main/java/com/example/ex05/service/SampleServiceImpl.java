package com.example.ex05.service;

import com.example.ex05.aspect.annotation.LogStatus;
import com.example.ex05.aspect.annotation.Plus10;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService{

    @Plus10
    @LogStatus
    @Override
    public Integer doAdd(String str1, String str2) throws Exception {
        return Integer.parseInt(str1) + Integer.parseInt(str2);
    }
}
