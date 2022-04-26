package com.example.ex05.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

import java.time.Duration;
import java.time.Instant;

@Configuration
@Aspect
@Slf4j
public class Plus10Aspect {
//    @Around를 사용하게 되면 핵심로직의 주도권을 가져올 수 있다.
    @Around("@annotation(com.example.ex05.aspect.annotation.Plus10)")
    public Integer aroundPlus10(ProceedingJoinPoint proceedingJoinPoint){
        Integer result = 0;
        Instant start = Instant.now();
        try {
            // 핵심 로직 실행
            result = (Integer)proceedingJoinPoint.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        Instant end = Instant.now();

        log.info("runtime : " + Duration.between(start, end).toMillis());

        // 핵심 로직 리턴값 리턴
        return result + 10;
    }
}
