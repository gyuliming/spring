package com.ssg.springwebmvc.mapper;

import org.apache.ibatis.annotations.Select;

// 데이터베이스의 현재 시각을 문자열로 처리하는 메소드 getTimeNow()
// 기능을 가진 매퍼 인터페이스
public interface TimeMapper {
    @Select("select now()")
    String getTimeNow(); // DB 작업 요청
}
