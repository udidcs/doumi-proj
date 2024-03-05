package com.example.doumiproject.responsedto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CommentDto {
    private long id;
    private long userId;
    private String author;
    private String contents;
    private java.sql.Timestamp createdAt;
    private long like;
    private int display;
    private List<ReCommentDto> reComments;
}
