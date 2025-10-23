package com.ssg.webmvc.todo.service;

import com.ssg.webmvc.todo.dto.TodoDTO;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

// enum 클래스
// 장점 : 정해진 수만큼 객체를 생성할 수 있다.
public enum TodoService {
    INSTANCE; // 객체의 개수를 결정할 때 사용
              // 현재 INSTANCE가 1개이므로 서비스 객체도 1개만 사용
              // TodoService.INSTANCE로 접근
              // 객체를 하나만 생성해서 사용 => Singleton pattern
              // 여러 컨트롤러들이 TodoService 객체를 통해서 원하는 데이터를 주고 받는 구조로 구성

    public void register(TodoDTO todoDTO) {
        System.out.println("DEBUG...." + todoDTO);
    }

    // 10개의 TodoDTO 객체를 만들어 반환
    public List<TodoDTO> getList() {
        List<TodoDTO> todoDTOS = IntStream.range(0, 10).mapToObj(
                i -> {
                    TodoDTO dto = new TodoDTO();
                    dto.setTno((long) i);
                    dto.setTitle("Todo..title" + i);
                    dto.setDueDate(LocalDate.now());
                    return dto;
                }
        ).collect(Collectors.toList());
        return todoDTOS;
    }

    // TodoReadController가 요청
    public TodoDTO get(Long tno) {
        TodoDTO dto = new TodoDTO();
        dto.setTno(tno);
        dto.setTitle("Sample Todo");
        dto.setDueDate(LocalDate.now());
        dto.setFinished(true);
        return dto;
    }
}
