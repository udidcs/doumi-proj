package com.example.doumiproject.dto;
import lombok.*;

import java.util.List;
import java.util.Map;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TagDto {
    String type;
    List<TagDetailDto> detailTags;
}
