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

    int postId;
    String writer;
    String commentPassword;
    String contents;
    int parentCommentId;

    public CoteBoardComment toEntity() {
        return new CoteBoardComment(0, writer, commentPassword, postId, contents,
                parentCommentId, null, null);
    }
}
