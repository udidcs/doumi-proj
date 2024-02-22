package com.example.doumiproject.dto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TagDetailDto {
    String name;
    long id;
}
