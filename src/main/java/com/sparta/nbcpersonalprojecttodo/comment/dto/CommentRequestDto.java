package com.sparta.nbcpersonalprojecttodo.comment.dto;

import lombok.Getter;

@Getter
public class CommentRequestDto {
    private String content;
    private Long userId;
    private Long todoId;
}
