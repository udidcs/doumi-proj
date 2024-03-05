package com.example.doumiproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
