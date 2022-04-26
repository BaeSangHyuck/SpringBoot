package com.example.ex05.aspect.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.METHOD) // 동작할 대상을 결정
@Retention(RetentionPolicy.RUNTIME) // 생명 주기(RUNTIME - 실행중인 동안)
public @interface LogStatus {;}
