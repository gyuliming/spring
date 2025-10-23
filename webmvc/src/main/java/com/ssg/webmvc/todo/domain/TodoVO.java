package com.ssg.webmvc.todo.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.time.LocalDate;

// VO(Value Object) 읽기 전용
@Getter // 읽기만
@Builder // 객체 생성 시 빌더 패턴 이용
@ToString // 객체값 확인
public class TodoVO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
}
