package com.ssg.webmvc.todo;

import com.ssg.webmvc.todo.dto.TodoDTO;
import com.ssg.webmvc.todo.service.TodoService;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet(name="todoRegisterController", urlPatterns = "/todo/register")
@Log4j2
public class TodoRegisterController extends HttpServlet {
    private TodoService todoService = TodoService.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("입력 화면을 볼 수 있도록 구성");
        log.info("입력 화면을 볼 수 있도록 구성");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
        dispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("입력을 처리하고 목록 페이지로 이동");
        log.info("입력을 처리하고 목록 페이지로 이동");
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String dueDateStr = req.getParameter("dueDate");

        if (title == null || title.isEmpty()) {
            req.setAttribute("errorMsg", "제목을 입력해주세요.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/register.jsp");
            dispatcher.forward(req, resp);
            return;
        }

        TodoDTO dto = new TodoDTO();
        dto.setTitle(title);
        dto.setDueDate(LocalDate.parse(dueDateStr));

        try {
            todoService.register(dto);
            resp.sendRedirect("/todo/list");
        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
