package com.example.doumiproject.vo;

import lombok.Data;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
public class PostVO {

    private long id;
    private long userId;
    private String type;
    private String title;
    private String contents;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;
    private long like;
}
