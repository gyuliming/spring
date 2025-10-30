package com.ssg.webmvcboard.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDTO {
    private Long tno;
    @NotBlank
    private String title;
    @NotEmpty
    private String content;
    @NotEmpty
    private String writer;
//    @NotEmpty
//    private String passphrase;
    private LocalDate created_at;
    private LocalDate updated_at;

    private int viewCount;
//    private String fileName;
//    private String fileType;
//    private byte[] filePath;
}
