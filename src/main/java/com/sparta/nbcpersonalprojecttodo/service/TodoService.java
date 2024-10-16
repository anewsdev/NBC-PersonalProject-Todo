package com.sparta.nbcpersonalprojecttodo.service;

import com.sparta.nbcpersonalprojecttodo.dto.TodoRequestDto;
import com.sparta.nbcpersonalprojecttodo.dto.TodoResponseDto;
import com.sparta.nbcpersonalprojecttodo.entity.Todo;
import com.sparta.nbcpersonalprojecttodo.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;


    public TodoResponseDto createTodo(TodoRequestDto requestDto) {
        Todo todo = new Todo(requestDto);
        return new TodoResponseDto(todoRepository.save(todo));
    }

    public List<TodoResponseDto> getTodo() {
        return todoRepository.findAll().stream()
                .map(TodoResponseDto::new)
                .collect(Collectors.toList());
    }


    @Transactional
    public Long updateTodo(Long id, TodoRequestDto requestDto) {
        Todo todo = findTodo(id);
        todo.update(requestDto);
        return id;
    }

    public Long deleteTodo(Long id) {
        Todo todo = findTodo(id);
        todoRepository.delete(todo);
        return id;
    }

    private Todo findTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("일정을 찾을 수 없습니다.")
        );
    }

}
