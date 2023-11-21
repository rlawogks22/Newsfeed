package com.example.newsfeed.dto;

import com.example.newsfeed.entity.Menu;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import org.springframework.cglib.core.Local;

import java.time.LocalDateTime;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Getter
public class MenuResponseDto {
    private String title;
    private String content;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;

    public MenuResponseDto(Menu menu) {
        this.title = menu.getTitle();
        this.content = menu.getContent();
        this.createdAt = menu.getCreatedAt();
        this.modifiedAt = menu.getModifiedAt();
    }

}
