package com.example.doumiproject.responsedto;

import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoteBoardDto {

    private long boardNum;
    private long id;
    private long userId;
    private String title;
    private String contents;
    private long viewCount;
}
