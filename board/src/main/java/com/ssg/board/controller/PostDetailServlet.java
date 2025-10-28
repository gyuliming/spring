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

@WebServlet(name = "postDetailServlet", urlPatterns = "/posts/view")
@Log4j2
public class PostDetailServlet extends HttpServlet {
    private PostService postService = PostServiceImpl.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            long postId = Long.parseLong(req.getParameter("id"));

            PostDTO post = postService.getDetail(postId);

            req.setAttribute("post", post);

            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/detail.jsp");
            dispatcher.forward(req, resp);
        } catch (NumberFormatException e) {
            log.error("error : {}", e.getMessage());
            req.setAttribute("errorMessage", "존재하지 않는 게시글 ID 입니다.");
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/error.jsp");
            dispatcher.forward(req, resp);
        } catch (PostException e) {
            log.error("error : {}", e.getMessage());
            req.setAttribute("errorMessage", e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("WEB-INF/views/error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
