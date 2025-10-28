package com.ssg.springwebmvc.member.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Member {
     private String userId;
     private String userPwd;
     private String userName;
     private String userEmail;
     private LocalDate joinDate;
}
