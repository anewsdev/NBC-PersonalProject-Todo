package com.sparta.nbcpersonalprojecttodo.service;

import com.sparta.nbcpersonalprojecttodo.dto.UserRequestDto;
import com.sparta.nbcpersonalprojecttodo.dto.UserResponseDto;
import com.sparta.nbcpersonalprojecttodo.entity.User;
import com.sparta.nbcpersonalprojecttodo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    @Transactional
    public UserResponseDto createUser(UserRequestDto requestDto) {
        User user = new User(requestDto);
        return new UserResponseDto(userRepository.save(user));
    }

    @Transactional
    public List<UserResponseDto> getAllUser() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(UserResponseDto::new)
                .collect(Collectors.toList());
    }
}
