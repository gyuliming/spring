package com.ssg.springwebmvc.member.service;


import com.ssg.springwebmvc.member.dto.Member;
import com.ssg.springwebmvc.member.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;



    @Override
    @Transactional
    public void joinMember(Member member) {
         memberDAO.insert(member);

    }

    @Override
    @Transactional
    public List<Member> memberList() {
        return memberDAO.findAll();
    }
}
