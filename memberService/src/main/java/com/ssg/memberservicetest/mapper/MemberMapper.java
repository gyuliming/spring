package com.ssg.memberservicetest.mapper;

import com.ssg.memberservicetest.dto.MemberDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MemberMapper {
       int insert(MemberDTO member);
       List<MemberDTO> findAll();
       MemberDTO findById(@Param("userId") String userId);
}
