package com.example.ex02.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

@Controller // Exception을 처리 하기 위해 공통적인 예외사항에 대해서는 Advice로 분리한다.
@Slf4j
public class CustomError implements ErrorController{

    @GetMapping("/error")
    public String handleError(HttpServletRequest request){
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if(status != null){
            int statusCode = Integer.valueOf(status.toString()); //오토 언박싱
            if(statusCode == HttpStatus.NOT_FOUND.value()){
                return "error/404";
            }
        }
        return "error/500";
    }

}