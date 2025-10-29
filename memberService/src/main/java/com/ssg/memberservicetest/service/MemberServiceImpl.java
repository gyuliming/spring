package com.ssg.memberservicetest.service;


import com.ssg.memberservicetest.dto.MemberDTO;

import com.ssg.memberservicetest.mapper.MemberMapper;
import com.ssg.memberservicetest.repository.MemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberDAO memberDAO;

    @Override
    @Transactional
    public void joinMember(MemberDTO member) {
        memberDAO.insert(member);

    }

    @Override
    @Transactional(readOnly = true)
    public List<MemberDTO> memberList() {
        return memberDAO.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public MemberDTO findById(String userId) {
        return memberDAO.findById(userId);
    }
}
