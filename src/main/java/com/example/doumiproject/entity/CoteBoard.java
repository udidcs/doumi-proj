package com.example.doumiproject.entity;

import lombok.*;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoteBoard {
    private int id;
    private String writer;
    private String boardPassword;
    private String title;
    private String contents;
    private int viewCount;
    private Timestamp createdAt;
    private Timestamp updateddAt;

}
