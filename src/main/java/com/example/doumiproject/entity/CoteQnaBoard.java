package com.example.doumiproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoteQnaBoard {
    private int id;
    private String writer;
    private String boardPassword;
    private String title;
    private String contents;
    private int viewCount;
    private Timestamp createdAt;
    private Timestamp updateddAt;
}
