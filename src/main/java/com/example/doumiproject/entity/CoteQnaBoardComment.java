package com.example.doumiproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoteQnaBoardComment {
    int id;
    String writer;
    int postId;
    String contents;
    int parentCommentId;
    private Timestamp createdAt;
    private Timestamp updatedAt;
}

