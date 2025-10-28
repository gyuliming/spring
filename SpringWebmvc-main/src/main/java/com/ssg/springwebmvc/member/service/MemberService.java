package com.ssg.springwebmvc.member.service;

import com.ssg.springwebmvc.member.dto.Member;

import java.util.List;

public interface MemberService {
    void joinMember(Member member);
    List<Member> memberList();
}
