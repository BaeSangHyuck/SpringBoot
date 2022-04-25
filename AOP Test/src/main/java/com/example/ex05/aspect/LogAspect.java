package com.example.ex05.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.stream.Collectors;

@Configuration
@Aspect
@Slf4j
public class LogAspect {
    @Before("@annotation(com.example.ex05.aspect.annotation.LogStatus)")
    public void beforeStart(JoinPoint joinPoint){
        log.info("========================================================");
        log.info("Method " + joinPoint.getSignature().getName() + " Started at " + LocalDateTime.now());
        log.info("Arguments : " + Arrays.stream(joinPoint.getArgs()).map(String::valueOf).collect(Collectors.joining(", ")));
        log.info("========================================================");
    }
    /*
    * doAdd 메소드 종료 직전에 Aspect를 사용하여 메소드의 이름과 그 때의 시간을 출력하는 주변 로직 구현
    * doAdd 메소드 리턴 후 Aspect를 사용하여 메소드의 이름과 리턴된 시간을 출력하는 주변로직 구현
    * */
    @After("@annotation(com.example.ex05.aspect.annotation.LogStatus)")
    public void afterStart(JoinPoint joinPoint){
        log.info("========================================================");
        log.info("Method " + joinPoint.getSignature().getName() + " Ended at " + LocalDateTime.now());
        log.info("========================================================");
    }

    @AfterReturning(value = "@annotation(com.example.ex05.aspect.annotation.LogStatus)", returning = "returnValue")
    public void afterReturningStart(JoinPoint joinPoint, Integer returnValue){
        log.info("========================================================");
        log.info("Method " + joinPoint.getSignature().getName() + " Returned " + returnValue +" at " + LocalDateTime.now());
        log.info("========================================================");
    }

    @AfterThrowing(value = "@annotation(com.example.ex05.aspect.annotation.LogStatus)", throwing = "e")
    public void afterThrowingStart(NumberFormatException e){
        log.info("Wrong parameter, change to Integer");
    }
}



















