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

@WebServlet(name = "postUpdateServlet", urlPatterns = "/posts/update")
@Log4j2
public class PostUpdateServlet extends HttpServlet {
    private PostService postService = PostServiceImpl.INSTANCE;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        long postId = 0;
        String passphrase = req.getParameter("passphrase");
        PostDTO postDTO = null;

        try {
            postId = Long.parseLong(req.getParameter("postId"));

            postDTO = PostDTO.builder()
                    .postId(postId)
                    .title(req.getParameter("title"))
                    .content(req.getParameter("content"))
                    .build();

            postService.edit(postDTO, passphrase);

            resp.sendRedirect("/posts/view?id=" + postId);

        } catch (PostException e) {
            log.error("error : {}", e.getMessage());
            req.setAttribute("errorMessage", e.getMessage());

            PostDTO originalPost = postService.getDetail(postId);
            originalPost.setTitle(postDTO.getTitle());
            originalPost.setContent(postDTO.getContent());

            req.setAttribute("post", originalPost);
            req.setAttribute("isEdit", true);

            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/form.jsp");
            dispatcher.forward(req, resp);

        } catch (Exception e) {
            log.error("error : {}", e.getMessage());
            req.setAttribute("errorMessage", "업데이트 중 오류 발생 : " + e.getMessage());
            RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/error.jsp");
            dispatcher.forward(req, resp);
        }
    }
}
