package com.sparta.nbcpersonalprojecttodo.entity;

import com.sparta.nbcpersonalprojecttodo.dto.CommentRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "comment")
public class Comment extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false, length = 500)
    private String content;

    @Column(name = "username", nullable = false)
    private String username;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "todo_id", nullable = false)
    private Todo todo;

    public Comment(CommentRequestDto requestDto) {
        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
    }
}
