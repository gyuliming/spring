package com.ssg.webmvcboard.controller.exception;

import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
@Log4j2
public class GlobalExceptionHandler {

    // 404
    @ExceptionHandler(value = NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND) // NOT_FOUND : 404번 에러, BAD_REQUEST : 400번 에러, ...
    public String notFound() {
        log.error("404 Error");
        return "/error/custom404";
    }

    // 500
    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String internalServerError() {
        log.error("500 Error"); // 로그 기록
        return "/error/custom500";
    }
}
