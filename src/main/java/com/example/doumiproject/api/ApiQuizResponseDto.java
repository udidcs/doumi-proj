package com.example.doumiproject.api;

import com.example.doumiproject.dto.PostDto;
import com.example.doumiproject.entity.Quiz;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class ApiQuizResponseDto {
    private int page;
    private int totalpage;
    private List<PostDto> lst;
}
