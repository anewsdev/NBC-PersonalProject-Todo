package com.sparta.nbcpersonalprojecttodo.user.dto;

import com.sparta.nbcpersonalprojecttodo.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class UserResponseDto {
    private Long id;                  // 사용자 ID
    private String username;          // 사용자 이름
    private String email;             // 사용자 이메일
    private List<String> assignedTodos; // 할당된 할 일 목록
    private LocalDateTime createdAt;  // 생성일
    private LocalDateTime modifiedAt; // 수정일

    public UserResponseDto(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.assignedTodos = user.getUserTodos() != null
                ? user.getUserTodos().stream()
                .map(ut -> ut.getTodo().getTitle())
                .collect(Collectors.toList())
                : Collections.emptyList();
        this.createdAt = user.getCreatedAt();
        this.modifiedAt = user.getModifiedAt();
    }

    public UserResponseDto(User user, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.email = user.getEmail();
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }

    public UserResponseDto(Long id, String username, String email, LocalDateTime createdAt, LocalDateTime modifiedAt) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
    }
}
