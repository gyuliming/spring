package com.ssg.memberservicetest.service;

import com.ssg.memberservicetest.dto.MemberDTO;
import com.ssg.memberservicetest.dto.MemberDTO;

import java.util.List;

public interface MemberService {
    void joinMember(MemberDTO member);
    List<MemberDTO> memberList();
    MemberDTO findById(String userId);
}
