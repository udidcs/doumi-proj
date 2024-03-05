package com.example.doumiproject.entity;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CoteBoard {
    private long id;
    private long user_id;
    private String title;
    private String contents;
    private long view_count;
}
