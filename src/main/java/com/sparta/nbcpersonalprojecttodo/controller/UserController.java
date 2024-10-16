package com.sparta.nbcpersonalprojecttodo.controller;

import com.sparta.nbcpersonalprojecttodo.dto.UserRequestDto;
import com.sparta.nbcpersonalprojecttodo.dto.UserResponseDto;
import com.sparta.nbcpersonalprojecttodo.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/user")
public class UserController {

    private final UserService userService;

    //유저생성
    @PostMapping
    public UserResponseDto createUser(@RequestBody UserRequestDto requestDto){
        return userService.createUser(requestDto);
    }



    //유저 단건조회

    //유저 수정

    //유저 삭제



}
