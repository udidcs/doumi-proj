package com.example.doumiproject.requestdto;

import com.example.doumiproject.entity.CoteBoardComment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoteBoardCommentRequestDto {
    int id;
    String writer;
    String commentPassword;
    int postId;
    String contents;
    int parentCommentId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<CoteBoardComment> reComments;

    public CoteBoardComment toEntity() {
        return new CoteBoardComment(id, writer, commentPassword, postId, contents,
                parentCommentId, createdAt, updatedAt);
    }
}
