package com.example.doumiproject.api;

import com.example.doumiproject.responsedto.PostDto;
import lombok.Data;

import java.util.List;

@Data
public class ApiQuizResponseDto {
    private int page;
    private int totalpage;
    private List<PostDto> lst;
}
