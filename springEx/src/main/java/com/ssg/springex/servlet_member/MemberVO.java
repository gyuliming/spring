package com.ssg.springex.servlet_member;

import lombok.Data;

@Data
public class MemberVO {
    private String userId;
    private String userPwd;
    private String userRepwd;
    private String gender;
    private String[] hobbies;
}