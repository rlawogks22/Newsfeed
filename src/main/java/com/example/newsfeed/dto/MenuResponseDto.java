package com.example.newsfeed.dto;

import com.example.newsfeed.entity.Menu;
import lombok.Getter;

@Getter
public class MenuResponseDto {
    private String title;
    private String content;

    public MenuResponseDto(Menu menu) {
        this.title = menu.getTitle();
        this.content = menu.getContent();
    }

}
