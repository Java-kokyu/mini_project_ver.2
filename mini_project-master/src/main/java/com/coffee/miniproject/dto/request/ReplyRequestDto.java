package com.coffee.miniproject.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReplyRequestDto {
    private String contents;
    private Long parentId;
    private Long postId;
    private Long memberId;
}
