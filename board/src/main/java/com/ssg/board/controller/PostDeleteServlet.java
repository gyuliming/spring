package com.ssg.board.controller;

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
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "postDeleteServlet", urlPatterns = "/posts/delete")
@Log4j2
public class PostDeleteServlet extends HttpServlet {
    private PostService postService = PostServiceImpl.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        long postId = 0;
        try {
            postId = Long.parseLong(req.getParameter("postId"));
            String passphrase = req.getParameter("passphrase");

            postService.remove(postId, passphrase);

            resp.sendRedirect("/posts");

        } catch (PostException e) {
            HttpSession session = req.getSession();
            log.error("error : {}", e.getMessage());
            session.setAttribute("errorMessage", e.getMessage());
            resp.sendRedirect("/posts/view?id=" + postId);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
            req.setAttribute("errorMessage", "삭제 중 오류 발생 : " + e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}