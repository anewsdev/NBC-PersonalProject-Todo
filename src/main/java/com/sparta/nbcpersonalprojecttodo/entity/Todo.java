package com.sparta.nbcpersonalprojecttodo.entity;

import com.sparta.nbcpersonalprojecttodo.dto.TodoRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


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

    @Column(name ="content", nullable = false, length = 500)
    private String content;

    @Column(name = "username" , nullable = false)
    private String username;

    public Todo(TodoRequestDto requestDto){
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
    }

    public void update(TodoRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.content = requestDto.getContent();
        this.username = requestDto.getUsername();
    }
}
