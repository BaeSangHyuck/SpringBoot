package com.example.ex01.mappers;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class TimeMapperTests {
    @Autowired
    private TimeMapper timeMapper;

    @Test
    public void testGetTime(){
        String sysdate = timeMapper.getTime();
        log.info("------------------------------");
        log.info("sysdate : " + sysdate);
        log.info("------------------------------");
    }

}
