package com.ssg.memberservicetest.repository;

import com.ssg.memberservicetest.dto.MemberDTO;
import com.ssg.memberservicetest.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class MemberDAOImpl implements MemberDAO {

    private final MemberMapper memberMapper;

    @Override
    public int insert(MemberDTO memberDTO) {
        return memberMapper.insert(memberDTO);
    }

    @Override
    public List<MemberDTO> findAll() {
        return memberMapper.findAll();
    }

    @Override
    public MemberDTO findById(String userId) {
        return memberMapper.findById(userId);
    }
}