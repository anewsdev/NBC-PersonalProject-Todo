package com.sparta.nbcpersonalprojecttodo.entity;

import com.sparta.nbcpersonalprojecttodo.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "todo")
public class Todo extends Timestamped {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    // 작성한 유저를 나타내는 필드
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User creator;  // 작성 유저

    // Todo와 유저의 N:M 관계를 위한 중간 테이블
    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<UserTodo> assignedUsers;  // 담당 유저들

    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments;

    public Todo(TodoRequestDto requestDto, User creator) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.creator = creator;
    }

    public void update(TodoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
    }
}