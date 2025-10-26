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

@WebServlet(name = "todoModifyController", urlPatterns = "/todo/modify")
@Log4j2
public class TodoModifyController extends HttpServlet {
    TodoService todoService = TodoService.INSTANCE;
    TodoDTO dto = new TodoDTO();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("TodoModifyController doGet()");
        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/todo/modify.jsp");
        dispatcher.forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        log.info("TodoModifyController doPost()");

        try {
            Long tno = Long.parseLong(req.getParameter("tno"));
            String title = req.getParameter("title");
            LocalDate dueDate = LocalDate.parse(req.getParameter("dueDate"));
            boolean finished = Boolean.parseBoolean(req.getParameter("finished"));

            dto.setTno(tno);
            dto.setTitle(title);
            dto.setDueDate(dueDate);
            dto.setFinished(finished);

            todoService.update(dto);
            resp.sendRedirect("/todo/list");

        } catch (Exception e) {
            log.error(e.getMessage());
        }
    }
}
