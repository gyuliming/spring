package com.ssg.springex.servlet_basic;

import java.io.*;
import javax.servlet.http.*; // javax = java extension, servlet을 사용해야 웹 상에서 클래스를 운영할 수 있음
import javax.servlet.annotation.*;

// 어노테이션을 사용해서 name과 value 지정(index.jsp에서 /hello-servlet 링크를 통해서 호출함)
// 웹 서블릿에서는 변경이 일어나면 컨테이너에 적재를 다시 해주어야함 (반영이 바로 안됨) => 자바 컨테이너가 다루는 영역
// webapp에서는 변경이 일어나도 반영이 바로 됨
@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    // HttpServletRequest request, HttpServletResponse response : WAS가 제공해주는 객체(HTTP는 하나의 요청에 대해 하나의 응답을 지켜줘야함)
    // request의 객체에 클라이언트의 정보(요청)를 담고, response 객체에 서버의 정보(응답)을 담음
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        // 아래 html 구조를 클라이언트에 보냄 -> 클라이언트는 역직렬화를 구성
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + message + "</h1>");
        out.println("</body></html>");
    }

    public void destroy() {
    }
}