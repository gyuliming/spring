package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// value 값만 매핑해줘도 됨
@WebServlet("/login3")
public class LoginServletJs extends HttpServlet {

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

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter(); // Servlet에서 클라이언트(브라우저)로 데이터를 출력할 때 사용

        String user_id = request.getParameter("user_id");
        String user_pw = request.getParameter("user_pw");
        String user_address = request.getParameter("user_address");

        String data = "<html>";
        data += "<body>";
        data += "<h1>" + user_id + "</h1>";
        data += "<h1>" + user_pw + "</h1>";
        data += "<h1>" + user_address + "</h1>";
        data += "<a href='http://localhost:8080/login2.html'>로그인 화면으로 돌아가기</a>";
        data += "</body>";
        data += "</html>";
        out.print(data);
    }
}
