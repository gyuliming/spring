package com.ssg.springex.servlet_member;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MemberDAO {
    private static HikariDataSource ds;

    static {
        try {
            HikariConfig config = new HikariConfig();
            config.setDriverClassName("com.mysql.cj.jdbc.Driver");
            config.setJdbcUrl("jdbc:mysql://localhost:3306/sqldb?serverTimezone=Asia/Seoul");
            config.setUsername("root");
            config.setPassword("Songkl123!");
            ds = new HikariDataSource(config);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean insertMember(MemberVO member) {
        String sql = "insert into memberInfo(userId, userPwd, gender, hobbies, joinDate) values(?, ?, ?, ?, now())";

        try (Connection conn = ds.getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, member.getUserId());
            pstmt.setString(2, member.getUserPwd());
            pstmt.setString(3, member.getGender());

            String hobbies = (member.getHobbies() != null) ? String.join(",", member.getHobbies()) : "";
            pstmt.setString(4, hobbies);

            return pstmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}