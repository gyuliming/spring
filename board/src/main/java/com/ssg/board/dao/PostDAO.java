package com.ssg.board.dao;

import com.ssg.board.domain.PostVO;

import java.util.List;
import java.util.Optional;

public interface PostDAO {
    // 모든 게시글 최신순
    List<PostVO> findAll();

    // 게시글 존재 여부 확인
    boolean countAll();

    // ID로 게시글 조회
    Optional<PostVO> findById(long id);

    // 게시글 저장
    long save(PostVO post);

    // 게시글 수정
    boolean  update(PostVO post);

    // 게시글 삭제
    boolean  delete(long id);

    // 게시글 수정/삭제 비밀번호 확인
    boolean checkPassphrase(long id, String passphrase);
}