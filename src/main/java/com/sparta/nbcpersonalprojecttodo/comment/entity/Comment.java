package com.sparta.nbcpersonalprojecttodo.comment.entity;

import com.sparta.nbcpersonalprojecttodo.comment.dto.CommentRequestDto;
import com.sparta.nbcpersonalprojecttodo.common.entity.Timestamped;
import com.sparta.nbcpersonalprojecttodo.todo.entity.Todo;
import com.sparta.nbcpersonalprojecttodo.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "comment")
public class Comment extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    public Comment(CommentRequestDto requestDto, User user, Todo todo) {
        this.content = requestDto.getContent();
        this.user = user;
        this.todo = todo;
    }

    public void update(String content) {
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTodo(Todo todo) {
        this.todo = todo;
    }
}
