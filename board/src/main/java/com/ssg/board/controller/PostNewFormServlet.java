package com.ssg.board.controller;

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

@WebServlet(name = "postNewFormServlet", urlPatterns = "/posts/new")
public class PostNewFormServlet extends HttpServlet {
    private PostService postService = PostServiceImpl.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setAttribute("isEdit", false);

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/form.jsp");
        dispatcher.forward(req, resp);
    }
}
