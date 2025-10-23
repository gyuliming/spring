package com.ssg.springex.servlet_member;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/servlet_member/member")
public class MemberRegisterController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        MemberDAO dao = new MemberDAO();
        req.setCharacterEncoding("UTF-8");

        MemberVO member = new MemberVO();
        member.setUserId(req.getParameter("user_id"));
        member.setUserPwd(req.getParameter("user_pwd"));
        member.setUserRepwd(req.getParameter("user_repwd"));
        member.setGender(req.getParameter("gender")); // null 처리 해주기
        member.setHobbies(req.getParameterValues("hobby")); // null 처리 해주기

        boolean success = false;

        if (member.getUserPwd() != null && member.getUserPwd().equals(member.getUserRepwd())) {
            success = dao.insertMember(member);
        }

        req.setAttribute("memberName", member.getUserId());
        req.setAttribute("success", success);

        req.getRequestDispatcher("result.jsp").forward(req, resp);
    }
}