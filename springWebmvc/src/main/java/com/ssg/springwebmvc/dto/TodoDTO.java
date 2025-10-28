package com.ssg.springwebmvc.dto;

import lombok.*;

import java.time.LocalDate;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
    private Long tno;
    private String title;
    private LocalDate dueDate;
    private boolean finished;
    private String writer;
}
