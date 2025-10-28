create table board_post(
    post_id BIGINT PRIMARY KEY AUTO_INCREMENT, # 글 번호
    title VARCHAR(200) NOT NULL,               # 글 제목
    content TEXT NOT NULL, # 글 내용
    writer VARCHAR(50) NOT NULL, # 글쓴이
    passphrase VARCHAR(100) NOT NULL, # 수정/삭제용 비밀번호
    created_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP, # 글 생성 날짜
    updated_at DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP # 글 수정 날짜
);