package com.ssg.memberservicetest.repository;

import com.ssg.memberservicetest.dto.MemberDTO;

import java.util.List;

public interface MemberDAO {
      int insert(MemberDTO memberDTO);
      List<MemberDTO> findAll();
      MemberDTO findById(String userId);
}
