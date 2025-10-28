package com.ssg.board.service;

import com.ssg.board.dto.PostDTO;

import java.util.List;

public interface PostService {
    List<PostDTO> getList();
    PostDTO getDetail(long id);                // 조회수 증가 포함
    long write(PostDTO post);                   // 검증 + 저장
    void edit(PostDTO post, String passphrase); // 비번검증 + 수정
    void remove(long id, String passphrase);     // 비번검증 + 삭제
}