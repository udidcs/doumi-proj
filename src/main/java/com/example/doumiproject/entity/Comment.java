package com.example.doumiproject.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment {
    long postId;
    String contents;
    long parentCommentId;
    boolean display;
}

