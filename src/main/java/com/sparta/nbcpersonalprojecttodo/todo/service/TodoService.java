package com.sparta.nbcpersonalprojecttodo.todo.service;

import com.sparta.nbcpersonalprojecttodo.todo.dto.TodoRequestDto;
import com.sparta.nbcpersonalprojecttodo.todo.dto.TodoResponseDto;
import com.sparta.nbcpersonalprojecttodo.todo.entity.Todo;
import com.sparta.nbcpersonalprojecttodo.user.entity.User;
import com.sparta.nbcpersonalprojecttodo.todo.repository.TodoRepository;
import com.sparta.nbcpersonalprojecttodo.user.repository.UserRepository;
import com.sparta.nbcpersonalprojecttodo.userTodo.repository.UserTodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;
    private final UserRepository userRepository;
    private final UserTodoRepository userTodoRepository;

    //일정 생성
    public TodoResponseDto createTodo(TodoRequestDto requestDto, Long creatorId) {
        User creator = userRepository.findById(creatorId)
                .orElseThrow(() -> new RuntimeException("User not found")); // 유저 확인

        Todo todo = new Todo(requestDto, creator);
        todoRepository.save(todo);
        return new TodoResponseDto(todo);
    }

    //전체조회(삭제대기)
    public List<TodoResponseDto> getTodo() {
        return todoRepository.findAll().stream()
                .map(TodoResponseDto::new)
                .collect(Collectors.toList());
    }

    //페이징 처리된 일정 조회 메서드
    public List<TodoResponseDto> getPagedTodo(int page, int size) {
        //페이지 번호, 사이즈 파라미터로 전달
        Pageable pageable = PageRequest.of(page, size, Sort.by(Sort.Direction.DESC, "modifiedAt"));
        //페이징 처리된 결과 반환
        Page<Todo> todos = todoRepository.findAll(pageable);

        return todos.map(TodoResponseDto::new).stream().toList();
    }

    //일정 단건조회
    public TodoResponseDto getTodoById(Long todoId) {
        Todo todo = todoRepository.findById(todoId)
                .orElseThrow(()-> new IllegalArgumentException("일정을 찾을 수 없습니다."));
        List<String> assignedUsername = todo.getAssignedUsers()
                .stream()
                .map(ut-> ut.getUser().getUsername())
                .collect(Collectors.toList());
        return new TodoResponseDto(todo);
    }


    //일정 수정
    @Transactional
    public TodoResponseDto updateTodo(Long todoId, TodoRequestDto requestDto) {
        Todo todo = todoRepository.findById(todoId)
                        .orElseThrow(()-> new IllegalArgumentException("일정이 없습니다."));
        todo.update(requestDto);
        todoRepository.save(todo);

        List<String> assignedUsernames = todo.getAssignedUsers()
                .stream()
                .map(ut -> ut.getUser().getUsername())
                .collect(Collectors.toList());

        return new TodoResponseDto(todo);
    }

    //일정 삭제
    public void deleteTodo(Long id) {
        Todo todo = findTodo(id);
        todoRepository.delete(todo);
    }

    private Todo findTodo(Long id) {
        return todoRepository.findById(id).orElseThrow(() ->
                new IllegalArgumentException("일정을 찾을 수 없습니다.")
        );
    }




}
