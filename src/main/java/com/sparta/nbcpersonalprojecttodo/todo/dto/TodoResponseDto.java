package com.sparta.nbcpersonalprojecttodo.todo.dto;

import com.sparta.nbcpersonalprojecttodo.todo.entity.Todo;
import com.sparta.nbcpersonalprojecttodo.user.entity.User;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TodoResponseDto {
    private Long id;
    private String title; //할 일 제목
    private String content; //할 일 내용
    private String creatorUsername; //일정 생성 유저
    private List<String> assignedUsers; //일정 할당 유저
    private LocalDateTime createdAt;
    private LocalDateTime modifiedAt;
    private int commentCount;

    // Todo 엔티티에서 값을 가져와서 Dto에 매핑
    public TodoResponseDto(Todo todo) {
        this.id = todo.getId();
        this.title = todo.getTitle();
        this.content = todo.getContent();
        this.creatorUsername = todo.getCreator().getUsername();
        this.assignedUsers = todo.getAssignedUsers().stream()
                .map(ut -> ut.getUser().getUsername())
                .collect(Collectors.toList());
        this.createdAt = todo.getCreatedAt();
        this.modifiedAt = todo.getModifiedAt();
        this.commentCount = todo.getComments() != null ? todo.getComments().size() : 0;
    }

    public TodoResponseDto(Long id, String title, String content, User creator, List<User> assignedUsers) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.creatorUsername = creator.getUsername();  // User 엔티티에서 username 설정
        this.assignedUsers = assignedUsers.stream()    // User 리스트에서 각 유저의 username 추출
                .map(User::getUsername)
                .collect(Collectors.toList());
        this.createdAt = LocalDateTime.now();          // 현재 시간으로 생성일 설정
        this.modifiedAt = LocalDateTime.now();         // 현재 시간으로 수정일 설정
        this.commentCount = 0;                         // 댓글 수는 기본값 0
    }
}