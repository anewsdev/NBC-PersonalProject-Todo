package com.sparta.nbcpersonalprojecttodo.todo.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class TodoRequestDto {
    @NotBlank(message = "제목은 필수입니다")
    @Size(max = 100, message = "제목은 100자 이하여야 합니다")
    private String title;

    @NotBlank(message = "내용은 필수입니다")
    @Size(max = 500, message = "내용은 500자 이하여야 합니다")
    private String content;
}