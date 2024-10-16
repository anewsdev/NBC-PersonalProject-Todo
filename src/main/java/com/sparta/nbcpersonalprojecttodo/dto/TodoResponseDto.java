package com.sparta.nbcpersonalprojecttodo.dto;

import com.sparta.nbcpersonalprojecttodo.entity.Todo;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@Getter
public class TodoResponseDto {
    private Long id;
    private String title;
    private String content;
    private String username;
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int commentCount;

    public TodoResponseDto(Todo todo){
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.username = todo.getUsername();
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
        this.commentCount = todo.getComments() != null ? todo.getComments().size() : 0;
    }
}

