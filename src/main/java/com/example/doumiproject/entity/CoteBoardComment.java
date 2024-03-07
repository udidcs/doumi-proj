package com.example.doumiproject.entity;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoteBoardComment {
    int id;
    String writer;
    String commentPassword;
    int postId;
    String contents;
    int parentCommentId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

