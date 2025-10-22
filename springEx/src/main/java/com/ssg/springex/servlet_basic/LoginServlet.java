package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

// value 값만 매핑해줘도 됨
@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("LoginServlet init");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8"); // request에 저장된 데이터를 UTF-8로 셋

        // Parameter는 무조건 String으로 받고 나중에 변환하기
        String userid = request.getParameter("user_id");
        String userpw = request.getParameter("user_pw");

        // console에 출력
        System.out.println(userid);
        System.out.println(userpw);

        // servlet에 출력
        response.setContentType("text/html; charset=UTF-8");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "아이디 : " + userid + "</h1>");
        out.println("<h1>" + "비밀번호 : " + userpw + "</h1>");
        out.println("</body></html>");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request, response);
    }
}
