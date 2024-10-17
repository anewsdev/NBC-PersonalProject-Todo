package com.sparta.nbcpersonalprojecttodo.user.controller;

import com.sparta.nbcpersonalprojecttodo.user.dto.UserRequestDto;
import com.sparta.nbcpersonalprojecttodo.user.dto.UserResponseDto;
import com.sparta.nbcpersonalprojecttodo.user.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    //유저 생성
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto){
        return userService.createUser(requestDto);
    }

    //전체 유저 조회
    @GetMapping
    public List<UserResponseDto> getAllUsers(){
        return userService.getAllUsers();
    }

    //유저 삭제
    @DeleteMapping("/{userId}")
    public void deleteUser(@RequestParam Long userId){
        userService.deleteUser(userId);
    }

}
