package com.ssg.springwebmvc.controller;

import com.ssg.springwebmvc.dto.TodoDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/todo")
@Log4j2
public class TodoController {
    @RequestMapping("/list")
    public void list() {
        log.info("Todo list Controller");
    }

    @RequestMapping(value = "/register", method = RequestMethod.GET) // GET 방식
//    @GetMapping("/register") = 같은 의미
    public void register() {
        log.info("TodoController Register Method");
    }

    @PostMapping("/register")
    public void registerPost(TodoDTO todoDTO) {
        log.info("Post Todo register");
        log.info(todoDTO);
    }
}
