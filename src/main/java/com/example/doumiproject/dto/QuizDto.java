package com.example.doumiproject.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class QuizDto {
    private long id;
    private String userId;
    private String title;
    private String contents;
    private  String answer;
    private java.sql.Timestamp createdAt;
    private long like;
}
