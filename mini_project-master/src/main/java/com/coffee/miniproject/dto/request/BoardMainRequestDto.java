package com.coffee.miniproject.dto.request;

import com.coffee.miniproject.model.BoardMain;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardMainRequestDto {
    private String title;
    private String contents;
    private String img;

    public BoardMain toEntity() {
        return BoardMain.builder()
                .title(title)
                .contents(contents)
                .img(img)
                .build();
    }
}
