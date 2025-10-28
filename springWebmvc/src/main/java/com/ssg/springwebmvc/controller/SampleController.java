package com.ssg.springwebmvc.controller;

import com.ssg.springwebmvc.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller // 해당 클래스가 스프링 MVC 에서 컨트롤러의 역할 및 스프링의 빈으로 등록
@Log4j2
public class SampleController {
    @GetMapping("/hello")
    public void hello() {
        log.info("hello springwebmvc");
    }

    // http://localhost:8080/ex01?name=AAA&age=20 주소창에 입력(GET 방식)
    @GetMapping("/ex01")
    public void ex01(String name, int age) {
        log.info("ex01에서 수집한 파라미터");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex02")
    // 데이터를 안보내면 defaultValue의 값이 들어감
    public void ex02(@RequestParam(name = "name", defaultValue = "lalala") String name,
                     @RequestParam(name = "age", defaultValue = "25") int age) {
        log.info("ex02에서 수집한 파라미터");
        log.info("name : " + name);
        log.info("age : " + age);
    }

    @GetMapping("/ex03")
    // 날짜는 포매팅이 필수적으로 필요, 안하는 경우 400에러가 뜨는 경우가 있음
    public void ex03(LocalDate dueDate) {
        log.info("ex03에서 수집한 파라미터");
        log.info("dueDate : " + dueDate);
    }

    @GetMapping("/ex04")
    public void ex04(Model model) {
        log.info("ex04 Model 파라미터");
        model.addAttribute("message", "Hello Spring MVC");
    }

    @GetMapping("/ex04_1")
    public void ex04_1(TodoDTO todoDTO, Model model) {
        log.info(todoDTO);
        model.addAttribute("todoDTO", todoDTO);
    }
}
