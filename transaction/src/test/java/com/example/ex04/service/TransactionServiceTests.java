package com.example.ex04.service;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TransactionServiceTests {
    @Autowired
    private TransactionService transactionService;

    @Test
    public void TestDoInsert(){
        transactionService.doInsert(null, "한동석");
    }
}
