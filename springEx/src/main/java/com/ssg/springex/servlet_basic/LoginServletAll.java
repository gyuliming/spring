package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

// value 값만 매핑해줘도 됨
@WebServlet("/login1")
public class LoginServletAll extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doPost() 메서드 호출");
        doHandle(request, response);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("LoginServlet doGet() 메서드 호출");
        doHandle(request, response);
    }

    // get, post로 요청이 오는 모든 거를 doHandle이 담당
    private void doHandle(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("doHandle() 메서드 호출");
        request.setCharacterEncoding("UTF-8");

        String userid = request.getParameter("user_id");
        String userpw = request.getParameter("user_pw");
        System.out.println(userid);
        System.out.println(userpw);

    }
}
