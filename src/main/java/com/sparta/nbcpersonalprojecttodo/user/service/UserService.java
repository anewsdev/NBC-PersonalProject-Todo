package com.sparta.nbcpersonalprojecttodo.user.service;

import com.sparta.nbcpersonalprojecttodo.user.dto.UserRequestDto;
import com.sparta.nbcpersonalprojecttodo.user.dto.UserResponseDto;
import com.sparta.nbcpersonalprojecttodo.user.entity.User;
import com.sparta.nbcpersonalprojecttodo.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    //유저 생성
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = new User(requestDto);
        return new UserResponseDto(userRepository.save(user));
    }

    //전체 유저 조회
    public List<UserResponseDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponseDto(user.getId(), user.getUsername(), user.getEmail(), user.getCreatedAt(), user.getModifiedAt()))
                .collect(Collectors.toList());
    }

    //유저 수정

    //유저 삭제
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
    }
}
