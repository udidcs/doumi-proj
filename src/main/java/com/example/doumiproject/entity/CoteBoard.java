package com.example.doumiproject.entity;

import lombok.*;

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
}
