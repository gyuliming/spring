package com.ssg.springwebmvc.member.repository;

import com.mysql.cj.protocol.Resultset;
import com.ssg.springwebmvc.member.dto.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
@RequiredArgsConstructor

public class MemberDAOImpl implements MemberDAO {

    private final JdbcTemplate jdbcTemplate;


    private static final RowMapper<Member> MEMBER_ROW_MAPPER = new RowMapper<Member>() {

        @Override
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member member = new Member();
            member.setUserId(rs.getString("userId"));
            member.setUserPwd(rs.getString("userPwd"));
            member.setUserName(rs.getString("userName"));
            member.setUserEmail(rs.getString("userEmail"));
            java.sql.Date joinDate = rs.getDate("joinDate");
            member.setJoinDate(joinDate != null ? joinDate.toLocalDate() : null);
            return member;
        }
    };


    @Override
    public int insert(Member member) {
        String sql = "INSERT INTO member(userId, userPwd, userName, userEmail, joinDate) " +
                "VALUES (?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                member.getUserId(),
                member.getUserPwd(),
                member.getUserName(),
                member.getUserEmail(),
                java.sql.Date.valueOf(member.getJoinDate())
        );
    }

    @Override
    public List<Member> findAll() {
        String sql = "SELECT  userId, userPwd, userName, userEmail, joinDate FROM member ORDER BY userId";
        return jdbcTemplate.query(sql, MEMBER_ROW_MAPPER);
    }
}
