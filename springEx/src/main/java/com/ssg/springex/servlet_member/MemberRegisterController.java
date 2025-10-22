    package com.ssg.springex.servlet_member;

    import javax.servlet.ServletException;
    import javax.servlet.annotation.WebServlet;
    import javax.servlet.http.HttpServlet;
    import javax.servlet.http.HttpServletRequest;
    import javax.servlet.http.HttpServletResponse;
    import java.io.IOException;
    import java.io.PrintWriter;

    @WebServlet("/servlet_member/member")
    public class MemberRegisterController extends HttpServlet {
        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            req.setCharacterEncoding("UTF-8");

            String user_id = req.getParameter("user_id");
            String user_pwd = req.getParameter("user_pwd");
            String user_repwd = req.getParameter("user_repwd");
            String gender = req.getParameter("gender");
            String[] hobbies = req.getParameterValues("hobby"); // 복수 선택가능이므로 배열

            resp.setContentType("text/html;charset=UTF-8");


        }
    }
