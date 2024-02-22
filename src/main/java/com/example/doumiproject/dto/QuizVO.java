package com.example.doumiproject.dto;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuizVO {
    private String title; // 퀴즈 제목
    private String tags; // 선택된 태그 목록
    private String quizContent;
    private String answerContent;
}
