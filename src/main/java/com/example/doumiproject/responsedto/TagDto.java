package com.example.doumiproject.responsedto;
import lombok.*;

import java.util.List;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class TagDto {
    String type;
    List<TagDetailDto> detailTags;
}
