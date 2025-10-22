package com.ssg.springex.servlet_basic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/calculate")
public class Calculate extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String strX = request.getParameter("x");
        String strY = request.getParameter("y");
        String operator = request.getParameter("operator");

        int x = Integer.parseInt(strX);
        int y = Integer.parseInt(strY);

        int result = 0;
        switch(operator) {
            case "+" : result = x + y; break;
            case "-" : result = x - y; break;
            case "*" : result = x * y; break;
            case "/" : result = x / y; break;
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + x + " " + operator + " " + y + " = " + result + "</h1>");
        out.println("</body></html>");
    }
}
