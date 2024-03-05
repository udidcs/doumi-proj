package com.example.doumiproject.responsedto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class PostDto {

    private long id;
    private String userId;
    private String type;
    private String title;
    private String contents;
    private java.sql.Timestamp createdAt;
    private java.sql.Timestamp updatedAt;
    private long like;
}
