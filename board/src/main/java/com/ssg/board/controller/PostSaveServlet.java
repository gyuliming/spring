package com.ssg.board.controller;

import com.ssg.board.dto.PostDTO;
import com.ssg.board.exception.PostException;
import com.ssg.board.service.PostService;
import com.ssg.board.service.PostServiceImpl;
import lombok.extern.log4j.Log4j2;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "postSaveServlet", urlPatterns = "/posts/save")
@Log4j2
public class PostSaveServlet extends HttpServlet {
    private PostService postService = PostServiceImpl.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        PostDTO postDTO = PostDTO.builder()
                .title(req.getParameter("title"))
                .content(req.getParameter("content"))
                .writer(req.getParameter("writer"))
                .passphrase(req.getParameter("passphrase"))
                .build();

        try {
            postService.write(postDTO);

            resp.sendRedirect("/posts");
        } catch (PostException e) {
            log.error("error : {}", e.getMessage());
            req.setAttribute("errorMessage", e.getMessage());
            req.setAttribute("post", postDTO);
            req.setAttribute("isEdit", false);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/form.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
