package com.sparta.nbcpersonalprojecttodo.comment.dto;

import jakarta.validation.constraints.*;
import lombok.Getter;

@Getter
public class CommentRequestDto {
    @NotBlank(message = "댓글 내용은 필수입니다")
    @Size(max = 200, message = "댓글 내용은 200자 이하여야 합니다")
    private String content;

    @NotNull(message = "사용자 ID는 필수입니다")
    @Positive(message = "사용자 ID는 양수여야 합니다")
    private Long userId;

    @NotNull(message = "할일 ID는 필수입니다")
    @Positive(message = "할일 ID는 양수여야 합니다")
    private Long todoId;
}