package com.sparta.nbcpersonalprojecttodo.todo.controller;

import com.sparta.nbcpersonalprojecttodo.todo.dto.TodoRequestDto;
import com.sparta.nbcpersonalprojecttodo.todo.dto.TodoResponseDto;
import com.sparta.nbcpersonalprojecttodo.todo.service.TodoService;
import jakarta.validation.Valid;
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
    public TodoResponseDto createTodo(@RequestBody @Valid TodoRequestDto requestDto, @RequestParam Long creatorId) {
        return todoService.createTodo(requestDto, creatorId);
    }

    //일정 페이징 조회(전체조회)
    @GetMapping()
    public List<TodoResponseDto> getPagedTodo(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ) {
        return todoService.getPagedTodo(page, size);
    }

    //일정 단건 조회
    @GetMapping("/{todoId}")
    public TodoResponseDto getTodoById(@PathVariable Long todoId){
        return todoService.getTodoById(todoId);
    }


    //일정 수정
    @PutMapping("/{todoId}")
    public TodoResponseDto updateTodo(@PathVariable Long todoId, @RequestBody @Valid TodoRequestDto requestDto) {
        return todoService.updateTodo(todoId, requestDto);
    }
    //일정 삭제
    @DeleteMapping("/{todoId}")
    public void deleteTodo(@PathVariable Long todoId) {
        todoService.deleteTodo(todoId);
    }

}
//일정 조회하기
//    @GetMapping
//    public List<TodoResponseDto> getTodo(){
//        return todoService.getTodo();
//    }