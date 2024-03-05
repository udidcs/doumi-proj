package com.example.doumiproject.responsedto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class ReCommentDto {
    private long id;
    private long userId;
    private String author;
    private String contents;
    private java.sql.Timestamp createdAt;
    private long like;
    private int display;
}
