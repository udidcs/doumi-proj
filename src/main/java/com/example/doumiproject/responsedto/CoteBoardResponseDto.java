package com.example.doumiproject.responsedto;

import lombok.*;

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
}
