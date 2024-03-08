package com.example.doumiproject.responsedto;

import lombok.*;

import java.sql.Timestamp;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoteBoardResponseDto {

    private long boardNum;
    private long id;
    private String writer;
    private String title;
    private String contents;
    private long viewCount;
    private Timestamp createdAt;
    private Timestamp updateddAt;
}
