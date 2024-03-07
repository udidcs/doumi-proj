package com.example.doumiproject.responsedto;

import com.example.doumiproject.entity.CoteBoardComment;
import lombok.*;

import java.sql.Timestamp;
import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoteBoardCommentResponseDto {
    int id;
    String writer;
    String commentPassword;
    int postId;
    String contents;
    int parentCommentId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
    private List<CoteBoardComment> reComments;
}
