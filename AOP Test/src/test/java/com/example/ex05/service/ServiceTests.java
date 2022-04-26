package com.example.ex05.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ServiceTests {
    @Autowired
    private SampleService sampleService;

    @Test
    public void testDoAdd() throws Exception {
        log.info(String.valueOf(sampleService.doAdd("2","5")));
    }
}
