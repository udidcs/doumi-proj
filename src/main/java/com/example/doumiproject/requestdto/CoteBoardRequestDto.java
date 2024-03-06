package com.example.doumiproject.requestdto;

import com.example.doumiproject.entity.CoteBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class CoteBoardRequestDto {

    private String userPassword;
    private String writer;
    private String boardPassword;
    private String title;
    private String contents;

}
