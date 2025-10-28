package com.ssg.board.dao;

import com.ssg.board.domain.PostVO;
import com.ssg.board.util.DBUtil;
import lombok.extern.log4j.Log4j2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Log4j2
public enum PostDAOImpl implements PostDAO {
    INSTANCE;

    // 모든 게시글 (최신순)
    @Override
    public List<PostVO> findAll() {
        String sql = "select post_id, title, content, writer, created_at, updated_at from board_post order by post_id desc";

        List<PostVO> voList = new ArrayList<>();

        try (Connection conn = DBUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                PostVO vo = PostVO.builder()
                        .postId(rs.getLong("post_id"))
                        .title(rs.getString("title"))
                        .content(rs.getString("content"))
                        .writer(rs.getString("writer"))
                        .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                        .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                        .build();
                voList.add(vo);
            }
        } catch (SQLException e) {
            log.error("SQL error : " + e.getMessage());
        } catch (Exception e) {
            log.error("error : " + e.getMessage());
        }
        return voList;
    }

    // 게시글 존재 여부 확인
    @Override
    public boolean countAll() {
        String sql = "select 1 from board_post limit 1";

        try (Connection conn = DBUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            return rs.next();
        } catch (SQLException e) {
            log.error("SQL error : " + e.getMessage());
        } catch (Exception e) {
            log.error("error : " + e.getMessage());
        }
        return false;
    }

    // ID로 게시글 조회
    @Override
    public Optional<PostVO> findById(long id) {
        String sql = "select post_id, title, content, writer, created_at, updated_at from board_post where post_id = ?";

        try (Connection conn = DBUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    PostVO vo = PostVO.builder()
                            .postId(rs.getLong("post_id"))
                            .title(rs.getString("title"))
                            .content(rs.getString("content"))
                            .writer(rs.getString("writer"))
                            .createdAt(rs.getTimestamp("created_at").toLocalDateTime())
                            .updatedAt(rs.getTimestamp("updated_at").toLocalDateTime())
                            .build();
                    return Optional.of(vo);
                }
            }
        } catch (SQLException e) {
            log.error("SQL error : " + e.getMessage());
        } catch (Exception e) {
            log.error("error : " + e.getMessage());
        }
        return Optional.empty(); // 값 없음(null 반환 X)
    }

    // 게시글 저장
    @Override
    public long save(PostVO post) {
        String sql = "insert into board_post(title, content, writer, passphrase) values(?, ?, ?, ?)";

        try (Connection conn = DBUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {

            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setString(3, post.getWriter());
            pstmt.setString(4, post.getPassphrase());

            int result = pstmt.executeUpdate();
            if (result > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                       return rs.getLong(1);
                    }
                }
            }
        } catch (SQLException e) {
            log.error("SQL error : " + e.getMessage());
        } catch (Exception e) {
            log.error("error : " + e.getMessage());
        }
        return 0;
    }

    // 게시글 수정
    @Override
    public boolean update(PostVO post) {
        String sql = "update board_post set title = ?, content = ? where post_id = ?";

        try (Connection conn = DBUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, post.getTitle());
            pstmt.setString(2, post.getContent());
            pstmt.setLong(3, post.getPostId());

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            log.error("SQL error : " + e.getMessage());
        } catch (Exception e) {
            log.error("error : " + e.getMessage());
        }
        return false;
    }

    // 게시글 삭제
    @Override
    public boolean delete(long id) {
        String sql = "delete from board_post where post_id = ?";

        try (Connection conn = DBUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);

            int result = pstmt.executeUpdate();
            return result > 0;
        } catch (SQLException e) {
            log.error("SQL error : " + e.getMessage());
        } catch (Exception e) {
            log.error("error : " + e.getMessage());
        }
        return false;
    }

    // 게시글 수정/삭제 비밀번호 확인
    @Override
    public boolean checkPassphrase(long id, String passphrase) {
        String sql = "select count(*) from board_post where post_id = ? and passphrase = ?";

        try (Connection conn = DBUtil.INSTANCE.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setLong(1, id);
            pstmt.setString(2, passphrase);

            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    // 행이 1개 이상 있으면 id, passphrase가 일치하므로 true
                    return rs.getInt(1) > 0;
                }
            }
        } catch (SQLException e) {
            log.error("SQL error : " + e.getMessage());
        } catch (Exception e) {
            log.error("error : " + e.getMessage());
        }
        return false;
    }
}
