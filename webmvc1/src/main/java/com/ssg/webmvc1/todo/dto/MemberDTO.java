package com.ssg.webmvc1.todo.dto;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String mid;
    private String mpw;
    private String mname;
}
