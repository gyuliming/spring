package com.ssg.webmvc1.controller;

import com.ssg.webmvc1.todo.dto.TodoDTO;
import com.ssg.webmvc1.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@WebServlet(name = "todoRegisterController", value = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {

    private TodoService todoService = TodoService.INSTANCE;
    private final DateTimeFormatter DATEFORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 로그인한 사용자만이 Todo 를 등록할 수 있도록 재구성
        log.info("/todo/register GET .......");

//        HttpSession session = req.getSession(); // 세션을 사용하기 위해 HttpSession 사용
//
//        if (session.isNew()) { // 세션이 새로 만들어졌다면(기존에 JSESSIONID가 없는 새로운 요청이라면)
//            log.info("JSESSIONID가 없는 새로운 요청한 사용자");
//            resp.sendRedirect("/login");
//            return;
//        }
//
//        if (session.getAttribute("loginInfo") == null) {
//            log.info("로그인한 정보가 없는 사용자");
//            resp.sendRedirect("/login");
//            return;
//        }

        req.getRequestDispatcher("/WEB-INF/todo/register.jsp").forward(req, resp); // 정상

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        TodoDTO todoDTO = TodoDTO.builder()
                .title(req.getParameter("title"))
                .dueDate(LocalDate.parse(req.getParameter("dueDate"),DATEFORMATTER ))
                .build();

        log.info("/todo/register POST...");
        log.info(todoDTO);
        try {
            todoService.register(todoDTO);
        } catch (Exception e) {
            e.printStackTrace();
        }
        resp.sendRedirect("/todo/list");

    }
}
