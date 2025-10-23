package com.ssg.webmvc.todo.dto;

import lombok.Data;

import java.time.LocalDate;

// DTO : 여러 개의 데이터를 묶어서 하나의 객체로 구성
// 서비스 객체 메소드들의 파라미터나 리턴 타입으로 사용
@Data
public class TodoDTO {
    private long tno; // 할 일 고유값 pk
    private String title; // 할 일 제목
    private LocalDate dueDate; // 등록 시간
    private boolean finished; // 할 일 체크
}
