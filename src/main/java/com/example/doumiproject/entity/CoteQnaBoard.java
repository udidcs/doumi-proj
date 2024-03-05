package com.example.doumiproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoteQnaBoard {
    private long id;
    private long user_id;
    private String title;
    private String contents;
    private long view_count;
}
