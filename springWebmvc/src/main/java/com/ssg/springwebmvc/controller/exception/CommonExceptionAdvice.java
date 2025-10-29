package com.ssg.springwebmvc.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

// 스프링 컨트롤러에서 발생하는 예외를 처리하는 일반적인 방식
@ControllerAdvice
@Log4j2
public class CommonExceptionAdvice {
    @ResponseBody // 내가 만든 문자를 그대로 브라우저에 전송("Number Format Exception")
    @ExceptionHandler(value = NumberFormatException.class)
    public String exceptNumber(NumberFormatException numberFormatException) {
        log.error("numberFormatException : "+ numberFormatException.getMessage());
        return "Number Format Exception";
    }

    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // NOT_FOUND : 404번 에러, BAD_REQUEST : 400번 에러, ...
    public String notFound() {
        return "custom404";
    }
}
