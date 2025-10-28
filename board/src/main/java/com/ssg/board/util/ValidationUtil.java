package com.ssg.board.util;

import com.ssg.board.dto.PostDTO;
import com.ssg.board.exception.PostException;

public enum ValidationUtil {
    INSTANCE;

    public void validatePost(PostDTO post, boolean isNewPost) {
        if (post.getTitle() == null || post.getTitle().length() < 2 || post.getTitle().length() > 200) {
            throw new PostException("제목은 2~200자 사이여야 합니다.");
        }
        if (post.getContent() == null || post.getContent().length() < 5) {
            throw new PostException("내용은 5자 이상이어야 합니다.");
        }

        // 새 글일 때, 작성자와 비밀번호 유효성 검사
        if (isNewPost) {
            if (post.getWriter() == null || post.getWriter().length() < 1 || post.getWriter().length() > 50) {
                throw new PostException("작성자는 1~50자 사이여야 합니다.");
            }
            if (post.getPassphrase() == null || post.getPassphrase().length() < 4 || post.getPassphrase().length() > 20) {
                throw new PostException("비밀번호는 4~20자 사이여야 합니다.");
            }
        }
    }
}
