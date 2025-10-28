package com.ssg.springwebmvc.member.repository;

import com.ssg.springwebmvc.member.dto.Member;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.OptionalLong;

public interface MemberDAO {

      int insert(Member member);
      List<Member> findAll();

}
