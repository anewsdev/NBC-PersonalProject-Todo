package com.sparta.nbcpersonalprojecttodo.controller;

import com.sparta.nbcpersonalprojecttodo.dto.TodoRequestDto;
import com.sparta.nbcpersonalprojecttodo.dto.TodoResponseDto;
import com.sparta.nbcpersonalprojecttodo.service.TodoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/todo")
public class TodoController {

    //TodoService 연결
    private final TodoService todoService;

    //일정 생성하기
    @PostMapping
    public TodoResponseDto createTodo(@RequestBody TodoRequestDto requestDto){
        return todoService.createTodo(requestDto);
    }

    //일정 조회하기
    @GetMapping
    public List<TodoResponseDto> getTodo(){
        return todoService.getTodo();
    }

    @PutMapping("/{todoId}")
    public Long updateTodo(@PathVariable Long todoId, @RequestBody TodoRequestDto requestDto) {
        return todoService.updateTodo(todoId, requestDto);
    }

    @DeleteMapping("/{todoId}")
    public Long deleteTodo(@PathVariable Long todoId){
        return todoService.deleteTodo(todoId);
    }

}
