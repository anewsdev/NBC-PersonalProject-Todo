package com.sparta.nbcpersonalprojecttodo.entity;

import com.sparta.nbcpersonalprojecttodo.dto.UserRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User extends Timestamped{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "email", nullable = false)
    private String email;

    @ManyToMany(mappedBy = "responsibleUsers", fetch = FetchType.LAZY)
    private List<Todo> todos;

    public User(String username, String email) {
        this.username = username;
        this.email = email;
    }

    public User(UserRequestDto requestDto) {
        this.username = requestDto.getUsername();
        this.email = requestDto.getEmail();
    }
}
