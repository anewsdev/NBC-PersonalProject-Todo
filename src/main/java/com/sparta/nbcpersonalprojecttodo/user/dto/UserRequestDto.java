package com.sparta.nbcpersonalprojecttodo.user.dto;

import jakarta.validation.constraints.*;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserRequestDto {
    @NotBlank(message = "사용자 이름은 필수입니다")
    @Size(min = 3, max = 20, message = "사용자 이름은 3자 이상 20자 이하여야 합니다")
    private String username;

    @NotBlank(message = "이메일은 필수입니다")
    @Email(message = "올바른 이메일 형식이 아닙니다")
    private String email;
}