package com.sparta.nbcpersonalprojecttodo.user.entity;

import com.sparta.nbcpersonalprojecttodo.user.dto.UserRequestDto;
import com.sparta.nbcpersonalprojecttodo.common.entity.Timestamped;
import com.sparta.nbcpersonalprojecttodo.userTodo.entity.UserTodo;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "user")
public class User extends Timestamped {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Email(message = "이메일 형식이 올바르지 않습니다.")
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Column(name = "email", nullable = false)
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<UserTodo> userTodos = new ArrayList<>();

    public User(UserRequestDto userRequestDto) {
        this.username = userRequestDto.getUsername();
        this.email = userRequestDto.getEmail();
    }
}
