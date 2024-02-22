package com.example.doumiproject.dto;

import lombok.*;

import java.util.List;

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
    private List<TagDetailDto> tags;
}
