package com.ssg.webmvc1.todo.dao;

import com.ssg.webmvc1.todo.domain.MemberVO;
import lombok.Cleanup;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class MemberDAO {

    public MemberVO getWithPassword(String mid, String mpw) throws Exception {
        String sql = "select * from t_member where mid = ? and mpw = ?";
        MemberVO memberVO = null;

        @Cleanup Connection connection = ConnectionUtil.INSTANCE.getConnection();
        @Cleanup PreparedStatement pstmt = connection.prepareStatement(sql);
        pstmt.setString(1, mid);
        pstmt.setString(2, mpw);

        @Cleanup ResultSet rs = pstmt.executeQuery();
        rs.next(); // 한 행이므로 while 필요 X
        memberVO = MemberVO.builder()
                .mid(rs.getString("mid"))
                .mpw(rs.getString("mpw"))
                .mname(rs.getString("mname"))
                .build();

        return memberVO;
    }
}
