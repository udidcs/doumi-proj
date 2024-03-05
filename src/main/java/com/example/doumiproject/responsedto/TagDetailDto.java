package com.example.doumiproject.responsedto;

import lombok.*;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TagDetailDto {
    String name;
    long id;
}
