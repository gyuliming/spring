package com.ssg.board.controller;

import com.ssg.board.dto.PostDTO;
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
import java.util.List;

@WebServlet(name = "postListServlet", urlPatterns = "/posts")
@Log4j2
public class PostListServlet extends HttpServlet {
    private PostService postService = PostServiceImpl.INSTANCE;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<PostDTO> postList = postService.getList();

            req.setAttribute("postList", postList);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/list.jsp");
            dispatcher.forward(req, resp);
        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
            req.setAttribute("errorMessage", "목록 조회 중 에러발생 : " + e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
